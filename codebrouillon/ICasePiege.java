package gameCommons;

import util.Case;

public interface ICasePiege {

    /**
     * Teste si une case est sure, c'est � dire que la grenouille peut s'y poser
     * sans mourir
     *
     * @param c
     *            la case � tester
     * @return vrai s'il n'y a pas danger
     */
    public boolean isSafe(Case c);

    /**
     * Teste si la grenouille est sur la case bonus
     *
     * @param posG : la position de la Frog
     * @return : if la positioin de la grenouille est la même que la case bonus
     */
    public boolean isBonus(Case posG);

}
