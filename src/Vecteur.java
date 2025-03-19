public class Vecteur {
    private int[] tab;
    private int nbElements;

    private static final int RATIO_AGRANDISSEMENT = 2;
    private static final int TAILLE_INITIALE = 2;

    public Vecteur() {
        this.tab = new int[TAILLE_INITIALE];
        this.nbElements = 0;
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
