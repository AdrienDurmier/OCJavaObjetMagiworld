package fr.adrien.magiworld.test;

import fr.adrien.magiworld.personnage.Personnage;
import fr.adrien.magiworld.personnage.Mage;
import fr.adrien.magiworld.personnage.Rodeur;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MageTest {

    Personnage mage = new Mage(20, 30, 10, 10);
    Personnage adversaire = new Rodeur();

    @Test
    public void GIVEN_forceIntelligenceEgale10_WHEN_mageAttaqueBasique_THEN_adversaireViePerd10(){
        adversaire.setVie(100);
        mage.attaqueBasique(adversaire);
        assertEquals(90, adversaire.getVie());
    }

    @Test
    public void GIVEN_intelligenceEgale10_AND_vieEgale50_WHEN_mageAttaqueSpeciale_THEN_viePlus20(){
        mage.setVie(50);
        mage.attaqueSpeciale(mage);
        assertEquals(70, mage.getVie());
    }

    @Test
    public void GIVEN_intelligenceEgale10_AND_vieEgale90_WHEN_mageAttaqueSpeciale_THEN_viePlus10(){
        mage.setVie(90);
        mage.attaqueSpeciale(mage);
        assertEquals(100, mage.getVie());
    }

}