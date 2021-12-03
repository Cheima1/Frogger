package environment;

// package infiniteFrogger;

import util.*;
import gameCommons.Game;
import gameCommons.IEnvironment;

import java.util.ArrayList;

public class EnvInf implements IEnvironment {

    // Attributs

    private ArrayList<Lane> lanes;
    private Game game;

    // Constructeur

    public EnvInf(Game game) {
        this.game = game;
        this.lanes = new ArrayList<Lane>(); // on construit un nouveau tableau ou on met les lignes de route
        lanes.add(new Lane(game, 0, 0.0));
        // On crée ensuite les autres lignes de l'écran en utilisant la
        // densité par défaut (game.defaultDensity)
        for (int i = 1; i < game.height - 1; i++) {
            lanes.add(new Lane(game, i, game.defaultDensity));
        }
        // Enfin on fini par crée la dernière ligne avec une densité de 0
        // (donc aucune voiture) à l'abscice game.height-1 (dernière ligne )
        lanes.add(new Lane(game, game.height - 1, 0.0));
    }

    // Methodes

    public boolean isWinningPosition(Case c) {
        return false;
    }

    public boolean isSafe(Case c) {
        Lane line = lanes.get(c.ord); // lorsqu'on avance on verifie si on est safe
        return (line.isSafe(c));
    }

    public void update() {
        for (Lane line : this.lanes) {
            line.update();
            // infini direction up

            // Brouillon

            //---------------------------------

                /* Première tentative : Tentez d'ajouter une ligne en haut de la fenetre
                et supprimer la dernière ou la grenouille était a t=0 */

                /* if (this.game.getFrogDirection() == Direction.up) {
                        ArrayList<Lane> tab = new ArrayList<Lane>();
                      for (int i = 1; i < lanes.size(); i++) {
                        Lane z = new Lane(game, ord);
                        tab.add(z); // ajout de la ligne dans le tableau de copie
                        tab.add(lanes.get(i)); // ajout des autres lignes
                        lanes.remove(lanes.size()-1); // enleve la dernière ligne
                      }
                lanes = tab;
                }
                // outcome = fenetre vide quand on bouge la grenouille, le point se deplace mais on a sa old position */

            // ---------------------------------

            /* deuxieme tentative : on deplace la ligne du bas vers le haut et on decale toute les ligne vers le bas */
            // infini direction down

            // ---------------------------------

            /* troisieme tentative : descendre toutes les lignes lorsque la posfrog == Direction.up (ne pas oublier de descendre les voitures */

             if (this.game.getFrogDirection() == Direction.up) {
                for (int i = 1; i < lanes.size()-1; i++) {
                    lanes.get(i).setOrd((lanes.get(i).getOrd() - 1));

                }

            } /*else if (this.game.getFrogDirection() == Direction.down) {*/



        }
    }
}

