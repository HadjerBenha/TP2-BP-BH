package livres;

public class OuvrageAudio extends Ouvrage {



        private int dureeEnMinutes;
        private Format format;

        public OuvrageAudio(String titre, Auteur auteur, int dureeEnMinutes, Format format) {
            super(titre, auteur);
            this.dureeEnMinutes=dureeEnMinutes;
            this.format=format;
        }

        public int getDureeEnMinutes() {
            return dureeEnMinutes;
        }

        public void setDureeEnMinutes(int dureeEnMinutes) {
            assert dureeEnMinutes > 0 : "La durée doit être positive.";
            this.dureeEnMinutes = dureeEnMinutes;
        }

        public Format getFormat() {
            return format;
        }

        public void setFormat(Format format) {
            assert format != null : "Le format ne peut pas être null.";
            this.format = format;
        }

        @Override
        public String toString() {
            return "OuvrageAudio{" +
                    "duree en Minutes=" + dureeEnMinutes +
                    ", Format=" + format +
                    '}';
        }

}
