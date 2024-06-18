package org.marcheur.marcheur;

import org.marcheur.Lieu;
import org.marcheur.Environnement;

import java.util.ArrayList;
import java.util.List;

public record Marcheur(String nom) {

    public static List<Lieu> marche(Environnement environnement, Lieu départ, Lieu destination) {
        List<Lieu> lieux = new ArrayList<>();
        lieux.add(départ);
        var rues = environnement.lesRues();
        while (!lieux.getLast().equals(destination)) {
            var dernierAjouté = lieux.getLast();
            var rueConnecté = rues.stream().filter(rue -> rue.aCeLieu(dernierAjouté)).toList();
            int indexAléatoire = (int) Math.floor(Math.random() * (rueConnecté.size() - 1));
            var rueAléatoire = rueConnecté.get(indexAléatoire);
            if (rueAléatoire.getLieuA().equals(dernierAjouté)) {
                lieux.add(rueAléatoire.getLieuB());
            } else {
                lieux.add(rueAléatoire.getLieuA());
            }
        }
        return lieux;
    }
}