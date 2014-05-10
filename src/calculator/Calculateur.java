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
			System.out.println("Veuillez entrer une formule (chaque element doit etre separer par un espace).");
			System.out.print("Expression a calculer : ");
			Expression e1=new Expression(entree.nextLine());
			Pile calculateur = new Pile(e1.taille);
			IIdentifiants ids = null;
			
			System.out.println("> " + e1.toStringInfix() + " = " + e1.calcule(calculateur, ids));
			System.out.println("\n\n *OVER*");
		}

	}

}
