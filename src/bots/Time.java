package bots;

import java.util.*;
import java.text.SimpleDateFormat;

import systeme.ArgbotException;

public class Time extends Chatbot {

	public void send(String[] args, String[] argsbot) throws ArgbotException{
		if (argsbot.length>0) {
			throw new ArgbotException("Hello");
		}

		else {
			String date=date();
			System.out.println("[Time] Nous sommes "+ date + ".");
		}
	}


	/* ----- Retourne la date ------ */
	private String date(){
		String pattern = "EEEEE dd MMMMM 'et il est' HH'h'mm";
		SimpleDateFormat simpleDateFormat= new SimpleDateFormat(pattern, new Locale("fr", "FR"));
		String date=simpleDateFormat.format(new Date());
		return date;
	}



}
