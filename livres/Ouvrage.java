package livres;

import java.time.LocalDate;
import java.util.Objects;

/**
 * CoursPOO 1
 *
 * @author Julien.Brunet màj Jocelyn
 * @since H25
 */

public abstract class Ouvrage {



    public static final String TITRE_INCONNU = "Titre Inconnu";
    public static final int NOMBRE_EXEMPLAIRE_DEFAUT = 0;

    public static final int LONGUEUR_TITRE_MIN = 3;

    private String titre = TITRE_INCONNU;
    private Auteur auteur = new Auteur();
    private LocalDate date;
    private int nombreExemplaires = NOMBRE_EXEMPLAIRE_DEFAUT;


    public Ouvrage(String titre, Auteur auteur,
                   LocalDate date, int nombreExemplaires) {
        setTitre(titre);
        setAuteur(auteur);

        setDate(date);
        setNombreExemplaires(nombreExemplaires);
    }
    public Ouvrage(String titre, Auteur auteur) {
        this(titre, auteur,  null, NOMBRE_EXEMPLAIRE_DEFAUT);
    }


    public String getTitre() {
        return titre;
    }

    private void setTitre(String titre) {
        if (Ouvrage.titreValide(titre)) {
            this.titre = titre;
        } else {
            System.out.println("Titre invalide : " + titre);
        }
    }

    public Auteur getAuteur() {
        return auteur;
    }

    private void setAuteur(Auteur auteur) {
        if (auteur != null) {
            this.auteur = auteur;
        } else {
            System.out.println("Un auteur doit être spécifié");
        }
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getNombreExemplaires() {
        return nombreExemplaires;
    }

    private void setNombreExemplaires(int nombreExemplaires) {
        if (Ouvrage.nombreExemplairesValides(nombreExemplaires)) {
            this.nombreExemplaires = nombreExemplaires;
        } else {
            System.out.println("Nombre exemplaires invalide: " + nombreExemplaires);
        }
    }



    public String identificateur() {
        String id = titre.substring(0, 2) + "_" +
                auteur.getNom().substring(0, 1) +
                auteur.getPrenom().substring(0, 1);

        return id.toUpperCase();
    }

    @Override
    public String toString() {

        String affichageDAte = date != null ? date.toString() : "Non Disponible";

        return "[" + identificateur() + "] " + titre + " (" + auteur.getPrenom() + " "
                + auteur.getNom() + ") - " +  " - disponible le " + affichageDAte + " (" + nombreExemplaires + " ex.)";
    }

    public void acheter(int nombre) {
        setNombreExemplaires(getNombreExemplaires() + nombre);
    }

    public boolean vendre(int nombre) {
        boolean possible = false;
        int reste = getNombreExemplaires() - nombre;

        if (Ouvrage.nombreExemplairesValides(reste)) {
            setNombreExemplaires(reste);
            possible = true;
        } else {
            System.out.println("Vente impossible, pas assez d'exemplaires disponibles.");
        }

        return possible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ouvrage)) return false;
        Ouvrage ouvrage = (Ouvrage) o;
        return Objects.equals(titre, ouvrage.titre) &&
                Objects.equals(auteur, ouvrage.auteur) ;

    }

    @Override
    public int hashCode() {
        return Objects.hash(titre, auteur);
    }

    private static boolean nombreExemplairesValides(int nombreExemplaires) {
        return (nombreExemplaires >= 0);
    }

    private static boolean titreValide(String titre) {
        return ((titre != null) && (titre.length() >= Ouvrage.LONGUEUR_TITRE_MIN));
    }
}
