package tests;

import java.time.LocalDate;
import java.util.List;

import livres.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * CoursPOO 1
 *
 * @author Julien.Brunet màj Jocelyn
 * @since H25
 */
public class TestOuvrage {

    public static void main(String[] args) {
        TestOuvrage test = new TestOuvrage();
        test.testOuvrages();
        test.testTrouver();
        test.testPaysEtAuteur();
        test.testSerie();
        test.testAudioDureeNegativeInvalide();
        test.testAudioFormatNullInvalide();
        test.testOuvrageAudioToString();
        test.testOuvrageVideoToString();
        test.testVideoTailleNegativeInvalide();
        test.testCreerOuvrageVideoValide();
        test.testVideoDureeNegativeInvalide();

        test.testCreerOuvrageVideoValide();
        test.testCreerOuvrageAudioValide();
    }


    public void testOuvrages() {
        //Deux auteurs deja prets pour les tests...
        Auteur albertine = new Auteur("Albertine", "Tremblay", new Pays("Canada", "CAN"));
        Auteur john = new Auteur("John", "Smith", new Pays("Etats-Unis", "USA"));

        //Voici une partie des tests. Il faut en ajouter, pour les fonctionnalités non testées
        System.out.println("-----Test des constructeurs d'ouvrage et des diverses validations-----------");
        Ouvrage livreA = new OuvragePapier("Titre assez long", john,80  );
        System.out.println(livreA);
        Ouvrage livreB = new OuvragePapier("Ti", john,200);
        System.out.println(livreB);
        Ouvrage livreC = new OuvragePapier(null, john,100);
        System.out.println(livreC);

        //bibliotheque.Auteur null et valeur par défaut de l'abibliotheque.Auteur
        Ouvrage livreA1 = new OuvragePapier("Titre assez long", null,500);
        System.out.println(livreA1);
        //bibliotheque.Auteur fonctionnel
        Ouvrage livre1 = new OuvragePapier("Tout va bien", albertine, 55);
        System.out.println(livre1);

        //Date null et valeur par défaut de la date
        livre1.setDate(null);
        System.out.println(livre1);
        livre1.setDate(LocalDate.now().minusYears(5));
        System.out.println(livre1);

        //Test de la validation sur le nb d'exemplaires (valide et non valide)
        Ouvrage livre2 = new OuvragePapier("Tout va bien", albertine,LocalDate.now(), -10,50);
        System.out.println(livre2);

        livre2 = new OuvragePapier("Tout va bien", albertine,  LocalDate.now(), 20,100);
        System.out.println(livre2);

        System.out.println("\n-----Tests des méthodes acheter et vendre-----------");

        Ouvrage livre3 = new OuvragePapier("Musique du hasard", new Auteur("Paul","Auster", new Pays("Russie","RUS")), LocalDate.now(), 5,70);
        System.out.println(livre3);

        livre3.acheter(5);
        System.out.println(livre3);

        System.out.println("On peut vendre 8 livres? " + livre3.vendre(8));
        System.out.println(livre3);

        System.out.println("On peut vendre 10 livres? " + livre3.vendre(10));
        System.out.println(livre3);

        Ouvrage livre4 = new OuvragePapier("Test", albertine,LocalDate.now(), 5,58);

        System.out.println("\n-----Tests de la  méthode equals()-----------");
        //Deux ouvrages égaux
        Ouvrage livre5 = new OuvragePapier("Test", new Auteur("A", "B", new Pays("Etats-Unis", "USA")), LocalDate.now(), 0, 5);
        Ouvrage livre6 = new OuvragePapier("Test", new Auteur("A", "B", new Pays("Etats-Unis", "USA")), LocalDate.now(), 10,178);
        //Un qui ne l'est pas
        Ouvrage livre7 = new OuvragePapier("Test", new Auteur("Z", "B", new Pays("Etats-Unis", "USA")), LocalDate.now(), 5,250);

        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + livre4.equals(livre5));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + livre4.equals(livre6));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + !livre4.equals(livre7));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + !livre4.equals(john));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + !livre4.equals(null));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + !livre4.equals("Test"));
    }


    private void testTrouver() {
        Librairie bibliotheque = new Librairie();
        Auteur john = bibliotheque.getAuteurs().get(1);

        System.out.println("\n-----Test de votre méthode trouverOuvrage-----------");
        List<Ouvrage> resultat = bibliotheque.trouverOuvrages(new Auteur("Albertine", "Tremblay", new Pays("Canada", "CAN")));
        System.out.println("Livres de albertine: " + resultat);

        resultat = bibliotheque.trouverOuvrages(john);
        System.out.println("Livres de john: " + resultat);

        resultat = bibliotheque.trouverOuvrages(new Auteur("Jacques", "Beaulieu", new Pays("France", "FRA")));
        System.out.println("Livres de Jacques: " + resultat);
    }

    /**
     * Test de la classe Pays et de son intégration dans Auteur
     *
     */
    public void testPaysEtAuteur() {
        System.out.println("\n-----  TESTS DE LA CLASSE PAYS ET AUTEUR -----");

        try {
            // Création d'un pays valide
            Pays p1 = new Pays("Canada", "CAN");
            System.out.println("Succès : " + p1);

            // Liaison avec un auteur
            Auteur albertine = new Auteur("Albertine", "Tremblay", p1);
            System.out.println("Auteur créé : " + albertine.getNom() + " originaire de " + albertine.getPaysOrigine().getNom());

            // Test de validation : Code invalide (trop court)
            System.out.println("Tentative avec code 'CA' (devrait échouer)...");
            new Pays("Canada", "CA");

        } catch (IllegalArgumentException e) {
            System.out.println("Validation réussie : Erreur capturée -> " + e.getMessage());
        }

        try {
            // Test de validation : Code invalide (minuscules)
            System.out.println("Tentative avec code 'can' (devrait échouer)...");
            new Pays("Canada", "can");
        } catch (IllegalArgumentException e) {
            System.out.println("Validation réussie : Erreur capturée -> " + e.getMessage());
        }
    }

    /**
     * Test de la classe Serie (Ajout et retrait d'ouvrages)
     *
     */

    public void testSerie() {
        System.out.println("\n-----  TESTS DE LA CLASSE SERIE -----");
        // Création de la série
        Serie maSerie = new Serie("Les Classiques");
        // Création auteur
        Auteur auteur = new Auteur("Victor", "Hugo", new Pays("France", "FRA"));

        // Création d'ouvrages
        Ouvrage o1 = new OuvragePapier("Les Misérables",new Auteur("Victor", "Hugo", new Pays("France", "FRA")),LocalDate.now(),50,600);
        Ouvrage o2 = new OuvragePapier("Notre-Dame de Paris", new Auteur("Angel", "Salt", new Pays("France", "FRA")),LocalDate.now(),7000,30);
        // Ajout
        maSerie.ajouterOuvrage(o1);
        maSerie.ajouterOuvrage(o2);
        System.out.println("Après ajouts : " + maSerie);
        // Retrait
        maSerie.retirerOuvrage(o1);
        System.out.println("Après retrait de 'Les Misérables' : " + maSerie);
        // Vérification du contenu
        if (maSerie.getOuvrages().contains(o2) && !maSerie.getOuvrages().contains(o1)) {
            System.out.println("Test de liste : OK");
        }
    }


    // TEST OUVRAGESAUDIO ET OUVRAGESVIDEO

    //***** Ouvrages audio

    public void testCreerOuvrageAudioValide() {
        OuvrageAudio oa = new OuvrageAudio("Musique", new Auteur("A", "B", new Pays("Canada", "CAN")), 60, Format.NUMERIQUE);
        assertEquals(60, oa.getDureeEnMinutes());
        assertEquals(Format.NUMERIQUE, oa.getFormat());
    }

    public void testAudioDureeNegativeInvalide() {
        assertThrows(AssertionError.class, () -> new OuvrageAudio("Podcast", new Auteur("A", "B", new Pays("France", "FRA")), -5, Format.NUMERIQUE),
                "Durée négative devrait être invalide.");
    }

    public void testOuvrageAudioToString() {
        OuvrageAudio oa = new OuvrageAudio("Audio Poeme", new Auteur("A", "B", new Pays("ETATS UNIS", "USA")), 60,Format.NUMERIQUE);
        assertTrue(oa.toString().contains("Audio"));
        assertTrue(oa.toString().contains("ANALOGIQUE"));
    }

    public void testAudioFormatNullInvalide() {
        assertThrows(AssertionError.class, () ->
                        new OuvrageAudio("Podcast", new Auteur("A", "B", new Pays("Japon", "JAP")), 60, null),
                "Format null devrait être invalide.");
    }


// Test ouvragesVideo

    public void testCreerOuvrageVideoValide() {
        OuvrageVideo ov = new OuvrageVideo("Documentaire", new Auteur("A", "B", new Pays("Suisse", "SUI")), 22, 400.0);
        assertEquals(22, ov.getDureeEnMinutes());
        assertEquals(400.0, ov.getTailleEnMb());
    }

    public void testVideoDureeNegativeInvalide() {
        assertThrows(AssertionError.class, () ->
                        new OuvrageVideo("Serie", new Auteur("C", "B", new Pays("Senegal", "SEN")), -40, 70.8),
                "Durée négative devrait être invalide.");
    }


    public void testVideoTailleNegativeInvalide() {
        assertThrows(AssertionError.class, () ->
                        new OuvrageVideo("Dessin Animés", new Auteur(), 60, -1.5),
                "Taille négative devrait être invalide.");
    }


    public void testOuvrageVideoToString() {
        OuvrageVideo ov = new OuvrageVideo("Documentaire", new Auteur(), 50, 100.5);
        assertTrue(ov.toString().contains("Vidéo"));
        assertTrue(ov.toString().contains("210.1"));
    }

}

