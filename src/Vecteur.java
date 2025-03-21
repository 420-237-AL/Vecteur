public class Vecteur {
    private static final int RATIO_AGRANDISSEMENT = 2;
    private static final int CAPACITE_INITIALE = 5;

    private char[] tab;
    private int nbElements;

    public Vecteur(int capaciteInitiale) {
        this.tab = new char[capaciteInitiale];
        this.nbElements = 0;
    }

    public Vecteur() {
        this(CAPACITE_INITIALE); // Délégation au constructeur avec une taille initiale.
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("[");
        for (int i = 0; i < nbElements - 1; i++)
            s.append(tab[i]).append(", ");
        if (nbElements > 0)
            s.append(tab[nbElements - 1]);
        return s + "]";
    }
}
