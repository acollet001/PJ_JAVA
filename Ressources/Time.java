import java.util.*;
import java.text.SimpleDateFormat;
import java.io.*;



public class Time extends Chatbot {


public void send(String[] args){
String pattern = "EEEEE dd MMMMM 'et il est' HH'h'mm";
SimpleDateFormat simpleDateFormat= new SimpleDateFormat(pattern, new Locale("fr", "FR"));
String date=simpleDateFormat.format(new Date());
System.out.println("Nous sommes "+ date);

}
}
