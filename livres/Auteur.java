package livres;

import java.util.Objects;

/**
 * Cours POO 1
 *
 *TP2-BH-BP
 */

public class Auteur {

    public static final String INCONNU = "Inconnu";
    public static final Pays PAYS_INCONNU = new Pays(INCONNU, "XXX");

    private String prenom = INCONNU;
    private String nom = INCONNU;
    private Pays paysOrigine = PAYS_INCONNU;

//    public Auteur(String prenom, String nom, String paysOrigine) {
//        setPrenom(prenom);
//        setNom(nom);
//        setPaysOrigine(paysOrigine);
//    }


    public Auteur(String prenom, String nom, Pays paysOrigine) {
        this.prenom = prenom;
        this.nom = nom;
        this.paysOrigine = paysOrigine;
    }

    public Auteur() {
        this(INCONNU, INCONNU, PAYS_INCONNU);
    }

//    public String getPrenom() {
//        return prenom;
//    }
//
//    private void setPrenom(String prenom) {
//        this.prenom = prenom;
//    }
//
//    public String getNom() {
//        return nom;
//    }
//
//    private void setNom(String nom) {
//        this.nom = nom;
//    }
//
//    public String getPaysOrigine() {
//        return paysOrigine;
//    }
//
//    private void setPaysOrigine(String paysOrigine) {
//        this.paysOrigine = paysOrigine;
//    }


    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Pays getPaysOrigine() {
        return paysOrigine;
    }

    public void setPaysOrigine(Pays paysOrigine) {
        assert paysOrigine != null : "Le pays d'origine ne peut pas être null.";
        this.paysOrigine = paysOrigine;
    }

    @Override
    public String toString() {
        return prenom + " " + nom + " (origine : " + paysOrigine + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Auteur)) return false;

        Auteur auteur = (Auteur) o;
        return prenom.equals(auteur.prenom) && nom.equals(auteur.nom) && Objects.equals(paysOrigine, auteur.paysOrigine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prenom, nom, paysOrigine);
    }
}
