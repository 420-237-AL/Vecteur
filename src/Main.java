public class Main {
    public static void main(String[] args) {
        Vecteur v1 = new Vecteur();
        System.out.println(v1);

        v1.ajouter('A');
        v1.ajouter('C');
        v1.ajouter('E');
        System.out.println(v1);

        v1.ajouter('B', 1);
        v1.ajouter('D', 3);
        System.out.println(v1);
    }
}