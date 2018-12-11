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
     * @param force
     * @param agilite
     * @param intelligence
     */
    public Guerrier(int niveau, int force, int agilite, int intelligence) {
        super(niveau, force, agilite, intelligence);
        super.nomAttaqueBasique = "Coup d'Épée";
        super.nomAttaqueSpeciale = "Coup de Rage";
    }

    /**
     * Effectue des dommages égaux à la force du joueur sur l’adversaire
     * @param personnage : cible
     */
    @Override
    public void attaqueBasique(Personnage personnage){
        int degat = super.getForce();
        personnage.setVie(personnage.getVie() - degat);
    }

    /**
     * Effectue des dommages égaux à la force du joueur fois deux sur l’adversaire.
     * Le joueur lançant l'attaque perd de la vitalité : la valeur de sa force divisée par 2
     * @param personnage : cible
     */
    @Override
    public void attaqueSpeciale(Personnage personnage){
        int degatCible = super.getForce() * 2;
        personnage.setVie(personnage.getVie() - degatCible);
        int degatSubit = super.getForce() / 2;
        super.setVie(super.getVie() - degatSubit);
    }

}
