import org.junit.jupiter.api.Test; // Ce 'import' permet de créer des annotations '@Test'.

import static org.junit.jupiter.api.Assertions.*; // Cet import contient les méthodes 'assert*()'.

class VecteurTest {
    // On peut initialiser des variables membres comme dans n'importe quelle classe,
    Vecteur v1 = new Vecteur(2); // Mais elles seront réinitialisées à chaque test.
    // Et les tests unitaires peuvent être exécutés dans n'importe quel ordre par JUnit.

    @Test
    void ajouterElement() {
        v1.ajouter('A');
        v1.ajouter('C');
        v1.ajouter('E');

        // Un test unitaire "vide" (ou tout simplement sans assertions) passe toujours,
        // donc il faut toujours s'assurer d'en ajouter pour qu'il serve à quelque chose.
        assertEquals(3, v1.getNbElements());
        assertEquals("[A, C, E]", v1.toString());
    }

    @Test
    void ajouterIndex() {
        // Étape 1: Préparer les données du test
        v1.ajouter('A');
        v1.ajouter('C');
        v1.ajouter('E');

        // Étape 2: Utiliser la ou les méthodes à tester
        v1.ajouter('B', 1);
        v1.ajouter('D', 3);

        // Étape 3: Valider les résultats attendus vs. obtenus
        assertEquals(5, v1.getNbElements());
        assertEquals("[A, B, C, D, E]", v1.toString());
    }

    @Test
    void ajouterTout() {
        // Pas besoin d'une tonne de données, souvent quelques-unes suffisent.
        v1.ajouter('A');
        v1.ajouter('C');
        v1.ajouter('E');

        Vecteur v2 = new Vecteur();
        v2.ajouter('F');
        v2.ajouter('G');
        v2.ajouter('H');

        v1.ajouterTout(v2);

        assertEquals(6, v1.getNbElements());
        assertEquals("[A, C, E, F, G, H]", v1.toString());
    }
}
