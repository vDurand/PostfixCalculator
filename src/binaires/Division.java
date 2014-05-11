package binaires;

import java.util.NoSuchElementException;
import java.util.Stack;

import calculator.IElement;
import calculator.IIdentifiants;
import calculator.IPile;

/**
 * @author Valentin Durand - TP1.1 - 1A - DUT Informatique - IUT Ifs
 * @Class Division
 * @ May 9, 2014 10:17:29 PM
 */
public class Division extends calculator.Operateur implements IDivision {

	/**
	 * Constructeur : Division
	 */
	public Division() {
		super("/");
	}
	
	  /**
	   * Calcule la valeur de cet élément.
	   * @param evaluations la pile d'évaluation. Sera modifiée par l'élément
	   * @param ids les identifiants connus. Peut être modifié si un identifiant doit être ajouté.
	   * @return la valeur de cet élément
	   * @throws IllegalStateException si l'élément est incalculable
	   */
	@Override
	public double calcule(IPile evaluations, IIdentifiants ids)
			throws IllegalStateException {
		Double diviseur = evaluations.retire();
		if(diviseur == 0)
			throw new IllegalStateException("Division par zero impossible");
		Double resultat = evaluations.retire()/diviseur;
		evaluations.ajoute(resultat);
		return resultat;
	}

	  /**
	   * Construit une représentation infixe de cet élément à l'aide d'une pile, et l'ajoute sur la pile.
	   * @param chaines une pile de représentations infixes.
	   * @return la chaîne représentant cet élément de manière infixe.
	   */
	@Override
	public String toStringInfix(Stack<String> chaines) {
		String diviseur = chaines.pop();
		String val = chaines.push("(" + chaines.pop() + " " + symbole + " " + diviseur + ")");
		return val;
	}
}
