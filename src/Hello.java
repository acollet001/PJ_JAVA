public class Hello extends Chatbot {

  public void send(String[] args, String[] argsbot) throws ArgbotException{
    if (argsbot.length>0) {
      throw new ArgbotException("Hello");
    }

    else {
      System.out.println("[Hello] Salut "+args[1]+"!");
    }
  }

}
