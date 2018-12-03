import java.util.*;

public class Display {
  Scanner sc = new Scanner(System.in);

  public String[] decoupeInput() {
    String str = sc.nextLine();
    final String SEPARATEUR = " ";
    String [] mots = str.split(SEPARATEUR);
    return mots;
  }

  public String firstArg(String[] arg){
    String str =arg[0];
    return str;
  }

  public String[] argsBot(String[] mots){
    int length=mots.length;
      String[] argbot=new String[length-1];
      for(int i = 0; i <length-1; i++) {
        argbot[i]=mots[i+1];
      }
    return argbot;
  }

  public void name(String user){
    System.out.print("["+user+"]:");
  }

}
