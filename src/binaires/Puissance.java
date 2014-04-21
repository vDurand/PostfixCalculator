package binaires;

import java.util.NoSuchElementException;
import java.util.Stack;

import calculator.Element;
import calculator.IIdentifiants;
import calculator.IPile;

/**
 * @author Valentin Durand - TP1.1 - 1A - DUT Informatique - IUT Ifs
 * @Class Puissance
 * @ Apr 21, 2014 6:03:48 PM
 */
public class Puissance implements IPuissance {

	protected char symbol;
	
	/**
	 * Constructeur : Puissance
	 */
	public Puissance() {
		symbol = '^';
	}
	
	/* (non-Javadoc)
	 * @see calculator.IElement#calcule(calculator.IPile, calculator.IIdentifiants)
	 */
	@Override
	public double calcule(IPile evaluations, IIdentifiants ids)
			throws IllegalStateException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see calculator.IElement#toStringInfix(java.util.Stack)
	 */
	@Override
	public String toStringInfix(Stack<String> chaines) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see calculator.IElement#analyse(java.util.Stack, calculator.IIdentifiants)
	 */
	@Override
	public void analyse(Stack<Element> elements, IIdentifiants ids)
			throws NoSuchElementException {
		// TODO Auto-generated method stub

	}

}
