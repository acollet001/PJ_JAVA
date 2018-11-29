import java.util.*;
import java.text.SimpleDateFormat;

public class Time extends Chatbot {

  private String date(){
    String pattern = "EEEEE dd MMMMM 'et il est' HH'h'mm";
    SimpleDateFormat simpleDateFormat= new SimpleDateFormat(pattern, new Locale("fr", "FR"));
    String date=simpleDateFormat.format(new Date());
    return date;
  }

  public void send(String[] args,String[]argbot){
    String date=date();
    System.out.println("[Time] Nous sommes "+ date);

  }
}
