package calculator;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * @author Valentin Durand - TP1.1 - 1A - DUT Informatique - IUT Ifs
 * @Class Element
 * @ May 9, 2014 6:24:04 PM
 */
public class Element implements IElement {

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
		String [] contenuInfix = new String [1024];
		int i = 0;
		while (!chaines.empty()) {
			String current = chaines.pop();
			if((current.matches("[+-/^*]"))||(current.equals("neg"))||(current.equals("cos"))) {
				String temp = contenuInfix[i-2];
				if((current.equals("+"))||(current.equals("-"))||(current.equals("^")))
					contenuInfix[i-2] = "(" + temp + current + contenuInfix[i-1] + ")";
				else
					contenuInfix[i-2] = temp + current + contenuInfix[i-1];
				i--;
			}
			else {
				contenuInfix[i] = current;
				i++;
			}
		}
		return contenuInfix[0];
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
