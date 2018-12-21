package bots;

import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;



// LE code postal de la ville nous permet de récupérer des informations sur la ville (nom, région, latitude et longitude)
public class Ville extends Chatbot {

	public void send(String[] args, String[] argsbot) throws Exception {

		String url=null;
		System.out.print("[Ville] Veuillez rentrer un code postal.");

		while (url==null){
			try {
				try {

					// Récupération du code postal
					System.out.print(" Code postal : ");
					Scanner sc = new Scanner(System.in);
					String CP = sc.nextLine();

					// Requête vers l'API Zippopotam
					url = "http://www.zippopotam.us/FR/" + CP;
					URL obj = new URL(url);
					HttpURLConnection con = (HttpURLConnection) obj.openConnection();
					con.setRequestMethod("GET");

					// Récupération du résultat de la requête
					BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
					String inputLine;
					StringBuffer response = new StringBuffer();
					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}
					in.close();

					// Traitement de la réponse
					JSONObject json = new JSONObject(response.toString());
					JSONArray places = json.getJSONArray("places");
					String ville = places.getJSONObject(0).getString("place name");
					String region =places.getJSONObject(0).getString("state");
					String longitude =places.getJSONObject(0).getString("longitude");
					String latitude =places.getJSONObject(0).getString("latitude");

					// Affichage
					System.out.println("[Ville]: La ville correspondant au code postal " + CP + " est " + ville + ". Elle se trouve dans la région " + region + ", a pour latitude " + latitude + " et pour longitude " + longitude + ".");

				}catch(java.io.FileNotFoundException ex){
					System.out.print("[Ville] Le code postal n'est pas connu, essayez à nouveau.");
					url=null;
				}

			}catch(Exception e){
				e.printStackTrace();
			}
		}

	}

}
