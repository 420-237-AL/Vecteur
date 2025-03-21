public class Vecteur {
    private char[] tab;
    private int nbElements;

    private static final int RATIO_AGRANDISSEMENT = 2;
    private static final int TAILLE_INITIALE = 2;

    public Vecteur(int tailleInitiale) {
        this.tab = new char[tailleInitiale];
        this.nbElements = 0;
    }

    public Vecteur() {
        this(TAILLE_INITIALE); // Délégation au constructeur avec une taille initiale.
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
