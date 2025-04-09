import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test; // Ce 'import' permet de créer des annotations '@Test'.

import static org.junit.jupiter.api.Assertions.*; // Cet import contient les méthodes 'assert*()'.

class VecteurTest {
    // On peut déclarer des variables membres comme dans n'importe quelle classe.
    Vecteur v1;

    // La méthode 'setUp()' sert à initialiser les objets à tester pour éviter de toujours recopier le même code.
    @BeforeEach
    void setUp() { //
        v1 = new Vecteur();
        v1.ajouter('A');
        v1.ajouter('C');
        v1.ajouter('E');
    }

    // Attention, les tests unitaires peuvent être exécutés dans n'importe quel ordre par JUnit!
    // Vous ne devez pas assumer qu'un test sera exécuté avant ou après un autre;
    // Ils doivent tous être indépendants les uns des autres.

    @Test
    void ajouterElement() {
        // Un test unitaire "vide" (ou tout simplement sans assertions) passe toujours,
        // donc il faut toujours s'assurer d'en ajouter au moins une pour qu'il serve à quelque chose.
        assertEquals(3, v1.getNbElements());
        assertEquals("[A, C, E]", v1.toString());
    }

    @Test
    void ajouterIndex() {
        // Étape 1: Préparer les données du test
        // Ici, on se fie sur la méthode setUp() pour mettre les 3 premiers éléments dans v1.

        // Étape 2: Utiliser la ou les méthodes à tester
        v1.ajouter('B', 1);
        v1.ajouter('D', 3);

        // Étape 3: Valider les résultats attendus vs. obtenus
        assertEquals(5, v1.getNbElements());
        assertEquals("[A, B, C, D, E]", v1.toString());
    }

    @Test
    void ajouterTout() {
        // Étape 1: Préparer les données du test
        // Pas besoin de préparer une tonne de données, souvent quelques-unes suffisent.
        Vecteur v2 = new Vecteur();
        v2.ajouter('F');
        v2.ajouter('G');
        v2.ajouter('H');

        // Étape 2: Utiliser la ou les méthodes à tester
        v1.ajouterTout(v2);

        // Étape 3: Valider les résultats attendus vs. obtenus
        assertEquals(6, v1.getNbElements());
        assertEquals("[A, C, E, F, G, H]", v1.toString());
    }

    @Test
    void trouverElement() {
        // Étape 1: Préparer les données du test
        // Ici aussi, on se fie sur la méthode setUp() pour mettre les 3 premiers éléments dans v1.

        // Étapes 2 et 3: Valider les résultats attendus vs. obtenus
        assertEquals(0, v1.trouver('A'));
        assertEquals(1, v1.trouver('C'));
        assertEquals(2, v1.trouver('E'));
        assertEquals(-1, v1.trouver('X'));
    }

    @Test
    void trouverTout() {
        // Étape 1: Préparer les données du test
        v1 = new Vecteur(); // Cette fois, on préfère partir d'un nouveau vecteur configuré sur mesure.
        v1.ajouter('A');
        v1.ajouter('B');
        v1.ajouter('C');
        v1.ajouter('D');
        v1.ajouter('E');

        Vecteur v2 = new Vecteur();
        v2.ajouter('A');
        v2.ajouter('C');
        v2.ajouter('E');

        // Étapes 2 et 3: Valider les résultats attendus vs. obtenus
        assertEquals(3, v1.trouverNbCommuns(v2));
        assertTrue(v1.trouverTout(v2)); // 'assertTrue(val)' est équivalent à 'assertEquals(true, val)'

        v2.ajouter('X');
        assertEquals(3, v1.trouverNbCommuns(v2));
        assertFalse(v1.trouverTout(v2));
    }

    @Test
    void retirerIndex() {
        // Étape 1: Préparer les données du test
        // Ici aussi, on se fie sur la méthode setUp() pour mettre les 3 premiers éléments dans v1.

        // Autre test: retirer
        v1.retirer('X');
        assertEquals(3, v1.getNbElements());
        assertEquals("[A, C, E]", v1.toString());

        // Étape 2: Utiliser la ou les méthodes à tester
        v1.retirer('C');
        v1.retirer('E');
        v1.retirer('A');

        // Étape 3: Valider les résultats attendus vs. obtenus
        assertEquals(0, v1.getNbElements());
        assertEquals("[]", v1.toString());
    }
}
