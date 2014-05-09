package calculator;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * @author Valentin Durand - TP1.1 - 1A - DUT Informatique - IUT Ifs
 * @Class Identifiant
 * @ May 8, 2014 6:51:45 PM
 */
public class Identifiant implements IIdentifiant {

	private String symbole;
	private IExpression valeur;
	
	/**
	 * Constructeur : Identifiant
	 */
	public Identifiant() {
		symbole = null;
		valeur = null;
	}
	
	/**
	 * Constructeur : Identifiant
	 * @param s
	 * @param v
	 */
	public Identifiant(String s, Expression v) {
		setSymbole(s);
		setValeur(v);
	}
	
	  /**
	 * @return the symbole
	 */
	public String getSymbole() {
		return symbole;
	}

	/**
	 * @param symbole the symbole to set
	 */
	public void setSymbole(String symbole) {
		this.symbole = symbole;
	}

	/**
	 * @return the valeur
	 */
	public IExpression getValeur() {
		return valeur;
	}

	/**
	 * @param valeur the valeur to set
	 */
	public void setValeur(IExpression valeur) {
		this.valeur = valeur;
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
		// TODO Auto-generated method stub
		return 0;
	}

	  /**
	   * Construit une représentation infixe de cet élément à l'aide d'une pile, et l'ajoute sur la pile.
	   * @param chaines une pile de représentations infixes.
	   * @return la chaîne représentant cet élément de manière infixe.
	   */
	@Override
	public String toStringInfix(Stack<String> chaines) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub

	}

}
