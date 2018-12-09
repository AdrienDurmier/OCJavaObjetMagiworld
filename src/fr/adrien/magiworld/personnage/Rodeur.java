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

    /**
     * Effectue des dommages égaux à l’agilité du joueur sur l’adversaire
     * @param personnage : cible
     */
    @Override
    public void attaqueBasique(Personnage personnage){
        System.out.println("Tir à l’Arc");
    }

    /**
     * Le joueur gagne son niveau divisé par 2 en agilité
     * @param personnage : cible
     */
    @Override
    public void attaqueSpeciale(Personnage personnage){
        System.out.println("Concentration");
    }

}
