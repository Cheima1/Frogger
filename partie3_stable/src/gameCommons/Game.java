package gameCommons;

import graphicalElements.Element;
import graphicalElements.IFroggerGraphics;

import java.awt.*;
import java.util.Random;
import util.Case;
import util.Direction;

import javax.swing.text.Position;
//import environment.EnvInf;

public class Game {

	public final Random randomGen = new Random();

	// Caracteristique de la partie
	public final int width;
	public final int height;
	public final int minSpeedInTimerLoops;
	public final double defaultDensity;
	public int score;

	// Lien aux objets utilises
	private IEnvironment environment;
	private IFrog frog;
	private IFroggerGraphics graphic;

	// Timer:
	// La variable 'timer' est un compteur qui compteras le nombre de fois que la fonction "update()" est
	// appellée.
	// Comme on connais la frequence d'actualisation de la partie (le 'tempo' du fichier main), une fois
	// que la partie est fini on peut déduire le temps écoulé (timer * tempo)
	// La variable 'lockedTimer' existe simplement car 'update()' continue d'être appelée, même une fois le game over.
	// On utilise donc la fonction getTime(), qui fixera la valeur dans 'lockedTimer', pour conserver le temps
	// écoulé au moment du game over.
	public int timer;
	public double lockedTimer = -1.0;

	/**
	 *
	 * @param graphic
	 *            l'interface graphique
	 * @param width
	 *            largeur en cases
	 * @param height
	 *            hauteur en cases
	 * @param minSpeedInTimerLoop
	 *            Vitesse minimale, en nombre de tour de timer avant d�placement
	 * @param defaultDensity
	 *            densite de voiture utilisee par defaut pour les routes
	 */
	public Game(IFroggerGraphics graphic, int width, int height, int minSpeedInTimerLoop, double defaultDensity) {
		super();
		this.graphic = graphic;
		this.width = width;
		this.height = height;
		this.minSpeedInTimerLoops = minSpeedInTimerLoop;
		this.defaultDensity = defaultDensity; // apparition de voiture
		this.score = 0; // comptabiliser le score

		this.timer = 0;
	}

	/**
	 * Lie l'objet frog a la partie
	 *
	 * @param frog
	 */
	public void setFrog(IFrog frog) {
		this.frog = frog;
	}

	/**
	 * Lie l'objet environment a la partie
	 *
	 * @param environment
	 */
	public void setEnvironment(IEnvironment environment) {
		this.environment = environment;
	}

	/**
	 *
	 * @return l'interface graphique
	 */
	public IFroggerGraphics getGraphic() {
		return graphic;
	}

	/**
	 * Teste si la partie est perdue et lance un ecran de fin approprie si tel
	 * est le cas
	 *
	 * @return true si le partie est perdue
	 */
	public boolean testLose() {
		return (!environment.isSafe(frog.getPosition()));
	}

	/**
	 * Teste si la partie est gagnee et lance un ecran de fin approprie si tel
	 * est le cas
	 *
	 * @return true si la partie est gagnee
	 */
	public boolean testWin() {
		return environment.isWinningPosition(frog.getPosition());
	}

	/**
	 * Actualise l'environnement, affiche la grenouille et verifie la fin de
	 * partie.
	 */
	public void update() {
		graphic.clear();
		environment.update();
		this.graphic.add(new Element(frog.getPosition(), Color.GREEN));

		if(testLose()) {
			graphic.clear();
			graphic.endGameScreen(" Vous avez Perdu, Votre score : " + this.score + ", Temps écoulé: " + getTime() + "s.");
			return;
		}

		if(testWin()){
			graphic.clear();
			graphic.endGameScreen(" Vous avez Gagne ");
			return;
		}

		timer++;
	}
	public Case getFrogPosition() {
		return frog.getPosition();
	}
	public void setFrogDirection(Direction dir) {
		frog.setDirection(dir);
	}
	public Direction getFrogDirection(){
		return frog.getDirection();
	}

	public double getTime() {
		if (lockedTimer == -1.0) {
			lockedTimer = (double)(Math.round(timer * Main.DEFAULT_TEMPO) / 1000);
		}

		return lockedTimer;
	}
}