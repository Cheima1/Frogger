package environment;
import gameCommons.Game;
import java.awt.*;

import gameCommons.ICasePiege;
import util.Case;

public class CasesSpe implements ICasePiege {
    /** @Case1 : Une case Bonus est une case qui s'affiche aleatoirement dans la table de jeu
     * elle fait gagner 2 points de plus au score du joueur lorsqu'il tombre dessus, elle est également de couleur rouge
     */

    /** @Case2 : Une case piege de type 1 est une case qui s'affiche aleatoirement dans la table de jeu
     * elle fait perde automatiquement le joueur lorsqu'il tombre dessus, elle est également de couleur rose
     */

    /** @Case3 : Une case piege de type 2 est une case qui s'affiche aleatoirement dans la table de jeu
     * elle fait perde -2 point au score du joueur lorsqu'il tombre dessus, elle est également de couleur rose
     */

    /** @Case4 : Une case piege de type 3 est une case qui s'affiche aleatoirement dans la table de jeu
     * elle fait gagner du temps en plus au temps final du joueur lorsqu'il tombre dessus, elle est également de couleur rose
     */

    // Attributs

    //Attribut case Bonus
    private Game game;
    private Case cs;
    private int length;
    private final Color colorCs = Color.RED;
    private int valeur;
    // Attribut cases piegés
    private  final Color colorCp = Color.PINK;

    // Constructeur CASEBonus

    public CasesSpe(Game game, Case cs, int valeur){
        this.game = game;
        this.cs = cs;
        this.length = 1;
        this.valeur = valeur;
        // Random pour mettre la case de manière random
        // = (int) ((java.lang.Math.random() * 3) + 1);
    }
    
    // Getter & Setter

    public int getOrdCs(Case cs){
        return cs.ord;
    }
    public int getAbscCs(Case cs){
        return cs.absc;
    }

    // Methodes

    public boolean isSafe(Case c){

    }

    public boolean isBonus(Case posG) {
        return (posG.ord == this.cs.ord && posG.absc == this.cs.absc);
        //this.game.score += 2;
    }

    /*
    public boolean whichCase(Case poseG, int v) {
        if (isBonus(poseG) && v == 1) {
            return false;
        } else if (isBonus(poseG) && v == 0) {

        }
    }*/

    /*private void addToGraphics() {
        for (int i = 0; i < game.height; i++) {
            Color color = colorRtL;
            if (this.cs ==){
                color = colorLtR;
            }
            game.getGraphic()
                    .add(new Element(leftPosition.absc + i, leftPosition.ord, color));
        }
    }*/

}
