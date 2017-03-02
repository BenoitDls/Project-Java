package prj;

import java.util.Scanner;

public class game {

	public static void main(String[] args) {

		System.out.println("R�gles du jeu :\n"
				+ "L'utilisateur doit d�duire des quatres mot affich� l'id�e ou le mot appropri�.\n"
				+ "Pour donner le mot exact, il devra s�lectionner parmi les lettres qui lui sont propos�es.\n");
		Scanner scan = new Scanner(System.in);

		String speudo;
		int scoreTotal = 0;

		do {
			System.out.println("Entr� votre Speudo :");
			speudo = scan.nextLine();
			// si le speudo est inf�rieur a 3 lettres, le speudo est redemand�
			while (speudo.length() < 3) {
				System.out.println("Votre Speudo est trop court. Veuillez entr� votre Speudo :");
				speudo = scan.nextLine();
			}
		} while (speudo.length() < 3);

		System.out.println("Bonjour " + speudo + "! Veux tu commencer le jeu ? (O/N)");
		String ouiOuNon = scan.nextLine();
		String ouiOuNon2;
		String oui = "o";
		String non = "n";

		// seul les reponse o ou n sont accept�
		while (!oui.equalsIgnoreCase(ouiOuNon) && (!non.equalsIgnoreCase(ouiOuNon))) {
			System.out.println("\nSelectionner O ou N :");
			ouiOuNon = scan.nextLine();
		}

		// debut du jeu
		if (ouiOuNon.equalsIgnoreCase(oui)) {
			// choix du jeu au hasard
			do {
				int min = 0;
				// modifier la valeur suivant le nombre de possiblit� de jeu
				// dans le tableau
				int max = 5;
				int r = min + (int) (Math.random() * ((max - min) + 1));
				// valeur qui d�termine le choix du jeu, la ligne du tableau
				int choixJeu = r;

				// tableau chaque ligne correspond a un jeu doff�rent
				// la cinqui�me valeur dune ligne correspond tounours a la
				// reponse
				// la sixieme valeur correspond toujour au nombre de lettre de
				// la r�ponse
				String jeu[][] = { { "Pomme", "Fraise", "P�che", "Cerise", "Fruit", "5" },
						{ "Epinard", "Carrotte", "Pomme de terre", "Courge", "L�gume", "6" },
						{ "France", "Russie", "Mexique", "Allemagne", "Pays", "4" },
						{ "Vert", "Violet", "Orange", "Blanc", "Couleur", "7" },
						{ "Tennis", "Natation", "Danse", "Athl�tisme", "Sport", "5" },
						{ "Lion", "Gu�pard", "Panterre", "Crocodile", "Animal", "7" } };

				// case du tableau correspondant a la reponse du jeu
				String reponseJeu = jeu[choixJeu][4];
				String lettreJeu = jeu[choixJeu][5];

				// affiche les mot du jeu
				System.out.println("\n1." + jeu[choixJeu][0] + " 2." + jeu[choixJeu][1] + " 3." + jeu[choixJeu][2]
						+ " 4." + jeu[choixJeu][3]);
				System.out
						.println("\nLe mot est constitu� de " + lettreJeu + " lettres parmis les lettre suivantes : ");
				System.out.println("Le mot est :");
				String reponse = scan.nextLine();

				int essaie = 0;

				// si la premiere reponse est bonne
				if (reponse.equalsIgnoreCase(reponseJeu)) {
					essaie++;
					System.out.println("Bravo vous avez trouver la bonne r�ponse!\n");
					if (essaie >= 3) {
						scoreTotal = scoreTotal + 1;
						System.out.println("Dommage tu as trouv� la r�ponse en plus de 3 essaies tu gagnes seulement 1 point");
					} else if (essaie == 2) {
						scoreTotal = scoreTotal + 2;
						System.out.println("Bravo tu as trouver la r�ponse en 2 essaies! tu gagnes 2 points.");
					} else if (essaie == 1) {
						scoreTotal = scoreTotal + 3;
						System.out.println("Bravo tu as trouver la r�ponse en 1 essaies! Tu gagnes 3 points.");
					}

					// si la premiere reponse est fausse
				} else {
					String reponse2;
					do {
						System.out.println("Mauvaise r�ponse! \nLe mot est :");
						reponse2 = scan.nextLine();
						essaie++;
						// si une des reponses suivantes est bonne
					} while (!reponse2.equalsIgnoreCase(reponseJeu));
					essaie++;
					if (essaie >= 3) {
						scoreTotal = scoreTotal + 1;
						System.out.println("Dommage tu as trouv� la r�ponse en plus de 3 essaies tu gagnes seulement 1 point");
					} else if (essaie == 2) {
						scoreTotal = scoreTotal + 2;
						System.out.println("Bravo tu as trouver la r�ponse en 2 essaies! tu gagnes 2 points.");
					} else if (essaie == 1) {
						scoreTotal = scoreTotal + 3;
						System.out.println("Bravo tu as trouver la r�ponse en 1 essaies! Tu gagnes 3 points.");
					}
				}
				System.out.println("Score : " + scoreTotal + "\n");

				System.out.println("Voulez vous rejouez ? (O/N)");
				ouiOuNon2 = scan.nextLine();

				while (!oui.equalsIgnoreCase(ouiOuNon2) && (!non.equalsIgnoreCase(ouiOuNon2))) {
					System.out.println("\nSelectionner O ou N :");
					ouiOuNon2 = scan.nextLine();
				}

			} while (ouiOuNon2.equalsIgnoreCase(oui));
			System.out.println("Bien jou� " + speudo + " vous avez totalis� un score de " + scoreTotal + " points!");
			System.out.println("\nFin du jeu!");

		}

		else {
			System.out.println("\nFin du jeu.");
		}
		scan.close();

	}

}