package environment;
import gameCommons.Game;
import java.awt.*;
import util.Case;

public class CasesSpe {
    private Game game;
    private Case cs;
    private int length;
    private final Color colorCs = Color.RED;

    public CasesSpe(Game game, Case cs){
        this.game = game;
        this.cs = cs;
        this.length = 1;
    }

    public int getOrdCs(Case cs){
        return cs.ord;
    }
    public int getAbscCs(Case cs){
        return cs.absc;
    }

    public boolean isBonus(Case posG) {
        return (posG.ord == cs.ord && posG.absc == cs.absc);
    }

}
