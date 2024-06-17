import org.junit.jupiter.api.Test;
import org.marcheur.Carte;
import org.marcheur.Lieu;
import org.marcheur.Marcheur;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MarcheurTest {
    @Test
    public void départ_à_HEI_vers_ESTI() {
        var marais = new Lieu("Marais");
        var sekolintsika = new Lieu("Sekolintsika");
        var hei = new Lieu("HEI");
        var balançoire = new Lieu("Balançoire");
        var esti = new Lieu("ESTI");
        var boulevardDeLEurope = new Lieu("Boulevard de l'Europe");
        var nexta = new Lieu("NEXTA");
        var pullman = new Lieu("Pullman");

        var carte = new Carte();
        carte.ajouterUneRue(marais, sekolintsika);
        carte.ajouterUneRue(sekolintsika, hei);
        carte.ajouterUneRue(hei, balançoire);
        carte.ajouterUneRue("Andriatsinorana", hei, pullman);
        carte.ajouterUneRue("Ranaivo", pullman, balançoire);
        carte.ajouterUneRue(pullman, nexta);
        carte.ajouterUneRue(balançoire, esti);
        carte.ajouterUneRue(balançoire, boulevardDeLEurope);
        carte.ajouterUneRue(boulevardDeLEurope, esti);

        var marcheur = new Marcheur("TestMarcheur", carte);
        List<Lieu> trajet = marcheur.marche(hei, esti);

        assertFalse(trajet.isEmpty());
        assertTrue(trajet.size() > 2);
        assertEquals(esti, trajet.getLast());
        assertEquals(trajet.getFirst(), hei);
        assertEquals(trajet.getLast(), esti);
    }
}
