import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import org.json.*;

public class Icndb extends Chatbot {
  public void send(String[] args,String[]argbot) throws Exception{
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
      System.out.println("[Icndb]"+joke);
    }catch(Exception e){
      e.printStackTrace();}
    }
  }
