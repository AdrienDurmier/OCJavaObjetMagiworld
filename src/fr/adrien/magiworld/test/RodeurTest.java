package fr.adrien.magiworld.test;

import fr.adrien.magiworld.personnage.Mage;
import fr.adrien.magiworld.personnage.Personnage;
import fr.adrien.magiworld.personnage.Rodeur;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RodeurTest {

    Personnage rodeur = new Rodeur(20, 30, 10, 10);
    Personnage adversaire = new Mage();

    @Test
    public void GIVEN_forceAgiliteEgale10_WHEN_rodeurAttaqueBasique_THEN_adversaireViePerd10(){
        adversaire.setVie(100);
        rodeur.attaqueBasique(adversaire);
        assertEquals(90, adversaire.getVie());
    }

    @Test
    public void GIVEN_agiliteEgale10_WHEN_attaqueSpeciale_THEN_agiliteEgale20(){
        rodeur.attaqueSpeciale(rodeur);
        assertEquals(20, rodeur.getAgilite());
    }

}