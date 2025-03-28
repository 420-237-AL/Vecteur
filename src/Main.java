public class Main {
    public static void main(String[] args) {
        Vecteur v1 = new Vecteur(2);
        System.out.print(v1.getNbElements() + ": ");
        System.out.println(v1);

        // Test de ajouter(element) et agrandir()
        v1.ajouter('A');
        v1.ajouter('C');
        v1.ajouter('E');
        System.out.print(v1.getNbElements() + ": ");
        System.out.println(v1);

        // Test de ajouter(index)
        v1.ajouter('B', 1);
        v1.ajouter('D', 3);
        System.out.print(v1.getNbElements() + ": ");
        System.out.println(v1);

        // Test de ajouterTout(vecteur)
        Vecteur v2 = new Vecteur();
        v2.ajouter('F');
        v2.ajouter('G');
        v2.ajouter('H');
        System.out.println("v2=" + v2);

        v1.ajouterTout(v2);
        System.out.print(v1.getNbElements() + ": ");
        System.out.println(v1);

        //v1.ajouter(v1);
        //System.out.print(v1.getNbElements() + ": ");
        //System.out.println(v1);

        // Test de trouver(element)
        System.out.print("i= " + v1.trouver('D'));
        System.out.print(", " + v1.trouver('A'));
        System.out.print(", " + v1.trouver('H'));
        System.out.println(", " + v1.trouver('K'));

        // Test de trouver(vecteur)
        Vecteur v3 = new Vecteur(4);
        v3.ajouter('D');
        v3.ajouter('A');
        v3.ajouter('H');
        System.out.print("r=" + v1.trouver(v3));
        System.out.println(": " + v1.trouverTout(v3));

        v3.ajouter('X');
        System.out.print("r=" + v1.trouver(v3));
        System.out.println(": " + v1.trouverTout(v3));

        // Test de effacer(index)
        v1.retirer('D');
        v1.retirer('A');
        v1.retirer('H');
        v1.retirer('X');
        System.out.print("n=" + v1.getNbElements());
        System.out.println(", v=" + v1);

        // Test de effacer(vecteur)
        Vecteur v4 = new Vecteur(4);
        v4.ajouter('E');
        v4.ajouter('B');
        v4.ajouter('G');
        v4.ajouter('X');
        System.out.print("r=" + v1.retirerTout(v4));
        System.out.print(", n=" + v1.getNbElements());
        System.out.println(", v=" + v1);
    }
}
