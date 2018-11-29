import java.util.*;

public class Display {
  Scanner sc = new Scanner(System.in);



  public String name(String user){
      System.out.print("["+user+"]:");
      String [] mots = decoupe();
      return mots;
  }


private String[] decoupe(){

  String str = sc.nextLine();
  final String SEPARATEUR = " ";
  String [] mots = str.split(SEPARATEUR);
  System.out.println(mots.remove(0));
return mots;
}

public String firstArg(String[] arg){
  String str =arg[0];
return str;
}






}
