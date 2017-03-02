package prj;

import java.util.Random;
import java.util.Scanner;

public class jpp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Règles du jeu :\n"
				+ "L'utilisateur doit déduire des quatres mot affiché l'idée ou le mot approprié dans un minimum de temps.\n"
				+ "Pour donner le mot exact, il devra sélectionner parmi les lettres qui lui sont proposées.\n");
		Scanner scan = new Scanner(System.in);
		System.out.println("Commencer le jeu ? (O/N)");
		String jecpas = scan.nextLine();
		String jecpas2;
		String oui = "o";
		String non = "n";
		// if (jecpas.length() == "o".length()){

		while (!oui.equalsIgnoreCase(jecpas) && (!non.equalsIgnoreCase(jecpas))) {
			System.out.println("\nSelectionner O ou N :");
			jecpas = scan.nextLine();
		}

		if (jecpas.equalsIgnoreCase(oui)) {

			do {
				int min = 0;
				int max = 4;
				int r = min+(int)(Math.random()*((max-min) + 1));
				int choixJeu = r;
				System.out.println(r);
				
				String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","w","x","y","z"};
						
				String jeu[][] = { 
						{ "Pomme", "Fraise", "Pêche", "Cerise", "Fruit", "5" },
						{ "Epinard", "Carrotte", "Pomme de terre", "Courge", "Légume","6" },
						{ "Batman", "Spiderman", "Catwoman", "Deadpool", "Héros", "5" },
						{ "France", "Russie", "Mexique", "Allemagne", "Pays", "4" },
						{ "Vert", "Violet", "Orange", "Blanc", "Couleur", "7" },
						{ "Tennis", "Natation", "Danse", "Athlétisme", "Sport", "5" },
						{ "Lion", "Guépard", "Panterre", "Crocodile", "Animaux", "7" } };

				String reponseJeu = jeu[choixJeu][4];
				String lettreJeu = jeu[choixJeu][5];

				System.out.println("\n1." + jeu[choixJeu][0] + " 2." + jeu[choixJeu][1] + " 3." + jeu[choixJeu][2]
						+ " 4." + jeu[choixJeu][3]);
				System.out.println("\nLe mot est constitué de " + lettreJeu +" parmis les lettre suivantes : ");
				System.out.println("Le mot est :");
				String reponse = scan.nextLine();

				if (reponse.equalsIgnoreCase(reponseJeu)) {
					System.out.println("Bravo vous avez trouver la bonne réponse!\n");

				} else {
					String reponse2;
					do {
						System.out.println("Mauvaise réponse! \nLe mot est :");
						reponse2 = scan.nextLine();
					} while (!reponse2.equalsIgnoreCase(reponseJeu));
					System.out.println("Bravo vous avez trouver la bonne réponse!\n");
				}

				System.out.println("Voulez vous rejouez ? (O/N)");
				jecpas2 = scan.nextLine();

				while (!oui.equalsIgnoreCase(jecpas2) && (!non.equalsIgnoreCase(jecpas2))) {
					System.out.println("\nSelectionner O ou N :");
					jecpas2 = scan.nextLine();
				}

			} while (jecpas2.equalsIgnoreCase(oui));
			System.out.println("Fin du jeu!");

		}

		else {
			System.out.println("Fin du jeu!");
		}
		scan.close();

	}

}