package gameCommons;

import util.*;

public interface IFrog {
	
	/**
	 * Donne la position actuelle de la grenouille
	 * @return
	 */
	public Case getPosition();
	
	/**
	 * Donne la direction de la grenouille, c'est a dire de son dernier mouvement
	 * @return
	 */
	public Direction getDirection();
	
	/**
	 * D�place la grenouille dans la direction donn�e et teste la fin de partie
	 * @param key
	 */
	public void move(Direction key);

	/**
	 * Change la direction de la grenouille (utilisée en mode de jeu infini pour éviter
	 * un défilement non controllé des lanes).
	 * @param dir La nouvelle direction de la grenouille.
	 */
	public void setDirection(Direction dir);

}
