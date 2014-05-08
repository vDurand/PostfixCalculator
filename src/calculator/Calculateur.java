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
		System.out.println("Bienvenue sur le calculateur en notation post-fixee");
		while(true){
			System.out.println("Entrez une formule (chaque element doit etre separer par un espace):");
			Expression e1=new Expression(entree.nextLine());
			System.out.println(e1.toStringInfix());
		}

	}

}
