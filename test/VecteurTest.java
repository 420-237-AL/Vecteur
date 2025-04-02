import static org.junit.jupiter.api.Assertions.*;

class VecteurTest {

    @org.junit.jupiter.api.Test
    void ajouterElement() {
        Vecteur v1 = new Vecteur(2);

        v1.ajouter('X');
        v1.ajouter('C');
        v1.ajouter('E');

        assertEquals(3, v1.getNbElements());
        assertEquals("[A, C, E]", v1.toString());
    }

    @org.junit.jupiter.api.Test
    void ajouterIndex() {
    }

    @org.junit.jupiter.api.Test
    void ajouterTout() {
    }
}