package fr.adrien.magiworld;

import fr.adrien.magiworld.deroulement.Game;
import fr.adrien.magiworld.deroulement.GameImplement;
import fr.adrien.magiworld.personnage.Personnage;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Game game = new GameImplement();

        int classe = 0, niveau = 0, force =0, agilite =0, inteligence = 0, choixJoueur = 0;
        boolean isPtsCaracteristique = true;

        // Le jeu commence par proposer au joueur 1 de choisir entre Guerrier, Rôdeur ou Mage
        System.out.println("Création du personnage du Joueur 1");
        classe = game.choixCaracteristique("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
        niveau = game.choixCaracteristique("Niveau du personnage ?");
        do {
            // Il doit ensuite choisir le niveau, la force, l’agilité et enfin l’intelligence de son personnage.
            force = game.choixCaracteristique("Force du personnage ?");
            agilite = game.choixCaracteristique("Agilité du personnage ?");
            inteligence = game.choixCaracteristique("Intelligence du personnage ?");
            isPtsCaracteristique = game.checkTotaleCaracteristiques(niveau, force, agilite, inteligence);
        }while(!isPtsCaracteristique);
        Personnage joueur1 = game.choixPersonnage("Joueur 1", classe, niveau, force, agilite, inteligence);

        // C’est ensuite au tour du second joueur de choisir la classe et les caractéristiques de son personnage.
        System.out.println("Création du personnage du Joueur 2");
        classe = game.choixCaracteristique("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
        niveau = game.choixCaracteristique("Niveau du personnage ?");
        do {
            force = game.choixCaracteristique("Force du personnage ?");
            agilite = game.choixCaracteristique("Agilité du personnage ?");
            inteligence = game.choixCaracteristique("Intelligence du personnage ?");
            isPtsCaracteristique = game.checkTotaleCaracteristiques(niveau, force, agilite, inteligence);
        }while(!isPtsCaracteristique);
        Personnage joueur2 = game.choixPersonnage("Joueur 2", classe, niveau, force, agilite, inteligence);

        // La partie démarre ensuite
        do{
            // le joueur 1 commence.
            // Chaque joueur joue tour à tour et choisit entre son Attaque Basique ou son Attaque spéciale.
            do{
                System.out.println("Joueur 1 (" + joueur1.getVie() + " Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)");
                choixJoueur = sc.nextInt();
            }while(choixJoueur < 1 ||  choixJoueur > 2);
            game.choixAttaque("Joueur 1", choixJoueur, joueur1, joueur2);

            // Tour du joueur 2 s'il a toujours de la vitalité
            if(joueur2.getVie() > 0) {
                do{
                    System.out.println("Joueur 2 (" + joueur2.getVie() + " Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)");
                    choixJoueur = sc.nextInt();
                }while(choixJoueur < 1 ||  choixJoueur > 2);
                game.choixAttaque("Joueur 2", choixJoueur, joueur2, joueur1);
            }

        }while(joueur1.getVie() > 0 &&  joueur2.getVie() > 0); // Quand un joueur n’a plus de point de vie, la partie est terminée et l’autre joueur l’emporte.

        // Affichage du joueur victorieux
        if (joueur1.getVie() > joueur2.getVie()){
            System.out.println("Joueur 2 a perdu");
        }else{
            System.out.println("Joueur 1 a perdu");
        }

        sc.close();
    }

}
