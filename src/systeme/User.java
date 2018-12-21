package systeme;

public class User {
	private String name;
	
	// Ajout du nom
	private void setName(String name) {
		this.name=name;
	}
	
	// Récupération du nom
	public String getName() {
		return this.name;
	}
	
	// Verifie le lancement de la commande 
	public void verif(String [] args){
		if (!args[0].equals("-p")) {
			System.out.println("No pseudo");
			System.exit(1);
		}
		setName(args[1]);
	}

	// Exit
	public void exit(String str){
		if (str.equals("++")) {
			System.exit(1);
		}
	}

}
