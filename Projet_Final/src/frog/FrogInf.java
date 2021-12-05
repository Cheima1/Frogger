package frog;

import gameCommons.Game;
import gameCommons.IFrog;
import graphicalElements.Element;
import util.Case;
import util.Direction;

import java.awt.*;
import java.awt.image.DirectColorModel;

public class FrogInf implements IFrog {

    // Attributs

    // ca change pas
    private Game game;
    private Case position;
    private Direction direction;

    // infini

    private int score;


    public FrogInf(Game game) {
        // ca change pas
        this.game = game;
        this.position = new Case(game.width / 2, 0);
        this.direction = Direction.left;
        // infini
        this.score = 0;

    }

    // getter & Setter
    public Case getPosition() {
        return this.position;
    }

    @Override
    public Direction getDirection() {
        return direction;
    }
    
    public void setDirection(Direction dir) {
        this.direction = dir;
    }

    // Methodes

    public void move(Direction key) {
        this.direction = key;
        if (key == Direction.left) {
            if(position.absc > 0) {
                position = new Case(position.absc - 1, position.ord);
            }
        } else if (key == Direction.right) {
            if (position.absc < game.width - 1){
                position = new Case(position.absc + 1, position.ord);
            }
        }
        else if (key == Direction.up) {
            game.score++;
        }
        else {
            if (game.score > 0)
                game.score--;
        }

        this.game.getGraphic().add(new Element(position.absc, 1, Color.GREEN));
        this.game.testWin();
        this.game.testLose();
        System.out.println(this.position.absc + "" + this.position + " score :" + this.score);
    }
}
