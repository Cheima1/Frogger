package environment;

import java.util.ArrayList;

import util.Case;
import gameCommons.Game;

public class Lane {
    private Game game;
    private int ord;
    private int speed;
    private ArrayList<Car> cars = new ArrayList<>();
    private boolean leftToRight;
    private double density;

    // TODO : Constructeur(s)
    public Lane(Game game, int ord, double density){
        this.game = game;
        this.ord = ord;
        this.density = density;

        this.speed = (int)(Math.random() * game.minSpeedInTimerLoops + 1);
        leftToRight = (speed % 2 == 0);
    }
    public Lane(Game game, int ord){
        this(game, ord, game.defaultDensity);
    }

    // getter et setter

    public int getOrd(){
        return this.ord;
    }

    public void setOrd(int ordonne) {
        this.ord = ordonne;
        for(int i = 0; i < cars.size(); i++){
            Case c = cars.get(i).getLeftPosition();
            int o = ordonne;
            int absc = c.absc;
            cars.set(i, new Car(game, new Case(absc, o), leftToRight));
        }
    }

    public void update() {

        // TODO

        // Toutes les voitures se deplacent d'une case au bout d'un nombre "tic
        // d'horloge" egal a leur vitesse
        // Notez que cette methode est appelee a chaque tic d'horloge

        // Les voitures doivent etre ajoutes a l interface graphique meme quand
        // elle ne bougent pas

        // A chaque tic d'horloge, une voiture peut etre ajoutee

        this.move();			// On commence par actualliser la position de nos voitures
        this.mayAddCar();		// On v�rifie si on peut ajouter une voiture � cette Lane
        this.mayRemoveCar();	// On v�rifie si des voitures sont sorties de l'�cran

    }

    // TODO : ajout de methodes

    /*
     * Fourni : mayAddCar(), getFirstCase() et getBeforeFirstCase()
     */

    /**
     * Ajoute une voiture au d?but de la voie avec probabilit? ?gale ? la
     * densit?, si la premi?re case de la voie est vide
     */
    private void mayAddCar() {
        if (isSafe(getFirstCase()) && isSafe(getBeforeFirstCase())) {
            if (game.randomGen.nextDouble() < density) {
                cars.add(new Car(game, getBeforeFirstCase(), leftToRight));
            }
        }
    }

    /**
     * V�rifie si il y a une collision entre une voiture et la grenouille
     * @param frogPos La position actuelle de la grenouille
     * @return true si et seulement si la grenouille n'est entr�e en collision
     * 		   avec aucune voiture de cette Lane.
     */
    public boolean isSafe(Case frogPos) {
        boolean v = true;
        for (Car car : cars) {
            if (car.isAccident(frogPos)) {
                v = false;
            }
        }

         return v;
    }

    /**
     * On parcours tous les �l�ments de notre Lane, si une voiture
     * sort de l'�cran, on la supprime
     */
    private void mayRemoveCar() {
        for (int i = 0; i < cars.size(); i++) {
            Car current = cars.get(i);
            if (current.getLeftPosition().ord >= game.width) {
                cars.remove(current);
            }
        }
    }

    private void move() {
        for (Car car : cars) {
            car.move();
        }

    }

    private Case getFirstCase() {
        if (leftToRight) {
            return new Case(0, ord);
        } else
            return new Case(game.width - 1, ord);
    }

    private Case getBeforeFirstCase() {
        if (leftToRight) {
            return new Case(-1, ord);
        } else
            return new Case(game.width, ord);
    }

}
