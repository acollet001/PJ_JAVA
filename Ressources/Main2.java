import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.*;
public class Main2 {
	public static void main(String[] args) {
		try {
			Main2.call_me();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void call_me() throws Exception {
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
		// get the title
		JSONObject value = json.getJSONObject("value");
		// get the joke
		String joke = value.getString("joke");
		System.out.println(joke);
	}
}
