package gameCommons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import frog.Frog;
import environment.Environment;
import frog.FrogInf;
import graphicalElements.FroggerGraphic;
import graphicalElements.IFroggerGraphics;
import environment.*;

public class Main {

	public static int DEFAULT_TEMPO = 100;

	public static void main(String[] args) {

		//Caracteristiques du jeu
		int width = 26;
		int height = 20;
		int tempo = DEFAULT_TEMPO;
		int minSpeedInTimerLoops = 3;
		double defaultDensity = 0.02;
		
		//Creation de l'interface graphique
		IFroggerGraphics graphic = new FroggerGraphic(width, height);
		//Creation de la partie
		Game game = new Game(graphic, width, height, minSpeedInTimerLoops, defaultDensity);
		//Creation et liaison de la grenouille
		IFrog frog = new FrogInf(game);
		game.setFrog(frog);
		graphic.setFrog(frog);
		//Creation et liaison de l'environnement
		IEnvironment env = new EnvInf(game);
		game.setEnvironment(env);
				
		//Boucle principale : l'environnement s'actualise tous les tempo milisecondes
		Timer timer = new Timer(tempo, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game.update();
				graphic.repaint();
			}
		});
		timer.setInitialDelay(0);
		timer.start();
	}
}
