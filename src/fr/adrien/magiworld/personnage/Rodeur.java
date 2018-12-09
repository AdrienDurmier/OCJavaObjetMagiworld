package fr.adrien.magiworld.personnage;

public class Rodeur extends Personnage{

    /**
     * Default contructor
     */
    public Rodeur() {
        super();
    }

    /**
     * Constructor with parameters
     *
     * @param niveau
     * @param vie
     * @param force
     * @param agilite
     * @param intelligence
     */
    public Rodeur(int niveau, int vie, int force, int agilite, int intelligence) {
        super(niveau, vie, force, agilite, intelligence);
    }

}
