package calculator;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * @author Valentin Durand - TP1.1 - 1A - DUT Informatique - IUT Ifs
 * @Class Operateur
 * @ May 10, 2014 3:26:03 PM
 */
public class Operateur extends Element implements IOperateur {
	protected String symbole;
	/**
	 * Constructeur : Operateur
	 */
	public Operateur(String s) {
		symbole = s;
	}

	  /**
	   * Construit une représentation infixe de cet élément à l'aide d'une pile, et l'ajoute sur la pile.
	   * @param chaines une pile de représentations infixes.
	   * @return la chaîne représentant cet élément de manière infixe.
	   */
	@Override
	public String toStringInfix(Stack<String> chaines) {
		String val = chaines.push("(" + chaines.pop() + symbole + chaines.pop() + ")");
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
		elements.pop();
		if(elements.empty())
			throw new NoSuchElementException(msg + "La pile ne contient qu'un element");
		if(!(elements.peek() instanceof Nombre))
			throw new NoSuchElementException(msg + "L'element a calculer n'est pas un nombre");
	}

}
