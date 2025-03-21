public class Main {
    public static void main(String[] args) {
        Vecteur v1 = new Vecteur(2);
        System.out.println(v1);

        v1.ajouter('A');
        v1.ajouter('C');
        v1.ajouter('E');
        System.out.println(v1);

        v1.ajouter('B', 1);
        v1.ajouter('D', 3);
        System.out.println(v1);

        Vecteur v2 = new Vecteur();
        v2.ajouter('F');
        v2.ajouter('G');
        v2.ajouter('H');
        System.out.println(v2);

        v1.ajouter(v2);
        System.out.println(v1);

        v1.ajouter(v1);
        System.out.println(v1);
    }
}