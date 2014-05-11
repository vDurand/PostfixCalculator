package calculator;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
			String expRep;
			do{
				System.out.print("\n\nExpression a calculer : ");
				expRep = entree.nextLine();
			} while (!expRep.matches("^[a-zA-Z0-9].*"));
			Expression e1=new Expression(expRep);
			String result = null;
			if(reponse.equals("Oui"))
				e1.showPile();
			Pile calculateur = new Pile(e1.taille);
			if(e1.calculable){
				result = e1.toStringInfix() + " = " + e1.calcule(calculateur, e1.ids) + " avec " + e1.ids;
				if(e1.divisible){
					e1.resultatString += "\n" + result + "\n";
					System.out.println(result);
					writeToFile("Resultats.txt", e1.resultatString);
				}
				else{
					e1.erreurString += "\n";
					writeToFile("Erreurs.txt", e1.erreurString);
				}
			}
			else{
				e1.erreurString += "\n";
				writeToFile("Erreurs.txt", e1.erreurString);
			}
			System.out.println();
			System.out.println("\n\n *OVER*");
		}

	}
	
	public static void writeToFile(String fileName, String text){
		/*try{
			FileWriter fWriter = new FileWriter(fileName);
			BufferedWriter bWriter = new BufferedWriter(fWriter);
			PrintWriter pWriter = new PrintWriter(bWriter);
			pWriter.println(text);
			pWriter.close();
		}catch(IOException EIO){
			System.out.println("Openning error !");
			if(EIO instanceof FileNotFoundException){
				System.out.println("File not found X(");
			}
		}*/
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)))) {
		    out.println(text);
		}catch (IOException EIO) {
			System.out.println("Openning error !");
			if(EIO instanceof FileNotFoundException){
				System.out.println("File not found X(");
			}
		}
	}

}
