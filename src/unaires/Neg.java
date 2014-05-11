package unaires;

import java.util.NoSuchElementException;
import java.util.Stack;

import calculator.IElement;
import calculator.IIdentifiants;
import calculator.IPile;
import calculator.Nombre;

/**
 * @author Valentin Durand - TP1.1 - 1A - DUT Informatique - IUT Ifs
 * @Class Neg
 * @ May 9, 2014 10:20:51 PM
 */
public class Neg extends calculator.Operateur implements INeg {

	/**
	 * Constructeur : Neg
	 */
	public Neg() {
		super("neg");
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
		Double resultat = -evaluations.retire();
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
		String val = chaines.push(symbole + "(" + chaines.pop() + ")");
		return val;
	}

	  /**
	   * Vérifie si cet élément est compatible avec la pile et répertorie les identifiants utilisés.
	   * Utilise une pile pour évaluer si le calcul est possible.
	   * @param elements La pile de l'analyse en cours. Sera modifiée par l'analyse.
	   * @param ids Les identifiants en cours. Sera éventuellement modifié par l'ajout d'identifiants.
	   * @throws NoSuchElementException si cet élément est incompatible avec la pile 
	   */
	@Override
	public void analyse(Stack<IElement> elements, IIdentifiants ids)
			throws NoSuchElementException {
		String msg = "Calcul Impossible : ";
		if(elements.empty())
			throw new NoSuchElementException(msg + "La pile est vide");
		if(!(elements.peek() instanceof Nombre))
			throw new NoSuchElementException(msg + "L'element a calculer n'est pas un nombre");
	}

}
