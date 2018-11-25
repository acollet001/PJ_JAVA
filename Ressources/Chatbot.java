import java.util.*;
import java.text.SimpleDateFormat;



public class Chatbot {

  public void send(String[] args){
    System.out.println("Salut "+args[1]+"!");
}
}










/*
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
*/
