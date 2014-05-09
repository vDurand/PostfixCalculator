package calculator;

/**
 * @author Valentin Durand - TP1.1 - 1A - DUT Informatique - IUT Ifs
 * @Class testPile
 * @ May 9, 2014 8:50:46 PM
 */
public class testPile {
	public static void main(String[] args) {
		Pile a = new Pile(5);
		a.ajoute(35.0);
		System.out.println(a);
		a.ajoute(36.0);
		System.out.println(a);
		a.ajoute(37.0);
		System.out.println(a);
		a.retire();
		System.out.println(a);
	}
}
