package calculator;

import java.util.NoSuchElementException;

/**
 * @author Valentin Durand - TP1.1 - 1A - DUT Informatique - IUT Ifs
 * @Class Identifiants
 * @ May 8, 2014 8:13:53 PM
 */
public class Identifiants implements IIdentifiants {
	
	private Identifiant [] idList;
	private int numberId;
	
	/**
	 * Constructeur : Identifiants
	 */
	public Identifiants(int size) {
		idList = new Identifiant [size];
		numberId = 0;
	}
	
	  /**
	   * Retourne le nombre d'identifiants définis
	   * @return le nombre d'identifiants définis
	   */
	@Override
	public int getNombre() {
		return numberId-1;
	}

	  /**
	   * Ajoute un identifiant à l'ensemble des identifiants connus.
	   * Un appel à {@link #get(String)} doit alors retourner {@code null} pour cet identifiant.
	   * 
	   * @param id
	   *          le nom de l'identifiant à ajouter
	   * @throws IllegalAccessError
	   *           si l'identifiant est déjà présent
	   */
	@Override
	public void ajoute(String id) throws IllegalAccessError {
		if(contient(id))
			throw new IllegalAccessError();
		idList[numberId].setSymbole(id);
		idList[numberId].setValeur(null);
	}

	  /**
	   * Affecte une expression à un identifiant donné par son numéro.
	   * 
	   * @param idx
	   *          le numéro de l'identifiant à modifier
	   * @param valeur
	   *          la valeur de l'expression à stocker
	   * @return le nom de l'identifiant défini
	   */
	@Override
	public String set(int idx, IExpression valeur) {
		idList[idx].setValeur(valeur);
		return idList[idx].getSymbole();
	}

	  /**
	   * Retourne la valeur de l'identifiant spécifié.
	   * 
	   * @param id
	   *          l'identifiant à rechercher
	   * @return sa valeur ou {@code null} si elle n'est pas définie.
	   */
	@Override
	public IExpression get(String id) {
		return idList[getIdx(id)].getValeur();
	}

	  /**
	   * Récupère le nom d'un identifiant.
	   * @param idx le numéro de l'identifiant à récupérer
	   * @return la chaîne décrivant l'identifiant.
	   */
	@Override
	public String getIdentifiant(int idx) {
		return idList[idx].getSymbole();
	}
	
	  /**
	   * Récupère le nom d'un identifiant.
	   * @param idx le numéro de l'identifiant à récupérer
	   * @return la chaîne décrivant l'identifiant.
	   */
	public int getIdx(String id) {
		int trouve = -1;
		for(int i = 0; i < numberId; i++)
			if(idList[i].getSymbole() == id)
				trouve = i;
		return trouve;
	}

	  /**
	   * Teste si l'identifiant donné est défini
	   * @param id le nom de l'identifiant à rechercher
	   * @return vrai si l'identifiant existe
	   */
	@Override
	public boolean contient(String id) {
		return ((get(id) != null) &&
				(getIdx(id) != -1));
	}

	  /**
	   * Renvoie la valeur calculée d'un identifiant
	   * @param pile la pile d'évaluation à utiliser
	   * @param id le nom de l'identifiant à évaluer
	   * @return la valuer calculée.
	   * @throws NoSuchElementException si l'identifiant n'est pas défini.
	   * @throws IllegalStateException si l'identifiant n'est pas calculable.
	   */
	@Override
	public double calcule(IPile pile, String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	  /**
	   * Teste si un identifiant est calculable
	   * @param id le nom de l'identifiant à évaluer
	   * @return vrai ssi l'identifiant est défini comme une expression calculable
	   * @throws NoSuchElementException si l'identifiant n'est pas défini.
	   */
	@Override
	public boolean estCalculable(String id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	  /** 
	   * Retourne une chaîne listant tous les identifiants dans leur ordre d'ajout, avec leur expression.
	   * @return une chaîne "{ id1=v1, id2=v2, ... }".
	   */
	@Override
	public String toString() {
		return null;
	}
}
