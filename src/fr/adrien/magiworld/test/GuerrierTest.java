package fr.adrien.magiworld.test;

import fr.adrien.magiworld.personnage.Guerrier;
import fr.adrien.magiworld.personnage.Personnage;
import fr.adrien.magiworld.personnage.Rodeur;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GuerrierTest {

    Personnage guerrier = new Guerrier(20, 30, 10, 10);
    Personnage adversaire = new Rodeur();

    @Test
    public void GIVEN_forceGuerrierEgale30_WHEN_guerrierAttaqueBasique_THEN_adversaireViePerd30(){
        adversaire.setVie(100);
        guerrier.attaqueBasique(adversaire);
        assertEquals(70, adversaire.getVie());
    }

    @Test
    public void GIVEN_forceGuerrierEgale30_WHEN_guerrierAttaqueSpeciale_THEN_adversaireViePerd60_AND_guerrierVieMoins15(){
        adversaire.setVie(100);
        guerrier.attaqueSpeciale(adversaire);
        assertEquals(40, adversaire.getVie());
        assertEquals(85, guerrier.getVie());
    }

}