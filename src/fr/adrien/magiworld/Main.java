package fr.adrien.magiworld;

import fr.adrien.magiworld.deroulement.Game;
import fr.adrien.magiworld.deroulement.GameImplement;
import fr.adrien.magiworld.personnage.Personnage;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Game game = new GameImplement();

        int classe = 0, niveau = 0, force =0, agilite =0, inteligence = 0;
        boolean isPtsCaracteristique = true;

        // IHM
        classe = game.choixCaracteristique("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
        niveau = game.choixCaracteristique("Niveau du personnage ?");
        do {
            force = game.choixCaracteristique("Force du personnage ?");
            agilite = game.choixCaracteristique("Agilité du personnage ?");
            inteligence = game.choixCaracteristique("Intéligence du personnage ?");
            isPtsCaracteristique = game.totaleCaracteristiques(niveau, force, agilite, inteligence);
        }while(!isPtsCaracteristique);

        Personnage joueur1 = game.choixPersonnage("Joueur 1", classe, niveau, force, agilite, inteligence);


        sc.close();
    }

}
