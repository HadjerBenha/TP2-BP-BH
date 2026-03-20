package livres;

import java.util.ArrayList;
import java.util.List;

/**
 * 420-243-LI DÉVELOPPEMENT INFORMATIQUE
 * TP2 - BP-BH
 * Nom : Benhagouga
 * Prénom: Hajder
 */
public class Serie {

    private String nom;
    private List<Ouvrage> ouvrages;

    public Serie(String nom, List<Ouvrage> ouvrages) {
        this.nom = nom;
        this.ouvrages = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Ouvrage> getOuvrages() {
        return ouvrages;
    }

    public void setOuvrages(List<Ouvrage> ouvrages) {
        this.ouvrages = ouvrages;
    }

    /**
     * Ajoute un ouvrage a la série
     *
     * @param ouvrage a ajouter.
     */
    public void ajouterOuvrage(Ouvrage ouvrage) {
        if (ouvrage != null) {
            this.ouvrages.add(ouvrage);
        }
    }

    /**
     * Retire un ouvrage de la série s'il existe déja
     *
     * @param ouvrage
     */
    public void retirerOuvrage(Ouvrage ouvrage) {
        this.ouvrages.remove(ouvrage);

    }

    @Override
    public String toString() {
        return "Série : " + nom + " (" + ouvrages.size() + " ouvrage(s) dans la liste)";
    }

}
