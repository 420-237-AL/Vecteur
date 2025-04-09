public class Vecteur {
    private static final int RATIO_AGRANDISSEMENT = 2;
    private static final int CAPACITE_INITIALE = 5;

    private char[] tab; // Les données du Vecteur sont stockées dans un tableau (array).
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

    public char get(int index) { // Appelé 'getElementAt()' dans les notes de cours
        if (index >= nbElements)
            throw new IndexOutOfBoundsException(); // Nous verrons les Exceptions plus tard dans le cours.
        return tab[index];
    }

    public int getNbElements() { // Équivalent à 'ArrayList.size()'
        return nbElements;
    }

    public boolean estVide() { // Équivalent à 'ArrayList.isEmpty()'
        return nbElements == 0;
    }

    private boolean estPlein() {
        return nbElements == tab.length;
    }

    private void agrandir() { // Appelé 'resize()' dans les notes de cours
        char[] newTab = new char[tab.length * RATIO_AGRANDISSEMENT];
        for (int i = 0; i < tab.length; i++)
            newTab[i] = tab[i];
        tab = newTab;
    }

    public void ajouter(char element) { // Équivalent à 'ArrayList.add(element)'
        if (estPlein())
            agrandir();
        tab[nbElements++] = element;
    }

    public void ajouter(char element, int index) { // Équivalent à 'ArrayList.add(index, element)'
        if (estPlein())
            agrandir();
        for (int i = nbElements; i >= index; i--)
            tab[i] = tab[i - 1];
        tab[index] = element;
        nbElements++;
    }

    public void ajouterTout(Vecteur autre) { // Équivalent à 'ArrayList.addAll(collection)'
        int stop = autre.nbElements; // Cette ligne permet d'éviter une boucle infinie si autre == this;
        for (int i = 0; i < stop; i++)
            this.ajouter(autre.tab[i]);
    }

    public int trouver(char element) { // Équivalent à 'ArrayList.indexOf(element)'
        for (int i = 0; i < nbElements; i++)
            if (tab[i] == element)
                return i;
        return -1;
    }

    // Cette "surcharge" de trouverTout() retourne le nombre d'éléments communs entre les vecteurs.
    public int trouverNbCommuns(Vecteur autre) { // On ne peut pas l'appeler trouverTout() car seul le type de retour est différent :(
        int communs = 0;
        for (int i = 0; i < autre.nbElements; i++)
            if (this.trouver(autre.tab[i]) != -1)
                communs++;
        return communs;
    }

    public boolean trouverTout(Vecteur autre) {
        return (this.trouverNbCommuns(autre) == autre.nbElements); // Pas besoin d'un 'if' puisque l'opérateur '==' retourne déjà un booléen.
    }

    public boolean retirer(char element) {
        int index = trouver(element);
        if (index == -1) // Ceci est une "clause de garde", ça sert à quitter immédiatement la fonction en cas d'erreur.
            return false;

        nbElements--;
        for (int i = index; i < nbElements; i++)
            tab[i] = tab[i + 1];
        return true;
    }

    public boolean retirerTout(Vecteur autre) {
        boolean reussite = true;
        for (int i = 0; i < autre.nbElements; i++)
            reussite &= this.retirer(autre.tab[i]); // L'opérateur '&=' est comme l'opérateur '+=' mais pour l'opération '&&'.
        return reussite;
    }

    public void retirerTout() { // Équivalent à 'ArrayList.clear()'
        this.tab = new char[CAPACITE_INITIALE]; // Créer un nouveau tableau va libérer la mémoire de l'ancien.
        this.nbElements = 0;
    }

    @Override
    public String toString() { // N'est pas exigé dans les notes de cours, mais est très pratique.
        StringBuilder s = new StringBuilder("["); // Un 'StringBuilder' est comme une 'String', mais beaucoup plus efficace
        if (nbElements > 0)                       // quand on veut fréquemment ajouter (append) des caractères à la string.
            s.append(tab[0]); // Le premier élément est imprimé séparément pour éviter d'avoir une virgule de trop.
        for (int i = 1; i < nbElements; i++) // On commence ensuite la boucle à partir du deuxième noeud:
            s.append(", ").append(tab[i]);
        return s + "]";
    }
}
