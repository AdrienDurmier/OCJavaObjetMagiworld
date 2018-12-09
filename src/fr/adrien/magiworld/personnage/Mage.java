package fr.adrien.magiworld.personnage;

public class Mage extends Personnage{

    /**
     * Default contructor
     */
    public Mage() {
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
    public Mage(int niveau, int vie, int force, int agilite, int intelligence) {
        super(niveau, vie, force, agilite, intelligence);
    }

    public void attaqueBasique(Personnage personnage){
        System.out.println("Boule de Feu");
    }

    public void attaqueSpeciale(Personnage personnage){
        System.out.println("Soin");
    }

}
