import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import org.json.*;
import java.util.*;

public class Quizz extends Chatbot {
  Scanner sc = new Scanner(System.in);


  public void send(String[] args, String[] argbot) throws Exception{
    int arg1=checkArg(argbot);
    int compteur=0;
    if (arg1!=-1){
      int j=0;
      while (j<arg1){
        try{
          String url = "https://opentdb.com/api.php?amount=1";
          URL obj = new URL(url);
          HttpURLConnection con = (HttpURLConnection) obj.openConnection();
          con.setRequestMethod("GET");
          BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
          String inputLine;
          StringBuffer response = new StringBuffer();
          while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
          }
          in.close();
          JSONObject json = new JSONObject(response.toString());
          JSONArray results = json.getJSONArray("results");
          String question = results.getJSONObject(0).getString("question");
          String correct=results.getJSONObject(0).getString("correct_answer");
          JSONArray incorrect = results.getJSONObject(0).getJSONArray("incorrect_answers");
          System.out.println("[Quizz]: "+question);
          ArrayList<String> tab= toList(incorrect);
          tab.add(correct);
          Collections.shuffle(tab);
          int corr = placeCorrect(tab,correct);
          printList(tab);
          int arg2=-1;
          //String str;
          while (arg2==-1){
            String str = sc.nextLine();
            final String SEPARATEUR = " ";
            String [] mots = str.split(SEPARATEUR);
            arg2=checkArg(mots);

          if (arg2!=-1){
            if (Integer.parseInt(str)==corr){
              System.out.println("Bonne réponse!");
              compteur++;
            }
            else{
              System.out.println("Mauvaise réponse! La bonne réponse était "+correct);
            }
          }
        }
        }catch(Exception e){
          e.printStackTrace();
        }
        j++;
      }
      System.out.println("Vous avez "+compteur+" bonne(s) réponse sur "+arg1+" question(s) !");
    }
  }



  private ArrayList toList (JSONArray array) {
    int len=array.length();
    ArrayList<String> arrList = new ArrayList<String>();
    int i=0;
    while (i<len){
      arrList.add(array.getString(i));
      i++;
    }
    return arrList;
  }


  private void printList (  ArrayList<String> tab ) {
    int i=0;
    while (i<tab.size()){
      System.out.println("  -"+(i+1)+": "+tab.get(i));
      i++;
    }
  }


  private int placeCorrect (  ArrayList<String> tab,String cor ) {
    int i=0;
    while (i<tab.size()){
      if (tab.get(i)==cor){
        return i+1;
      }
      i++;
    }
    return 0;
  }



  private int checkArg(String[] argbot){
    if (argbot.length==0){
      return 1;
    }
    if (argbot.length>1){
      System.out.println("[Quizz] Je ne prend qu'un seul argument !");
      return -1;
    }
    try{
      int arg1 =Integer.parseInt(argbot[0],10);
      if (arg1<1) {
        System.out.println("[Quizz] Mon argument est un entier positif! Je ne sais pas quoi faire avec "+argbot[0]);
        return -1;
      }
      return arg1;
    }catch (Exception e){
      System.out.println("[Quizz] Mon argument est un entier positif! Je ne sais pas quoi faire avec "+argbot[0]);
      return -1;
    }
  }

}








//
