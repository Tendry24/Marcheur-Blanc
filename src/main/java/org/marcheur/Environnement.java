package org.marcheur;

import java.util.HashSet;
import java.util.Set;

public class Environnement {
  private final Set<Rue> ensembleDeRue = new HashSet<>();

  public void ajouterUneRue(String nom, Lieu a, Lieu b){
    ensembleDeRue.add(new Rue(nom, a, b));
  }

  public void ajouterUneRue(Lieu a, Lieu b){
    ensembleDeRue.add(new Rue(a, b));
  }

  public Set<Rue> lesRues() {
    return ensembleDeRue;
  }
}