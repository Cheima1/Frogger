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
		//this.length =
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

	// methode move

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
