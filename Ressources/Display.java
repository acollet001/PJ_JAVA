import java.util.*;
import java.text.SimpleDateFormat;



public class Display {
  Scanner sc = new Scanner(System.in);



  public String name(String user){
      System.out.print("["+user+"]:");
      String str = sc.nextLine();
      return str;
  }


}