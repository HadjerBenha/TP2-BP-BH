package livres;

import java.time.LocalDate;

public class OuvragePapier extends Ouvrage{

    private int nombrePages;

    public OuvragePapier(String titre, Auteur auteur, LocalDate date, int nombreExemplaires, int nombrePages) {
        super(titre, auteur, date, nombreExemplaires);
        this.nombrePages = nombrePages;
    }

    public OuvragePapier(String titre, Auteur auteur, int nombrePages) {
        super(titre, auteur);
        this.nombrePages = nombrePages;
    }

    public int getNombrePages() {
        return nombrePages;
    }

    public void setNombrePages(int nombrePages) {
        this.nombrePages = nombrePages;
    }

    @Override
    public String description() {
        return "Ouvrage papier de " + nombrePages + " pages.";
    }

    @Override
    public String toString() {
        return super.toString() + " - " + description();
    }


}
