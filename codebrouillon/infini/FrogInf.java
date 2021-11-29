package infiniteFrogger;

import gameCommons.Game;
import gameCommons.IFrog;
import util.Case;
import util.Direction;

import java.awt.image.DirectColorModel;

public class FrogInf implements IFrog {

    // Attributs

    private Game game;
    private Case position;
    private Direction direction;

    public FrogInf(Game game) {
        this.game = game;
        this.position = new Case(game.width / 2, 1);
        this.direction = Direction.up;
    }

    // getter & Setter
    public Case getPosition(){
        return this.position;
    }

    @Override
    public Direction getDirection() {
        return direction;
    }

    // Methodes

    public void move(Direction key) {
        this.direction = key;
        if (key == Direction.left){
            if(position.absc > 0) {
                position = new Case(position.absc - 1, position.ord);
            }
        }
        
        else if (key == Direction.right){
            if(position.absc < game.width - 1){
                position = new Case(position.absc + 1, position.ord)
            }
        }
        
        // rien ne change
        
        else if (key == Direction.down){
            if(position.ord > 1){
                position = new Case(position.absc, position.ord - 1);
                --this.game.score;
            }
        } 
        else if(key == Direction.up) {
            positon = new Case(position.absc, position.ord + 1);
            ++this.game.score;
            if(this.game.score > this.game.maxScore) {
                this.game.maxScore = this.game.score;
                this.game.addLane();
            }
        }
        this.game.getGraphic().add(new Element(position.absc, 1, Color.GREEN));
        this.game.testWin();
        this.game.testLose();
        System.out.println(this.position.absc+""+ this.position + " score :");
}

