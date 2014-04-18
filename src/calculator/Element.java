package calculator;
import java.util.NoSuchElementException;
import java.util.Stack;


/**
 * @author Valentin Durand - TP1.1 - 1A - DUT Informatique - IUT Ifs
 * @Class Element
 * @ Apr 17, 2014 4:34:27 PM
 */
public class Element implements calculator.IElement{
	protected Float value;
	
	public double calcule(IPile evaluations, IIdentifiants ids) throws IllegalStateException{
		return 1;
	}
	
	public String toStringInfix(Stack<String> chaines){
		return "";
	}
	
	public void analyse(Stack<Element> elements, IIdentifiants ids) throws NoSuchElementException{
		
	}
}
