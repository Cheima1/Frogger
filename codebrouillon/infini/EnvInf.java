// package infiniteFrogger;

import util.*
import gameCommons.Game;
import gameCommons.IEnvironment;

import java.util.ArrayList;

public class EnvInf implements IEnvironment {

    // Attributs

    private ArrayList<LaneInf> roadLane;
    private Game game;

    // Constructeur
    
    public EnvInf(Game game){
        this.game = game;
	this.roadLane = new Arraylist<Lane>(); // on construit un nouveau tableau ou on met les lignes de route
	this.roadLane.add(new Lane(game, 0, 0.0));
	for (int i = 1; i < game.height - 1; i++){ 
	    this.roadLane.add(new Lane(game, i, 0.1));
	}
	this.roadLane.add(new Lane(game, game.height-1, 0.0));
    }
	

    // Getters & Setters
	
    // -----------------

    // Methodes
        
    public boolean is WinningPosition(Case c) {
		return false; // Il n'y a pas de position gagnante dans un jeu infini
	}
	
    public boolean isSafe(Case c) {
	Lane line = roadLane.get(c.ord); // lorsqu'on avance on verifie si on est safe
	return (line.isSafe(c));
	}
	
	public void update() {
		for(Lane line : this.roadLane){
			l.update();
			if ( this.game.getFrogDirection() == Direction.up) {
				ArrayList<Lane> tab = new ArrayList<Lane>();
	}

}
