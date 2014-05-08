package calculator;

/**
 * @author Valentin Durand - TP1.1 - 1A - DUT Informatique - IUT Ifs
 * @Class Identifiants
 * @ May 8, 2014 8:13:53 PM
 */
public class Identifiants implements IIdentifiants {
	
	protected Identifiant [] tab;
	
	/* (non-Javadoc)
	 * @see calculator.IIdentifiants#getNombre()
	 */
	@Override
	public int getNombre() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see calculator.IIdentifiants#ajoute(java.lang.String)
	 */
	@Override
	public void ajoute(String id) throws IllegalAccessError {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see calculator.IIdentifiants#set(int, calculator.IExpression)
	 */
	@Override
	public String set(int idx, IExpression valeur) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see calculator.IIdentifiants#get(java.lang.String)
	 */
	@Override
	public IExpression get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see calculator.IIdentifiants#getIdentifiant(int)
	 */
	@Override
	public String getIdentifiant(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see calculator.IIdentifiants#contient(java.lang.String)
	 */
	@Override
	public boolean contient(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see calculator.IIdentifiants#calcule(calculator.IPile, java.lang.String)
	 */
	@Override
	public double calcule(IPile pile, String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see calculator.IIdentifiants#estCalculable(java.lang.String)
	 */
	@Override
	public boolean estCalculable(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
