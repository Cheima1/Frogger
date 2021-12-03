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


        // On veut que la premi�re et la derni�re lignes soient vides.
        // On commence donc par cr�er une premi�re ligne avec une densit� de 0
        // (donc aucune voiture) � l'abscice 0 (position initiale de la grenouille)
        lanes.add(new Lane(game, 0, 0.0));

        // On cr�e ensuite les autres lignes de l'�cran en utilisant la
        // densit� par d�faut (game.defaultDensity)
        for (int i = 1; i < game.height-1; i++) {
            lanes.add(new Lane(game, i, game.defaultDensity));
        }

        // Enfin on fini par cr�e la derni�re ligne avec une densit� de 0
        // (donc aucune voiture) � l'abscice game.height-1 (derni�re ligne )
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
