package environment;

import java.util.ArrayList;

import util.Case;
import gameCommons.Game;
import gameCommons.IEnvironment;

public class Environment implements IEnvironment {

    private ArrayList<Lane> lanes;
    private Game game;

    public Environment (Game game) {
        this.game = game;
        lanes = new ArrayList<>();


        // On veut que la premiere et la derniere lignes soient vides.
        // On commence donc par creer une premiere ligne avec une densite de 0
        // (donc aucune voiture) a l'abscice 0 (position initiale de la grenouille)
        lanes.add(new Lane(game, 0, 0.0));

        // On cree ensuite les autres lignes de l'ecran en utilisant la
        // densite par defaut (game.defaultDensity)
        for (int i = 1; i < game.height-1; i++) {
            lanes.add(new Lane(game, i, game.defaultDensity));
        }

        // Enfin on fini par cree la derniere ligne avec une densite de 0
        // (donc aucune voiture) a l'abscice game.height-1 (derniere ligne )
        lanes.add(new Lane(game, game.height-1, 0.0));
    }



    public boolean isWinningPosition(Case c) {
        return c.ord == (game.height-1);
    }

    public boolean isSafe(Case c) {
        for (Lane lane : lanes) {
            if (!lane.isSafe(c)) {
                return false;
            }
        }

        return true;
    }
    public void update() {
        for (Lane l : lanes) {
            l.update();
        }
    }

}
