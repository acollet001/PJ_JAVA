package systeme;

import bots.Hello;
import bots.Icndb;
import bots.Image;
import bots.Quizz;
import bots.Sound;
import bots.Time;
import bots.Ville;
import bots.Chatbot;

public class Main {
	public static void main(String[] args) {
		Gestionnaire gestionnaire = new Gestionnaire();
		User user=new User();
		Display display = new Display();
		
		// Ajout des bots
		gestionnaire.add("@hello",Hello.class);
		gestionnaire.add("@time",Time.class);
		gestionnaire.add("@icndb",Icndb.class);
		gestionnaire.add("@quizz",Quizz.class);
		gestionnaire.add("@ville", Ville.class);
		gestionnaire.add("@image", Image.class);

		user.verif(args);
		
		while(true){

			// Affichage
			display.name(user.getName());

			// Récupérattion de l'entrée clavier
			String[] line = display.decoupeInput();
			String name=display.firstArg(line);
			String[] argsbot=display.argsBot(line);

			// Gestion ++
			user.exit(name);

			try{
				// Exécution des bots
				Chatbot bot=gestionnaire.getClass(name,args);
				bot.send(args, argsbot);

			}catch(Exception e){}

		}
	}
}
