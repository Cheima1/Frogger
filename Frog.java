package frog;

import graphicalElements.Element;
import gameCommons.Game;
import gameCommons.IFrog;
import gameCommons.IEnvironment;
import util.Direction;
import util.Case;

/** Class Frog Partie 1
 * @BUT : une Grenouille est composé d'un jeu, une direction et une position Pour
 * @Constructeur :pour construire une grenouille il faut un jeu qu'on aura construit au prealable
 * on init la grenouille a la case de départ et on lui attribut une seul sorte de direction
 * @Methodes : on recupere la direction et la position de la grenouille
 * Move deplace la grenouille
 */

public class Frog implements IFrog {
	 // attributs
	private Game game; // table de jeu
	private Direction dir; // direction.up/down/right/left
	private Case pos; // sur quelle case se deplace frog

	// constructeurs

	public Frog(Game game) {
		this.game = game; // construit un jeu voulu
		this.pos = new Case(0, 0); // construit la position initial
		this.dir = Direction.up; //
	}

	// getter & setters
	@Override
	public Direction getDirection() {
		return dir;
	}

	public Case getPosition() {
		return pos;
	}

	// methodes
	/**
	 *  Move
	 * @param key qui est une direction up/right/left/down
	 *  si la position donnee de la grenouille est plus grande que l'ordonnee de depart, alors on met a jour la Case pos
	 */
	public void move(Direction key) {

		if (key == Direction.left){
			if(pos.absc > 0) {
				pos = new Case(pos.absc - 1, pos.ord);
			}
		}
		if (key == Direction.right){
			if(pos.absc < game.width - 1){
				pos = new Case(pos.absc + 1, pos.ord);
			}
		}

		if (key == Direction.down){
			if(pos.ord > 0){
				pos = new Case(pos.absc, pos.ord - 1);
			}
		}

		if(key == Direction.up) {
			if (pos.ord < game.height - 1) {
				pos = new Case(pos.absc, pos.ord + 1);
			}
		}
	}
}




