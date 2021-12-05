package frog;

import gameCommons.Game;
import gameCommons.IFrog;
import graphicalElements.Element;
import util.Case;
import util.Direction;

import java.awt.*;

public class Frog implements IFrog {

	private Game game;
	private Case position;
	private Direction direction;

	public Frog(Game game) {
		this.game = game;
		position = new Case(game.width / 2, 0);
		direction = Direction.up;
	}

	public Direction getDirection() {
		return direction;
	}

	public Case getPosition() {
		return position;
	}

	public void move(Direction key) {
		if (key == Direction.left){
			if(position.absc > 0) {
				position = new Case(position.absc - 1, position.ord);
			}
		} else if (key == Direction.right){
			if(position.absc < game.width - 1){
				position = new Case(position.absc + 1, position.ord);
			}
		} else if (key == Direction.down){
			if(position.ord > 0){
				position = new Case(position.absc, position.ord - 1);
				if (game.score > 0)
					game.score--;
			}
		} else if(key == Direction.up) {
			if (position.ord < game.height - 1) {
				position = new Case(position.absc, position.ord + 1);
				game.score++;
			}
		}
		this.game.getGraphic().add(new Element(this.position, Color.GREEN));
		this.game.testWin();
		this.game.testLose();
	}

	public void setDirection(Direction dir) {
		direction = dir;
	}
}



