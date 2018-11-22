import java.util.*;
import java.text.SimpleDateFormat;
import java.io.*;




public class Main {
  public static void main(String[] args) {
    Gestionnaire gestionnaire = new Gestionnaire();
    gestionnaire.add("@hello",Hello.class);
    gestionnaire.getClass("@hello",args);
      System.out.println(gestionnaire.getClass("@hello",args));



  }

}







/*
try(Scanner sc = new Scanner(System.in)){
if (!args[0].equals("-p")) {
System.out.println("No pseudo");
System.exit(1);
}

while(true) {
System.out.print("["+args[1]+"]:");
String str = sc.nextLine();




}
}
}
*/
