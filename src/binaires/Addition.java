package binaires;

import calculator.IIdentifiants;
import calculator.IPile;

/**
 * @author Valentin Durand - TP1.1 - 1A - DUT Informatique - IUT Ifs
 * @Class Addition
 * @ May 9, 2014 10:11:41 PM
 */
public class Addition extends calculator.Operateur implements IAddition {

	/**
	 * Constructeur : Addition
	 */
	public Addition() {
		super("+");
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
		Double resultat = evaluations.retire()+evaluations.retire();
		evaluations.ajoute(resultat);
		return resultat;
	}
}
