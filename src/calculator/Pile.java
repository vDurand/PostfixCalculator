package calculator;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * @author Valentin Durand - TP1.1 - 1A - DUT Informatique - IUT Ifs
 * @Class Pile
 * @ May 8, 2014 5:11:06 PM
 */
public class Pile implements IPile {

	protected Stack<String> liste = new Stack<String>();
	
	  /**
	   * Empile une valeur.
	   * Imprime la description sur la sortie standard si le mode de débogage est activé.
	   * @param valeur la valeur à empiler
	   */
	@Override
	public void ajoute(Double valeur) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see calculator.IPile#retire()
	 */
	@Override
	public Double retire() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see calculator.IPile#estVide()
	 */
	@Override
	public boolean estVide() {
		// TODO Auto-generated method stub
		return false;
	}

}
