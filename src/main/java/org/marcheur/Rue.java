package org.marcheur;

import lombok.AllArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
public class Rue {
  private String rue;
  private final Lieu lieuConnecté1;
  private final Lieu lieuConnecté2;

  public Rue(Lieu a, Lieu b) {
    this.lieuConnecté1 = a;
    this.lieuConnecté2 = b;
  }

  public boolean aCeLieu(Lieu lieu){
    return lieuConnecté1.equals(lieu) || lieuConnecté2.equals(lieu);
  }

  public Lieu getLieuA() {
    return lieuConnecté1;
  }

  public Lieu getLieuB() {
    return lieuConnecté2;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Rue rue)) return false;
    return Objects.equals(lieuConnecté1, rue.lieuConnecté1) && Objects.equals(lieuConnecté2, rue.lieuConnecté2);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lieuConnecté1, lieuConnecté2);
  }

  @Override
  public String toString() {
    return "Rue{" +
      "rue='" + (rue == null ? "Rue inconnu" : rue) + '\'' +
      ", lieu_a=" + lieuConnecté1 +
      ", lieu_b=" + lieuConnecté2 +
      '}';
  }
}
