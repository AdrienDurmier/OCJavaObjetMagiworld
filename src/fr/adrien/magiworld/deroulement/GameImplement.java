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
    public boolean totaleCaracteristiques(int niveau, int force, int agilite, int inteligence){
        int totaleCaracteristique = force + agilite + inteligence;
        if(totaleCaracteristique > niveau) {
            System.out.println("Attention le total force + agilité + intelligence doit être égal au niveau du joueur.");
            return false;
        }else{
            return true;
        }
     }

}
