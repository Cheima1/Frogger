package environment;

import java.util.ArrayList;

import util.*;
import gameCommons.Game;
import gameCommons.IEnvironment;

public class Environment implements IEnvironment {

    // attributs

    private Game game;
    private ArrayList<Lane>

    // constructeurs
    public Environment(Game game) {

    }
    // methodes
    public boolean is WinningPosition(Case c) {
        return c.ord == (game.height - 1);
    }

    public boolean isSafe(Case c) {

    }

    public void update() {
        for(Lane l : this.roadLane)  {
            l.update();
        }
    }

    //TODO

}
