package calculator;

import java.util.Scanner;

/**
 * @author Valentin Durand - TP1.1 - 1A - DUT Informatique - IUT Ifs
 * @Class Calculateur
 * @ May 8, 2014 4:29:47 PM
 */
public class Calculateur {
	static Scanner entree = new Scanner(System.in);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("|| Bienvenue sur le calculateur en notation post-fixee ||");
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");
		while(true){
			System.out.println("Veuillez entrer une formule (chaque element doit etre separe par un espace).");
			System.out.print("Voulez-vous afficher la pile des calculs effectués ? (Oui/Non) : ");
			String reponse = entree.nextLine();
			System.out.print("\n\nExpression a calculer : ");
			Expression e1=new Expression(entree.nextLine());
			String result = null;
			if(reponse.equals("Oui"))
				e1.showPile();
			Pile calculateur = new Pile(e1.taille);
			if(e1.calculable){
				result = e1.toStringInfix() + " = " + e1.calcule(calculateur, e1.ids);
				if(e1.divisible){
					System.out.println(result);
				}
			}
			System.out.println();
			System.out.println("\n\n *OVER*");
		}

	}

}
