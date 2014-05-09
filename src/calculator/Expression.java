package calculator;

import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Scanner;

/**
 * @author Valentin Durand - TP1.1 - 1A - DUT Informatique - IUT Ifs
 * @Class Expression
 * @ May 8, 2014 4:23:14 PM
 */
public class Expression implements IExpression {
	
	protected String contenu;
	protected Stack<String> pile = new Stack<String>();
	String [] liste;
	
	/**
	 * Constructeur : Expression
	 */
	public Expression(String contenu) {
		this.contenu = contenu;
		this.StringToTab();
	}
	
	public void StringToPile() {
		StringTokenizer contenuTokenized = new StringTokenizer(contenu," ",false);
		
		while (contenuTokenized.hasMoreTokens()) {
			pile.push(contenuTokenized.nextToken());
		}
	}
	
	public void StringToTab() {
		int size = 1+contenu.length()/2;
		liste = new String [size];
		StringTokenizer contenuTokenized = new StringTokenizer(contenu," ",false);
		int i = 0;
		
		while (contenuTokenized.hasMoreTokens()) {
			liste[i] = contenuTokenized.nextToken();
			i++;
		}
	}
	
	  /**
	   * Analyse cette expression et vérifie si elle est légale.
	   * Répertorie les identifiants dont elle a besoin.
	   * @param ids les identifiants en cours. Sera éventuellement modifié par l'ajout de nouveaux identifiants.
	   * @throws NoSuchElementException si cette expression est incorrecte.
	   */
	@Override
	public void analyse(IIdentifiants ids) throws NoSuchElementException {
		Scanner entreeEle = new Scanner(System.in);
		
		for (int i = 0; i < liste.length; i++) {
			if(liste[i].matches("[a-zA-Z]")){
				System.out.print("Expression de" + liste[i] + " : ");
				ids.tab[0] = new Identifiant(liste[i], entreeEle.nextLine());
			}
		}

	}

	  /**
	   * Calcule la valeur de cette expression
	   * @param pile la pile d'évaluation. Sera modifiée par l'expression
	   * @param ids les identifiants connus
	   * @return la valeur de cette expression
	   * @throws IllegalStateException si l'expression est incalculable
	   */
	@Override
	public double calcule(IPile pile, IIdentifiants ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	  /**
	   * Construit une représentation infixe de cette expression
	   * @return la chaîne représentant cette expression de manière infixe.
	   */
	@Override
	public String toStringInfix() {
		StringTokenizer contenuTokenized = new StringTokenizer(contenu," ",false);
		String [] contenuInfix = new String [1024];
		int i = 0;
		
		while (contenuTokenized.hasMoreTokens()) {
			String current = contenuTokenized.nextToken();
			if((current.matches("[+-/^*]"))||(current.equals("neg"))||(current.equals("cos"))) {
				String temp = contenuInfix[i-2];
				if((current.equals("+"))||(current.equals("-"))||(current.equals("^")))
					contenuInfix[i-2] = "(" + temp + current + contenuInfix[i-1] + ")";
				else
					contenuInfix[i-2] = temp + current + contenuInfix[i-1];
				i--;
			}
			else {
				contenuInfix[i] = current;
				i++;
			}
		}
		return contenuInfix[0];
	}

	  /**
	   * Construit une représentation postfixe de cette expression
	   * @return la chaîne représentant cette expression de manière postfixe.
	   */
	@Override
	public String toString() {
		return contenu;
	}
	
	  /**
	   * Teste si l'expression est vide.
	   * @return vrai ssi cette expression ne contient aucun élément.
	   */
	@Override
	public boolean estVide() {
		// TODO Auto-generated method stub
		return false;
	}

}