public class Main {
  public static void main(String[] args) {
    Gestionnaire gestionnaire = new Gestionnaire();
    User user=new User();
    Display display = new Display();

    gestionnaire.add("@hello",Hello.class);
    gestionnaire.add("@time",Time.class);
    gestionnaire.add("@icndb",Icndb.class);
    gestionnaire.add("@quizz",Quizz.class);

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

        Chatbot bot=gestionnaire.getClass(name,args);
        bot.send(args, argsbot);

      }catch(Exception e){}

      }
    }
  }
