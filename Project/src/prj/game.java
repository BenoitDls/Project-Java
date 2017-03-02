package prj;

import java.util.Random;
import java.util.Scanner;

public class game {

	public static void main(String[] args) {
	
		System.out.println("Règles du jeu :\n"
				+ "L'utilisateur doit déduire des quatres mot affiché l'idée ou le mot approprié.\n"
				+ "Pour donner le mot exact, il devra sélectionner parmi les lettres qui lui sont proposées.\n");
		Scanner scan = new Scanner(System.in);
		String speudo;
		int score = 0 ;
		do {
			System.out.println("Entré votre Speudo :");
			speudo = scan.nextLine();
			while (speudo.length() < 3) { //si le speudo est inférieur a 3 lettres, le speudo est redemandé
				System.out.println("Votre Speudo est trop court. Veuillez entré votre Speudo :");
				speudo = scan.nextLine();
			}
		} while (speudo.length() < 3);

		System.out.println("Bonjour " + speudo + "! Voulez commencer le jeu ? (O/N)");
		String ouiOuNon = scan.nextLine();
		String ouiOuNon2;
		String oui = "o";
		String non = "n";

		while (!oui.equalsIgnoreCase(ouiOuNon) && (!non.equalsIgnoreCase(ouiOuNon))) { //seul les reponse o ou n sont accepté
			System.out.println("\nSelectionner O ou N :");
			ouiOuNon = scan.nextLine();
		}

		if (ouiOuNon.equalsIgnoreCase(oui)) { //debut du jeu
			
			//choix du jeu au hasard
			do {			
				int min = 0;
				int max = 6; //modifier la valeur suivant le nombre de possiblité de jeu dans le tableau
				int r = min + (int) (Math.random() * ((max - min) + 1));
				int choixJeu = r; //valeur qui détermine le choix du jeu, la ligne du tableau

				String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
						"q", "r", "s", "t", "w", "x", "y", "z" };
				
				// tableau chaque ligne correspond a un jeu dofférent 
				// la cinquième valeur dune ligne correspond tounours a la reponse
				// la sixieme valeur correspond toujour au nombre de lettre de la réponse
				String jeu[][] = { { "Pomme", "Fraise", "Pêche", "Cerise", "Fruit", "5" },
						{ "Epinard", "Carrotte", "Pomme de terre", "Courge", "Légume", "6" },
						{ "France", "Russie", "Mexique", "Allemagne", "Pays", "4" },
						{ "Vert", "Violet", "Orange", "Blanc", "Couleur", "7" },
						{ "Tennis", "Natation", "Danse", "Athlétisme", "Sport", "5" },
						{ "Lion", "Guépard", "Panterre", "Crocodile", "Animal", "7" } };

				String reponseJeu = jeu[choixJeu][4]; //case du tableau correspondant a la reponse du jeu 
				String lettreJeu = jeu[choixJeu][5];

				//affiche les mot du jeu 
				System.out.println("\n1." + jeu[choixJeu][0] + " 2." + jeu[choixJeu][1] + " 3." + jeu[choixJeu][2]
						+ " 4." + jeu[choixJeu][3]);
				System.out
						.println("\nLe mot est constitué de " + lettreJeu + " lettres parmis les lettre suivantes : ");
				System.out.println("Le mot est :");
				String reponse = scan.nextLine();

				if (reponse.equalsIgnoreCase(reponseJeu)) {
					score ++;
					System.out.println("Bravo vous avez trouver la bonne réponse!\n");//si la premiere reponse est bonne 

				} else { //si la premiere reponse est fausse
					String reponse2;
					do {
						System.out.println("Mauvaise réponse! \nLe mot est :");
						reponse2 = scan.nextLine();
					} while (!reponse2.equalsIgnoreCase(reponseJeu)); //si une des reponses suivantes est bonne 
					score ++;
					System.out.println("Bravo vous avez trouver la bonne réponse!\n");
				}

				System.out.println("Voulez vous rejouez ? (O/N)");
				ouiOuNon2 = scan.nextLine();

				while (!oui.equalsIgnoreCase(ouiOuNon2) && (!non.equalsIgnoreCase(ouiOuNon2))) {
					System.out.println("\nSelectionner O ou N :");
					ouiOuNon2 = scan.nextLine();
				}

			} while (ouiOuNon2.equalsIgnoreCase(oui));
			System.out.println("Bien joué " + speudo + " vous avez totalisé un score de " + score + " points!");
			System.out.println("Fin du jeu!");

		}

		else {
			System.out.println("Fin du jeu.");
		}
		scan.close();

	}

}

