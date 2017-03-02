package prj;

import java.util.Random;
import java.util.Scanner;

public class game {

	public static void main(String[] args) {
	
		System.out.println("R�gles du jeu :\n"
				+ "L'utilisateur doit d�duire des quatres mot affich� l'id�e ou le mot appropri�.\n"
				+ "Pour donner le mot exact, il devra s�lectionner parmi les lettres qui lui sont propos�es.\n");
		Scanner scan = new Scanner(System.in);
		
		String speudo;
		int scoreTotal = 0;
		int essaie = 0;
		int point = 0;
		
		do {
			System.out.println("Entr� votre Speudo :");
			speudo = scan.nextLine();
			while (speudo.length() < 3) { //si le speudo est inf�rieur a 3 lettres, le speudo est redemand�
				System.out.println("Votre Speudo est trop court. Veuillez entr� votre Speudo :");
				speudo = scan.nextLine();
			}
		} while (speudo.length() < 3);

		System.out.println("Bonjour " + speudo + "! Voulez commencer le jeu ? (O/N)");
		String ouiOuNon = scan.nextLine();
		String ouiOuNon2;
		String oui = "o";
		String non = "n";

		while (!oui.equalsIgnoreCase(ouiOuNon) && (!non.equalsIgnoreCase(ouiOuNon))) { //seul les reponse o ou n sont accept�
			System.out.println("\nSelectionner O ou N :");
			ouiOuNon = scan.nextLine();
		}

		if (ouiOuNon.equalsIgnoreCase(oui)) { //debut du jeu
			
			//choix du jeu au hasard
			do {			
				int min = 0;
				int max = 5; //modifier la valeur suivant le nombre de possiblit� de jeu dans le tableau
				int r = min + (int) (Math.random() * ((max - min) + 1));
				int choixJeu = r; //valeur qui d�termine le choix du jeu, la ligne du tableau

				String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
						"q", "r", "s", "t", "w", "x", "y", "z" };
				
				// tableau chaque ligne correspond a un jeu doff�rent 
				// la cinqui�me valeur dune ligne correspond tounours a la reponse
				// la sixieme valeur correspond toujour au nombre de lettre de la r�ponse
				String jeu[][] = { { "Pomme", "Fraise", "P�che", "Cerise", "Fruit", "5" },
						{ "Epinard", "Carrotte", "Pomme de terre", "Courge", "L�gume", "6" },
						{ "France", "Russie", "Mexique", "Allemagne", "Pays", "4" },
						{ "Vert", "Violet", "Orange", "Blanc", "Couleur", "7" },
						{ "Tennis", "Natation", "Danse", "Athl�tisme", "Sport", "5" },
						{ "Lion", "Gu�pard", "Panterre", "Crocodile", "Animal", "7" } };
				
			
				String reponseJeu = jeu[choixJeu][4]; //case du tableau correspondant a la reponse du jeu 
				String lettreJeu = jeu[choixJeu][5];

				//affiche les mot du jeu 
				System.out.println("\n1." + jeu[choixJeu][0] + " 2." + jeu[choixJeu][1] + " 3." + jeu[choixJeu][2]
						+ " 4." + jeu[choixJeu][3]);
				System.out
						.println("\nLe mot est constitu� de " + lettreJeu + " lettres parmis les lettre suivantes : ");
				System.out.println("Le mot est :");
				String reponse = scan.nextLine();

				if (reponse.equalsIgnoreCase(reponseJeu)) {
					essaie = 1;
					System.out.println("Bravo vous avez trouver la bonne r�ponse!\n");//si la premiere reponse est bonne 
					System.out.println(essaie);
					if (essaie >= 3){
						scoreTotal = scoreTotal + 1;
						System.out.println("Dommage tu as trouv� la r�ponse en plus de 3 essaies tu gagnes seulement 1 point");
					} else if (essaie == 2){
						scoreTotal = scoreTotal + 2;
						System.out.println("Bravo tu as trouver la r�ponse en 2 essaies! tu gagnes 2 points.");
					} else if (essaie == 1){
						scoreTotal = scoreTotal + 3;
						System.out.println("Bravo tu as trouver la r�ponse en 1 essaies! Tu gagnes 2 points.");
					}

				} else { //si la premiere reponse est fausse
					String reponse2;
					do {
						System.out.println("Mauvaise r�ponse! \nLe mot est :");
						reponse2 = scan.nextLine();
						essaie ++;
					} while (!reponse2.equalsIgnoreCase(reponseJeu)); //si une des reponses suivantes est bonne 
					essaie ++;
					System.out.println(essaie);
					if (essaie >= 3){
						scoreTotal = scoreTotal + 1;
						System.out.println("Dommage tu as trouv� la r�ponse en plus de 3 essaies tu gagnes seulement 1 point");
					} else if (essaie == 2){
						scoreTotal = scoreTotal + 2;
						System.out.println("Bravo tu as trouver la r�ponse en 2 essaies! tu gagnes 2 points.");
					} else if (essaie == 1){
						scoreTotal = scoreTotal + 3;
						System.out.println("Bravo tu as trouver la r�ponse en 1 essaies! Tu gagnes 2 points.");
					}
					System.out.println("Bravo vous avez trouver la bonne r�ponse en " + essaie + " essaies! Vous gagn� " + point +" points.");
				}
				System.out.println("Score : " + scoreTotal +"\n");

				System.out.println("Voulez vous rejouez ? (O/N)");
				ouiOuNon2 = scan.nextLine();

				while (!oui.equalsIgnoreCase(ouiOuNon2) && (!non.equalsIgnoreCase(ouiOuNon2))) {
					System.out.println("\nSelectionner O ou N :");
					ouiOuNon2 = scan.nextLine();
				}

			} while (ouiOuNon2.equalsIgnoreCase(oui));
			System.out.println("Bien jou� " + speudo + " vous avez totalis� un score de " + scoreTotal + " points!");
			System.out.println("Fin du jeu!");

		}

		else {
			System.out.println("Fin du jeu.");
		}
		scan.close();

	}

}

