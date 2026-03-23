package livres;

public class OuvrageVideo extends Ouvrage{
    private int dureeEnMinutes;
    private double tailleEnMb;

    public OuvrageVideo(String titre, Auteur auteur,  int dureeEnMinutes, double tailleEnMb) {
        super(titre, auteur);
        this.dureeEnMinutes=dureeEnMinutes;
        this.tailleEnMb=tailleEnMb;
    }

    public int getDureeEnMinutes() {
        return dureeEnMinutes;
    }

    public void setDureeEnMinutes(int dureeEnMinutes) {
        assert dureeEnMinutes > 0 : "La durée doit être positive.";
        this.dureeEnMinutes = dureeEnMinutes;
    }

    public double getTailleEnMb() {
        return tailleEnMb;
    }

    public void setTailleEnMb(double tailleEnMb) {
        assert tailleEnMb > 0 : "La taille doit être positive.";
        this.tailleEnMb = tailleEnMb;
    }

    @Override
    public String toString() {
        return "OuvrageAudio{" +
                "Duree en Minutes=" + dureeEnMinutes +
                ", taille en Mb=" + tailleEnMb +
                '}';
    }

}
