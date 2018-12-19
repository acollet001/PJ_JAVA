import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import org.json.*;

public class Icndb extends Chatbot {
  public void send(String[] args, String[] argbot) throws Exception{
        int arg1=checkArg(argbot);
        if (arg1!=-1){
          int i=0;
          while (i<arg1){
            try{
              String url = "http://api.icndb.com/jokes/random";
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
              JSONObject value = json.getJSONObject("value");
              // get the joke
              String joke = value.getString("joke");
              System.out.println("[Icndb] "+joke);
            }catch(Exception e){
              e.printStackTrace();
            }
            i++;
            }
          }
        }





        private int checkArg(String[] argbot){
          if (argbot.length==0){
            return 1;
          }
          if (argbot.length>1){
            System.out.println("[Icndb] Je ne prend qu'un seul argument !");
            return -1;
          }
          try{
            int arg1 =Integer.parseInt(argbot[0],10);
            if (arg1<1) {
              System.out.println("[Icndb] Mon un argument est un entier positif! Je ne sais pas quoi faire avec "+argbot[0]);
              return -1;
            }
            return arg1;
          }catch (Exception e){
            System.out.println("[Icndb] Mon un argument est un entier positif! Je ne sais pas quoi faire avec "+argbot[0]);
            return -1;
          }
        }

      }
