package systeme;

import java.util.*;
import java.io.*;

import bots.Chatbot;

public class Gestionnaire {
	HashMap<String,Class> tab = new HashMap<String,Class>();

	// Permet d'ajouter un bot
	public void add(String bot , Class classe){
		this.tab.put(bot,classe);

	}

	// Return une classe de type bot en fonction de son nom
	public Chatbot getClass(String bot, String [] args) throws BotException{
		try{
			return (Chatbot) this.tab.get(bot).newInstance();
		}catch(Exception e){
			throw new BotException(bot);
		}
	}

}
