package org.marcheur;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record Marcheur(String nom, Carte carte) {
    public List<Lieu> marche(Lieu depart, Lieu destination) {
        List<Lieu> lieux = new ArrayList<>();
        Set<Lieu> visités = new HashSet<>();
        lieux.add(depart);
        visités.add(depart);

        var rues = carte.lesRues();
        while (!lieux.getLast().equals(destination)) {
            var dernierAjouté = lieux.getLast();
            var rueConnectées = rues
                    .stream()
                    .filter(rue -> rue.aCeLieu(dernierAjouté))
                    .toList();
            int indexAléatoire = (int) (Math.random() * rueConnectées.size());
            var rueAléatoire = rueConnectées.get(indexAléatoire);
            Lieu prochainLieu = rueAléatoire.getLieuA().equals(dernierAjouté) ?
                    rueAléatoire.getLieuB() : rueAléatoire.getLieuA();

            if (!visités.contains(prochainLieu)) {
                lieux.add(prochainLieu);
                visités.add(prochainLieu);
            }
        }
        return lieux;
    }
}
