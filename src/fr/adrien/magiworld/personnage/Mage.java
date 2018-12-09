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
     * @param force
     * @param agilite
     * @param intelligence
     */
    public Mage(int niveau, int force, int agilite, int intelligence) {
        super(niveau, force, agilite, intelligence);
    }

    /**
     * Effectue des dommages égaux à l’intelligence du joueur sur l’adversaire
     * @param personnage : cible
     */
    @Override
    public void attaqueBasique(Personnage personnage){
        int degat = super.getIntelligence();
        personnage.setVie(personnage.getVie() - degat);
    }

    /**
     * Le joueur soigne sa vie et regagne sa quantité d’intelligence fois 2 en points de vie.
     * Attention, il ne peut pas avoir plus de vie qu’il n’en avait au départ
     * @param personnage : cible
     */
    @Override
    public void attaqueSpeciale(Personnage personnage){
        int soin = super.getIntelligence();
        super.setVie(personnage.getVie() + soin);
    }

}
