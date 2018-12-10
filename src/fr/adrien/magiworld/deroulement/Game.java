package fr.adrien.magiworld.deroulement;

import fr.adrien.magiworld.personnage.Personnage;

public interface Game {


    /**
     * Contrôle sur la saisie du joueur
     * @param saisie
     * @return saisie après contrôle
     */
    public int choixCaracteristique(String saisie);

    /**
     *  Crée l'instance d'un Personnage et le présente
     *
     * @param indicationJoueur
     * @param classe
     * @param niveau
     * @param force
     * @param agilite
     * @param intelligence
     * @return
     */
    public Personnage choixPersonnage(String indicationJoueur, int classe, int niveau, int force, int agilite, int intelligence);

    /**
     *  Attention le total force + agilité + intelligence doit être égal au niveau du joueur.
     * @param niveau
     * @param force
     * @param agilite
     * @param inteligence
     * @return
     */
    public boolean totaleCaracteristiques(int niveau, int force, int agilite, int inteligence);

}
