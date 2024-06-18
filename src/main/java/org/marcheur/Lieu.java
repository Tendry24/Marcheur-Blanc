package org.marcheur;

import java.util.HashSet;
import java.util.Set;

public class Lieu {
    private final Set<Rue> ruesConnécté = new HashSet<>();

    private final String nom;

    public Lieu(String nom) {
        this.nom = nom;
    }

    void connecterA(Rue rue) {
        ruesConnécté.add(rue);
    }

    @Override
    public String toString() {
        return nom;
    }
}