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
        this.lanes = new ArrayList<Lane>(); // on construit un nouveau tableau ou on met les lignes de rout
        // On crée ensuite les autres lignes de l'écran en utilisant la
        // densité par défaut (game.defaultDensity)
        for (int i = 0; i < game.height; i++) {
            lanes.add(new Lane(game, i, game.defaultDensity));
        }
        // Enfin on fini par crée la dernière ligne avec une densité de 0
        // (donc aucune voiture) à l'abscice game.height-1 (dernière ligne )

    }

    // Methodes

    public boolean isWinningPosition(Case c) {
        return false;
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
        for (Lane line : lanes) {
            line.update();
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

            if (game.getFrogDirection() == Direction.up) {
                ArrayList<Lane> tmp = new ArrayList<Lane>();

                // On baisse toute les lignes d'une unité en ordonnée.
                // La ligne 1 est déplacée en haut de l'écran.

                //tmp.add(lanes.get(0));
                for (int i = 1; i < lanes.size(); i++) {
                    Lane next = lanes.get(i);
                    next.setOrd(next.getOrd() - 1);
                    tmp.add(next);
                }

                Lane first = lanes.get(0);
                first.setOrd(game.height-1);
                tmp.add(first);
                lanes = tmp;

                game.setFrogDirection(Direction.left);
            }
            else if (game.getFrogDirection() == Direction.down) {
                ArrayList<Lane> tmp = new ArrayList<Lane>();

                // On monte toutes les lignes d'une unité en ordonnée.
                // La dernière ligne est déplacée en ordonnée 1
                //tmp.add(lanes.get(0));

                for (int i = 0; i < lanes.size() - 1; i++) {
                    Lane next = lanes.get(i);
                    next.setOrd(next.getOrd() + 1);
                    tmp.add(next);
                }

                Lane last = lanes.get(lanes.size()-1);
                last.setOrd(0);
                tmp.add(last);
                lanes = tmp;

                game.setFrogDirection(Direction.left);
            }


        }
    }
}