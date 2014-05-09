package calculator;

import java.util.NoSuchElementException;

/**
 * @author Valentin Durand - TP1.1 - 1A - DUT Informatique - IUT Ifs
 * @Class Pile
 * @ May 8, 2014 5:11:06 PM
 */
public class Pile implements IPile {

	private Double [] liste;
	private int location;
	
	/**
	 * Constructeur : Pile
	 */
	public Pile(int size) {
		liste  = new Double [size];
		location = 0;
	}
	  /**
	   * Empile une valeur.
	   * Imprime la description sur la sortie standard si le mode de débogage est activé.
	   * @param valeur la valeur à empiler
	   */
	@Override
	public void ajoute(Double valeur) {
		liste[location] = valeur;
		location++;
	}

	  /**
	   * Dépile une valeur
	   * @return la valeur dépilée
	   * @throws NoSuchElementException si la pile est vide
	   */
	@Override
	public Double retire() throws NoSuchElementException {
		if (estVide()) throw new NoSuchElementException();
	    location--;
	    return  liste[location];
	}

	  /**
	   * Teste si la pile est vide
	   * @return vrai ssi la pile est vide
	   */
	@Override
	public boolean estVide() {
		return (location<=0);
	}

}
