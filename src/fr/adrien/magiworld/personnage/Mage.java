package fr.adrien.magiworld.personnage;

public class Mage extends Personnage{

    private final int VIE_DEPART = super.getVie();

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
        int intelligence = super.getIntelligence();
        super.setVie(personnage.getVie() + controleVieMax(intelligence));
    }

    /**+
     * Il ne peut pas avoir plus de vie qu’il n’en avait au départ
     * @param intelligence
     * @return
     */
    public int controleVieMax(int intelligence){
        int soin = intelligence * 2;
        int vieMax = super.getVie() + soin;

        if (vieMax >= VIE_DEPART){
            int difference = vieMax - VIE_DEPART;
            soin -= difference;
        }

        return soin;
    }

}
