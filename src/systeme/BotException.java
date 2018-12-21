package systeme;

public class BotException extends Exception{

	public BotException(String error){
		System.out.println("[System] Je ne connais pas le chatbot "+error+"!");
	}
}
