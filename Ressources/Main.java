public class Main {
  public static void main(String[] args) {
    Gestionnaire gestionnaire = new Gestionnaire();
    User user=new User();
    Display display = new Display();

    gestionnaire.add("@hello",Hello.class);
    gestionnaire.add("@time",Time.class);


    user.verif(args);
    while(true){
      String line = display.name(user.getName());
      user.exit(line);
      try{
        Chatbot bot=gestionnaire.getClass(line,args);
        bot.send(args);
      }catch(Exception e){}

      }

    }
  }
