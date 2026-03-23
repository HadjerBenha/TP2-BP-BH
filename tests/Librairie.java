package tests;

import livres.*;

import java.util.ArrayList;
import java.util.List;

public class Librairie {
    private List<Auteur> auteurs  = new ArrayList<>();
    private List<Ouvrage> ouvrages = new ArrayList<>();

    public Librairie(){
        Auteur albertine = new Auteur("Albertine", "Tremblay", new Pays("Canada", "CAN"));
        Auteur john = new Auteur("John", "Smith", new Pays("Etats Unies", "USA"));
        Auteur jean = new Auteur("Jean", "Némarre", new Pays("Suisse", "SUI"));
        auteurs.add(albertine);
        auteurs.add(john);
        auteurs.add(jean);

        ouvrages.add(new OuvragePapier("Titre 1", john,25));
        ouvrages.add(new OuvragePapier("Titre 2", albertine, 80));
        ouvrages.add(new OuvragePapier("Titre 3", john,45));
        ouvrages.add(new OuvragePapier("Titre 4", john,90));
        ouvrages.add(new OuvragePapier("Titre 5", albertine,68));
        ouvrages.add(new OuvragePapier("Titre 6", john,74));
        ouvrages.add(new OuvragePapier("Titre 7", john,54));
        ouvrages.add(new OuvrageVideo("Titre 8", albertine, 20, 2.50));
        ouvrages.add(new OuvrageAudio("Titre 9", john,20, Format.ANALOGIQUE));
        ouvrages.add(new OuvragePapier("Titre 10", jean,59));
    }

    public List<Auteur> getAuteurs() {
        return auteurs;
    }

    public List<Ouvrage> getOuvrages() {
        return ouvrages;
    }

    public List<Ouvrage> trouverOuvrages(Auteur auteur) {
        //ATTENTION il faut implémenter equals dans auteur pour que ca marche!!!!!
        int count = 0;

        List<Ouvrage> trouves = new ArrayList<>();
        for (Ouvrage ouvrage : ouvrages) {
            if (ouvrage.getAuteur().equals(auteur)) {
                trouves.add(ouvrage);
            }
        }

        return trouves;
    }
}
