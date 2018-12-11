package fr.adrien.magiworld.deroulement;

import fr.adrien.magiworld.personnage.Guerrier;
import fr.adrien.magiworld.personnage.Mage;
import fr.adrien.magiworld.personnage.Personnage;
import fr.adrien.magiworld.personnage.Rodeur;

import java.util.Scanner;

public class GameImplement implements Game {

    Scanner sc = new Scanner(System.in);

    @Override
    public int choixCaracteristique(String saisie) {
        int indiceMin = 0, indiceMax = 0;
        switch (saisie) {
            case "Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)":
                indiceMin = 1;
                indiceMax = 3;
                break;
            case "Niveau du personnage ?":
                indiceMin = 1;
                indiceMax = 100;
                break;
            default:
                indiceMin = 0;
                indiceMax = 100;
                break;
        }
        int nbPts = this.controleSaisie(saisie, indiceMin, indiceMax);
        return nbPts;
    }

    private int controleSaisie(String indication, int indiceMin, int indiceMax) {
        int nbPts = 0;
        do {
            System.out.println(indication);
            nbPts = sc.nextInt();
        } while (nbPts < indiceMin || nbPts > indiceMax);
        return nbPts;
}

    @Override
    public Personnage choixPersonnage(String indicationJoueur, int classe, int niveau, int force, int agilite, int intelligence) {
        Personnage joueur;
        switch (classe) {
            case 1:
                System.out.println(
                        "Woarg je suis le Guerrier " + indicationJoueur + " je possède " + (niveau * 5) + " de vitalité, "
                                + force + " de force, " + agilite + " d'agilité et " + intelligence + " d'intelligence !");
                joueur = new Guerrier(niveau, force, agilite, intelligence);
                return joueur;
            case 2:
                System.out.println(
                        "Héhé je suis le Rôdeur " + indicationJoueur + " je possède " + (niveau * 5) + " de vitalité, "
                                + force + " de force, " + agilite + " d'agilité et " + intelligence + " d'intelligence !");
                joueur = new Rodeur(niveau, force, agilite, intelligence);
                return joueur;
            case 3:
                System.out.println(
                        "Abracadabra je suis le Mage " + indicationJoueur + " je possède " + (niveau * 5) + " de vitalité, "
                                + force + " de force, " + agilite + " d'agilité et " + intelligence + " d'intelligence !");
                joueur = new Mage(niveau, force, agilite, intelligence);
                return joueur;
            default:
                joueur = new Mage();
                return joueur;
        }
    }

    @Override
    public boolean checkTotaleCaracteristiques(int niveau, int force, int agilite, int intelligence){
        int totaleCaracteristique = force + agilite + intelligence;
        if(totaleCaracteristique > niveau) {
            System.out.println("Attention le total force + agilité + intelligence doit être égal au niveau du joueur.");
            return false;
        }else{
            return true;
        }
     }


    @Override
    public void choixAttaque(String indicationJoueur, int choixJoueur, Personnage joueur, Personnage cible){
        switch (choixJoueur) {
            case 1:
                this.controleAttaqueBasique(indicationJoueur, joueur, cible);
                break;
            case 2:
                this.controleAttaqueSpeciale(indicationJoueur, joueur, cible);
                break;
        }
    }

    /**
     * Permet d'afficher les détails d'une attaque basique
     * @param indicationJoueur
     * @param joueur
     * @param cible
     */
    private void controleAttaqueBasique(String indicationJoueur, Personnage joueur, Personnage cible){
        int degat = 0;
        joueur.attaqueBasique(cible);
        if (joueur instanceof Guerrier){
            degat = joueur.getForce();
        }else if(joueur instanceof Rodeur){
            degat = joueur.getAgilite();
        }else{
            degat = joueur.getIntelligence();
        }

        System.out.println(indicationJoueur + " utilise " + joueur.getNomAttaqueBasique() + " et inflige " + degat
                + " dommages.\n" + (indicationJoueur.equals("Joueur 1") ? "Joueur 2 " : "Joueur 1 ") + " perd " + degat + " points de vie\n");
    }

    /**
     * Permet d'afficher les détails d'une attaque spéciale
     * @param indicationJoueur
     * @param joueur
     * @param cible
     */
    private void controleAttaqueSpeciale(String indicationJoueur, Personnage joueur, Personnage cible){
        int puissanceAttaque = 0;
        if (joueur instanceof Guerrier){
            joueur.attaqueSpeciale(cible);
            puissanceAttaque = joueur.getForce();
            System.out.println(indicationJoueur + " utilise " + joueur.getNomAttaqueSpeciale() + " et inflige " + puissanceAttaque * 2 + " dommages.");
            System.out.println((indicationJoueur.equals("Joueur 1") ? "Joueur 2 " : "Joueur 1 ") + " perd " + puissanceAttaque * 2 + " point de vie.");
            System.out.println(indicationJoueur + " perd " + puissanceAttaque / 2 + " point de vie.");
        }
        else if(joueur instanceof Rodeur){
            joueur.attaqueSpeciale(joueur);
            puissanceAttaque = joueur.getNiveau();
            System.out.println(indicationJoueur + " utilise " + joueur.getNomAttaqueSpeciale() + " et gagne " + puissanceAttaque / 2 + " points d'agilité.");
        }
        else{
            joueur.attaqueSpeciale(joueur);
            puissanceAttaque = joueur.getIntelligence();
            System.out.println(indicationJoueur + " utilise " + joueur.getNomAttaqueSpeciale() + " et gagne " + puissanceAttaque * 2 + " points de vie.");
        }

    }

}
