package fr.adrien.magiworld.personnage;

public abstract class Personnage {

    private int niveau;
    private int vie;
    private int force;
    private int agilite;
    private int intelligence;

    /**
     * Default contructor
     */
    public Personnage() {
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
    public Personnage(int niveau, int vie, int force, int agilite, int intelligence) {
        this.niveau = niveau;
        this.vie = vie;
        this.force = force;
        this.agilite = agilite;
        this.intelligence = intelligence;
    }

    public abstract void attaqueBasique(Personnage personnage);

    public abstract void attaqueSpeciale(Personnage personnage);

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getVie() {
        return vie;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getAgilite() {
        return agilite;
    }

    public void setAgilite(int agilite) {
        this.agilite = agilite;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

}
