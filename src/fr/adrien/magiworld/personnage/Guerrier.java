package fr.adrien.magiworld.personnage;

public class Guerrier extends Personnage{

    /**
     * Default contructor
     */
    public Guerrier() {
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
    public Guerrier(int niveau, int vie, int force, int agilite, int intelligence) {
        super(niveau, vie, force, agilite, intelligence);
    }

}
