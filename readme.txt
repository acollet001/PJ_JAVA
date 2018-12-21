
******** DES BOTS ET ENCORE DES BOTS ******* 


----------------------------------------------
		Ville
----------------------------------------------

* Utilisation : @ville 

* Fonction : Permet à partir d'un code postal d'obtenir des informations sur la ville (nom de la ville, région, latitude et longitude). 

* API utilisée : Zippopotam



----------------------------------------------
		Image
----------------------------------------------

* Utilisation : @image 

* Fonction : Renvoie une image aléatoire. On peut alors choisir de la garder, d'en générer une autre ou de la mettre en noir et blanc. Si une nouvelle image est générée, les mêmes choix seront proposés (mise en noir et blanc, en générée une nouvelle ou la garder).

* API utilisée : Picsum


----------------------------------------------
		Météo
----------------------------------------------

* Utilisation : 

* Fonction : 

* API utilisée : 



****** CHANGEMENT DANS LA GESTION DES BOTS *******

La gestion des bots est effectuée grâce à la classe Gestionnaire, qui a pour attribut HashMap<String,Class>. Cela permet d'ajouter une infinité de bots avec seulement une ligne de code (gestionnaire.add("@ville", Ville.class);). Nous n'avons donc fait aucun autre changement. 
