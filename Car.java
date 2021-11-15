package environment;

import java.awt.Color;
import gameCommons.Game;
import graphicalElements.Element;
import util.Case;

public class Car {
	private Game game;
	private Case leftPosition;
	private boolean leftToRight;
	private int length;
	private final Color colorLtR = Color.BLACK;
	private final Color colorRtL = Color.BLUE;

	//TODO Constructeur(s)

	// on construit une voiture qui va de droite à gauche et une longueur quelconque

	public Car(Game game, Case lPos, boolean lToR) {
		this.game = game;
		this.leftToRight = lToR;
		this.leftPosition = lPos;
		this.length = (int) ((java.lang.Math.random() * 3) + 1);
	}


	//TODO : ajout de methodes

	// getter

	public int getLength() {
		return length;
	}

	public Case getLeftPosition(){
        return leftPosition;
    }

	// setter

	public void setLength(int length) {
		this.length = length;
	}

	// Methode move
	/** 
	 * Bouge un vehicule selon son sens de circulation
	 */
	
	public void move() {
		if(leftToRight) {
			leftPosition = new Case(leftPosition.absc + 1, leftPosition.ord);
		} else {
			leftPosition = new Case(lftPosition.absc - 1, leftPosition.ord);
		}
	}
	
	// Methode accident
	/**
	 * Savoir si un grenouille se fait percuter par un vehicule
	 * @param : une case posG 
	 * @return : un boolean si la voiture et la grenouille sont sur la même case alors on renvois true, 
	 * false sinon
	 */
	
	public boolean isAccident(Case posG) {
		// utiliser isSafe
		if (posG.ord == leftPosition.ord) {
	}

	/* Fourni : addToGraphics() permettant d'ajouter un element graphique correspondant a la voiture*/
	private void addToGraphics() {
		for (int i = 0; i < length; i++) {
			Color color = colorRtL;
			if (this.leftToRight){
				color = colorLtR;
			}
			game.getGraphic()
					.add(new Element(leftPosition.absc + i, leftPosition.ord, color));
		}
	}

}
