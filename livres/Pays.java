package livres;

/**
 * TP2-BP-BH
 * Bediakon Prisca
 */
public class Pays {
    private String nom;
    private String code;

    public Pays(String nom, String code) {
        this.nom = nom;
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        assert nom != null : "Le nom du pays ne peut pas être vide.";
        this.nom = nom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        assert code != null && code.matches("[A-Z]{3}")
                : "Le code du pays doit comporter exactement 3 lettres majuscules.";
        this.code = code;
    }

    @Override
    public String toString() {
        return "Pays{" +
                "nom='" + nom + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
