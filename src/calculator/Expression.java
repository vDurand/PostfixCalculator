package calculator;

import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Scanner;

/**
 * @author Valentin Durand - TP1.1 - 1A - DUT Informatique - IUT Ifs
 * @Class Expression
 * @ May 8, 2014 4:23:14 PM
 */
public class Expression implements IExpression {
	
	protected String contenu;
	protected Stack<Element> expression;
	protected Element [] liste;
	protected int taille;
	protected Identifiants ids;
	private boolean affichagePile;
	protected boolean calculable;
	protected boolean divisible;
	protected String resultatString;
	protected String erreurString;
	
	/**
	 * Constructeur : Expression
	 */
	public Expression(String contenu) {
		affichagePile = false;
		calculable = true;
		divisible = true;
		this.contenu = contenu;
		resultatString = "Expression à calculer : " + contenu;
		erreurString = "Expression à calculer : " + contenu + "\n";
		expression  = new Stack<Element>();
		taille = 0;
		this.StringToTab();
		try{
			this.analyse(ids);
		}
		catch(NoSuchElementException e){
			calculable = false;
			System.out.println(e.getMessage());
			erreurString += e.getMessage();
		}
	}
	
	public void showPile(){
		affichagePile = true;
	}
	
	public void StringToTab() {
		int size = 1+contenu.length()/2;
		liste = new Element [size];
		ids = new Identifiants(size);
	}
	
	  /**
	   * Analyse cette expression et vérifie si elle est légale.
	   * Répertorie les identifiants dont elle a besoin.
	   * @param ids les identifiants en cours. Sera éventuellement modifié par l'ajout de nouveaux identifiants.
	   * @throws NoSuchElementException si cette expression est incorrecte.
	   */
	@Override
	public void analyse(IIdentifiants ids) throws NoSuchElementException {
		StringTokenizer contenuTokenized = new StringTokenizer(contenu," ",false);
		int i = 0;
		Stack<String> temp = new Stack<String>();
		
		while (contenuTokenized.hasMoreTokens()) {
			temp.push(contenuTokenized.nextToken());
			i++;
		}
		taille = i;
		String current;
		i = 0;
		
		while(!temp.empty()){
			//System.out.println(temp.peek());
			current = temp.pop();
			if((current.matches("[+-/^*]"))||(current.equals("neg"))||(current.equals("cos"))){
				switch (current){
				case "+": liste[i] = new binaires.Addition(); expression.push(liste[i]); //infixStack.push(liste[i]);
				break;
				case "/": liste[i] = new binaires.Division(); expression.push(liste[i]); //infixStack.push(liste[i]);
				break;
				case "*": liste[i] = new binaires.Multiplication(); expression.push(liste[i]); //infixStack.push(liste[i]);
				break;
				case "^": liste[i] = new binaires.Puissance(); expression.push(liste[i]); //infixStack.push(liste[i]);
				break;
				case "-": liste[i] = new binaires.Soustraction(); expression.push(liste[i]); //infixStack.push(liste[i]);
				break;
				case "cos": liste[i] = new unaires.Cos(); expression.push(liste[i]); //infixStack.push(liste[i]);
				break;
				case "neg": liste[i] = new unaires.Neg(); expression.push(liste[i]); //infixStack.push(liste[i]);
				break;
				}
			}
			/*else if(current.matches("^[a-zA-Z].*")){
				@SuppressWarnings("resource")
				Scanner idEntree = new Scanner(System.in);
				System.out.print("Expressions de " + current + " : ");
				Expression e2=new Expression(idEntree.nextLine());
				liste[i] = new Identifiant(current, e2);
				expression.push(liste[i]);
			}
			else{
				liste[i] = new Nombre(Double.parseDouble(current)); expression.push(liste[i]);
			}
			i++;*/
			else if(current.matches("^[0-9]+\\.?[0-9]*$")){ //^[0-9].*
				liste[i] = new Nombre(Double.parseDouble(current)); expression.push(liste[i]); //infixStack.push(liste[i]);
			}
			else if(current.matches("^[a-zA-Z].*")){
				try{
					/*@SuppressWarnings("resource")
					Scanner idEntree = new Scanner(System.in);
					System.out.print("Expressions de " + current + " : ");
					Expression e2=new Expression(idEntree.nextLine());
					liste[i] = new Identifiant(current, e2);
					expression.push(liste[i]); //infixStack.push(liste[i]);
					ids.ajoute(current);*/
					@SuppressWarnings("resource")
					Scanner idEntree = new Scanner(System.in);
					System.out.print("Expressions de " + current + " : ");
					Expression e2=new Expression(idEntree.nextLine());
					ids.ajoute(current);
					liste[i] = new Identifiant(current, e2);
					expression.push(liste[i]);
					
				}
				catch(IllegalAccessError e) {
					throw new NoSuchElementException("Erreur: Identifiant deja utilise ("+current+").");
				}
			}
			else{
				throw new NoSuchElementException("Erreur: Caractère invalide ("+current+").");
			}
			i++;
		}
		@SuppressWarnings("unchecked")
		Stack<Element> verifStack = (Stack<Element>) expression.clone();
		Stack<IElement> verificateur = new Stack<IElement>();
		while(!verifStack.empty()){
			try{
				verifStack.pop().analyse(verificateur, ids);
			}catch(NoSuchElementException e){
				System.out.println(e.getMessage());
				erreurString += e.getMessage();
				throw new NoSuchElementException("");
			}
		}
		verificateur.pop();
		if(!verificateur.empty())
			throw new NoSuchElementException("Argument manquant");
	}

	  /**
	   * Calcule la valeur de cette expression
	   * @param pile la pile d'évaluation. Sera modifiée par l'expression
	   * @param ids les identifiants connus
	   * @return la valeur de cette expression
	   * @throws IllegalStateException si l'expression est incalculable
	   */
	@Override
	public double calcule(IPile pile, IIdentifiants ids) {
		for(int i=0; i<taille; i++){
			try {
				expression.pop().calcule(pile, ids);
				if(affichagePile){
					System.out.println(pile);
					resultatString += "\n" + pile;
				}
			} catch (IllegalStateException e) {
				System.out.println(e.getMessage());
				erreurString += e.getMessage();
				divisible = false;
			}
		}
		return pile.retire();
	}

	  /**
	   * Construit une représentation infixe de cette expression
	   * @return la chaîne représentant cette expression de manière infixe.
	   */
	@Override
	public String toStringInfix() {
		/*StringTokenizer contenuTokenized = new StringTokenizer(contenu," ",false);
		String [] contenuInfix = new String [1024];
		int i = 0;
		
		while (contenuTokenized.hasMoreTokens()) {
			String current = contenuTokenized.nextToken();
			if(current.matches("[+-/^*]")) {
				String temp = contenuInfix[i-2];
				if((current.equals("+"))||(current.equals("-"))||(current.equals("^")))
					contenuInfix[i-2] = "(" + temp + current + contenuInfix[i-1] + ")";
				else
					contenuInfix[i-2] = temp + current + contenuInfix[i-1];
				i--;
			}
			else if((current.equals("neg"))||(current.equals("cos"))) {
				String temp = contenuInfix[i-1];
				contenuInfix[i-1] = current + "(" + temp + ")";
			}
			else {
				contenuInfix[i] = current;
				i++;
			}
		}
		return contenuInfix[0];*/
		String infixString = "";
		@SuppressWarnings("unchecked")
		Stack<Element> infixStack = (Stack<Element>) expression.clone();
		Stack<String> stringStack  = new Stack<String>();
		while(!infixStack.empty()){
			infixStack.pop().toStringInfix(stringStack);
		}
		infixString = stringStack.pop();
		return infixString;
	}

	  /**
	   * Construit une représentation postfixe de cette expression
	   * @return la chaîne représentant cette expression de manière postfixe.
	   */
	@Override
	public String toString() {
		return contenu;
	}
	
	  /**
	   * Teste si l'expression est vide.
	   * @return vrai ssi cette expression ne contient aucun élément.
	   */
	@Override
	public boolean estVide() {
		// TODO Auto-generated method stub
		return false;
	}

}
