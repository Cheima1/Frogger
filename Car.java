package environment;

import java.awt.Color;

import gameCommons.Case;
import gameCommons.Game;
import graphicalElements.Element;

public class Car {
	private Game game;
	private Case leftPosition;
	private boolean leftToRight;
	private int length;
	private final Color colorLtR = Color.BLACK;
	private final Color colorRtL = Color.BLUE;

	//TODO Constructeur(s)

	// on construit une voiture qui va de

	public Car(Game game, Case getBeforeFirstCase, boolean lToR)){
		//this.game = width
	}
	
	//TODO : ajout de methodes

	// getter

	public int getLength() {
		return length;
	}

	public Case getLeftPosition() {
		return leftPosition;
	}

	// setter

	public void setLeftPosition(Case leftPosition) {
		this.leftPosition = leftPosition;
	}

	public void setLength(int length) {
		this.length = length;
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
