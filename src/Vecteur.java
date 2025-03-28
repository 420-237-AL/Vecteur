public class Vecteur {
    private static final int RATIO_AGRANDISSEMENT = 2;
    private static final int CAPACITE_INITIALE = 5;

    private char[] tab;
    private int nbElements;

    // Constructeur avec une capacité initiale configurable (n'est pas exigé dans les notes de cours)
    public Vecteur(int capaciteInitiale) {
        this.tab = new char[capaciteInitiale];
        this.nbElements = 0;
    }

    // Constructeur vide (qui utilise la capacité initiale par défaut)
    public Vecteur() {
        this(CAPACITE_INITIALE); // Délégation au constructeur avec une taille initiale.
    }

    public int getNbElements() {
        return nbElements;
    }

    public boolean estVide() {
        return nbElements == 0;
    }

    private boolean estPlein() {
        return nbElements == tab.length;
    }

    private void agrandir() { // appelé 'resize()' dans les notes de cours
        char[] newTab = new char[tab.length * RATIO_AGRANDISSEMENT];
        for (int i = 0; i < tab.length; i++)
            newTab[i] = tab[i];
        tab = newTab;
    }

    public void ajouter(char element) { // équivalent à 'ArrayList.add()'
        if (estPlein())
            agrandir();
        tab[nbElements++] = element;
    }

    public void ajouter(char element, int index) { // équivalent à 'ArrayList.addAll()'
        if (estPlein())
            agrandir();
        for (int i = nbElements; i >= index; i--)
            tab[i] = tab[i - 1];
        tab[index] = element;
        nbElements++;
    }

    public void ajouter(Vecteur autre) { // équivalent à 'ArrayList.append()'
        int stop = autre.nbElements; // Cette ligne permet d'éviter une boucle infinie si autre == this;
        for (int i = 0; i < stop; i++)
            this.ajouter(autre.tab[i]);
    }

    public int trouver(char element) { // équivalent à 'ArrayList.indexOf()'
        for (int i = 0; i < nbElements; i++)
            if (tab[i] == element)
                return i;
        return -1;
    }

    public int trouver(Vecteur autre) {
        int commun = 0;
        for (int j = 0; j < autre.nbElements; j++)
            if (this.trouver(autre.tab[j]) != -1)
                commun++;
        return commun;
    }

    public boolean trouverTout(Vecteur autre) {
        return (trouver(autre) == autre.nbElements);
    }

    @Override
    public String toString() { // N'est pas exigé dans les notes de cours, mais très pratique.
        StringBuilder s = new StringBuilder("[");
        for (int i = 0; i < nbElements - 1; i++)
            s.append(tab[i]).append(", ");
        if (nbElements > 0)
            s.append(tab[nbElements - 1]);
        return s + "]";
    }
}
