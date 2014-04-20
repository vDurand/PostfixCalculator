package calculator;

import java.util.NoSuchElementException;

/**
 * @author Valentin Durand - TP1.1 - 1A - DUT Informatique - IUT Ifs
 * @Class Expression
 * @ Apr 20, 2014 5:19:28 PM
 */
public class Expression implements IExpression {
	
	
	/* (non-Javadoc)
	 * @see calculator.IExpression#analyse(calculator.IIdentifiants)
	 */
	@Override
	public void analyse(IIdentifiants ids) throws NoSuchElementException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see calculator.IExpression#calcule(calculator.IPile, calculator.IIdentifiants)
	 */
	@Override
	public double calcule(IPile pile, IIdentifiants ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see calculator.IExpression#toStringInfix()
	 */
	@Override
	public String toStringInfix() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see calculator.IExpression#estVide()
	 */
	@Override
	public boolean estVide() {
		// TODO Auto-generated method stub
		return false;
	}

}
