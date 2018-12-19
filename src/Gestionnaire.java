import java.util.*;
import java.io.*;


public class Gestionnaire {
      HashMap<String,Class> tab = new HashMap<String,Class>();


  public void add(String bot , Class classe){
    this.tab.put(bot,classe);

  }

  public Chatbot getClass(String bot, String [] args) throws BotException{
    try{
        return (Chatbot) this.tab.get(bot).newInstance();
      }catch(Exception e){
        throw new BotException(bot);
      }
  }

}