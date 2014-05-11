package calculator;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * @author Valentin Durand - TP1.1 - 1A - DUT Informatique - IUT Ifs
 * @Class Nombre
 * @ May 9, 2014 10:28:53 PM
 */
public class Nombre extends Element implements INombre {
	protected Double val;
	/**
	 * Constructeur : Nombre
	 */
	public Nombre(Double d) {
		val = d;
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
		evaluations.ajoute(val);
		return val;
	}

	  /**
	   * Construit une représentation infixe de cet élément à l'aide d'une pile, et l'ajoute sur la pile.
	   * @param chaines une pile de représentations infixes.
	   * @return la chaîne représentant cet élément de manière infixe.
	   */
	@Override
	public String toStringInfix(Stack<String> chaines) {
		String s = chaines.push(" "+val+" ");
		return s;
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
		elements.push(this);

	}

}
