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
     * @param force
     * @param agilite
     * @param intelligence
     */
    public Rodeur(int niveau, int force, int agilite, int intelligence) {
        super(niveau, force, agilite, intelligence);
        super.nomAttaqueBasique = "Tir à l’Arc";
        super.nomAttaqueSpeciale = "Concentration";
    }

    /**
     * Effectue des dommages égaux à l’agilité du joueur sur l’adversaire
     * @param personnage : cible
     */
    @Override
    public void attaqueBasique(Personnage personnage){
        int degat = super.getAgilite();
        personnage.setVie(personnage.getVie() - degat);
    }

    /**
     * Le joueur gagne son niveau divisé par 2 en agilité
     * @param personnage : cible
     */
    @Override
    public void attaqueSpeciale(Personnage personnage){
        int gainAgilite = super.getNiveau() / 2;
        super.setAgilite(super.getAgilite() + gainAgilite);
    }

}
