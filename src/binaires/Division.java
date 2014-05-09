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
public class Division implements IDivision {

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
	public void analyse(Stack<IElement> elements, IIdentifiants ids)
			throws NoSuchElementException {
		// TODO Auto-generated method stub

	}

}
