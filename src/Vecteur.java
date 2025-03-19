public class Vecteur {
    private int[] tab;
    private int nbElements;

    private static final int RATIO_AGRANDISSEMENT = 2;
    private static final int TAILLE_INITIALE = 2;

    public Vecteur() {
        this.tab = new int[TAILLE_INITIALE];
        this.nbElements = 2;
        tab[0] = 5;
        tab[1] = 6;
    }

    @Override
    public String toString() {
        String s = "[";
        for (int i = 0; i < nbElements - 1; i++)
            s += tab[i] + ", ";
        s += tab[nbElements - 1];
        return s + "]";
    }
}
