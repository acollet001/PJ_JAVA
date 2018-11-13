import java.util.*;
import java.text.SimpleDateFormat;

public class Chatbot {
  public static void main(String[] args) {
	  try(Scanner sc = new Scanner(System.in)){
      if (!args[0].equals("-p")) {
        System.out.println("No pseudo");
        System.exit(1);
      }
      while(true) {
        System.out.print("["+args[1]+"]:");
        String str = sc.nextLine();
        if(str.equals("@hello")){
          String pattern = "EEEEE dd MMMMM 'et il est' HH'h'mm";
          SimpleDateFormat simpleDateFormat= new SimpleDateFormat(pattern, new Locale("fr", "FR"));
          String date=simpleDateFormat.format(new Date());
          System.out.println("Salut "+args[1]+ "! Nous sommes "+ date);
        }
        if(str.equals("++")){
          System.exit(1);
        }
      }
	  }
    }
}
