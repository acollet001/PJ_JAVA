package bots;

import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;


public class Image extends Chatbot {

  public void send(String[] args, String[] argsbot) throws Exception {

    int rep =2;

    try {

      // Récupèration d'une image aléatoire
      int nombre =random();
      get_img(nombre,  0);

      // Affichage de la question
      display_Q1();

      // Récupération réponse
      Scanner sc = new Scanner(System.in);
      String str = sc.nextLine();

      // Gestion de la réponse
      try{
        rep =Integer.parseInt(str,10);

        while (rep!=1 && rep!=3){

          // Génération d'une nouvelle image aléatoire
          if (rep==2){
            nombre =random();
            get_img(nombre,  0);
          }

          // Message d'erreur
          else {
            System.out.print("[Image] La réponse doit être 1 ou 2. Nouvelle réponse : ");
          }

          // Question
          display_Q1();
          str = sc.nextLine();
          try {
            rep =Integer.parseInt(str,10);
          }catch (Exception e){
            System.out.println("[Image] La réponse doit être un entier positif.");
          }
        }

      }catch (Exception e){
        System.out.println("[Image] La réponse doit être un entier positif.");
      }

      // Image en noir et blanc-
      if (rep==3){
        get_img(nombre,  1);
      }

    }catch(Exception e){
      e.printStackTrace();
    }
  }

  /* ---- Affichage de la question ---- */
  private void display_Q1(){
    System.out.println("[Image] Que voulez vous faire avec cette image ?");
    System.out.println("        1) Je veux la garder.");
    System.out.println("        2) Je prefere une autre image.");
    System.out.println("        3) Je veux la mettre en noir et blanc.");
    System.out.print("Réponse : ");
  }

  /* --- Géneration d'un nombre aléatoire --- */
  private int random(){
    Random rand = new Random();
    int nb_random= rand.nextInt(200 - 1+ 1) + 1;
    return nb_random;
  }

  /* ----- Obtention de l'image ------ */
  private void get_img(int nombre,  int NB){

    // Requête vers l'API Picsum
    String url;

    if (NB==0){
      url = "https://picsum.photos/200/300/?image=" + nombre;
    }

    else {
      url = "https://picsum.photos/g/200/300/?image=" + nombre;
    }

    try {
      URL obj = new URL(url);

      // Affichage de l'image
      JFrame frame = new JFrame( "Image" );
      JLabel label = new JLabel( new ImageIcon( obj ) );
      frame.getContentPane().add( label );
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      frame.pack();
      frame.setVisible( true );

    }catch(MalformedURLException e){ e.printStackTrace();}
  }
}
