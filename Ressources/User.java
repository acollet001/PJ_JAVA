public class User {
  private String name;

  private void setName(String name) {
    this.name=name;
  }

  public String getName() {
    return this.name;
  }

  public void verif(String [] args){
  if (!args[0].equals("-p")) {
    System.out.println("No pseudo");
    System.exit(1);
  }
  setName(args[1]);
}

public void exit(String str){
  if (str.equals("++")) {
    System.exit(1);
}
}

}
