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

	/* (non-Javadoc)
	 * @see calculator.IElement#analyse(java.util.Stack, calculator.IIdentifiants)
	 */
	@Override
	public void analyse(Stack<IElement> elements, IIdentifiants ids)
			throws NoSuchElementException {
		// TODO Auto-generated method stub

	}

}
