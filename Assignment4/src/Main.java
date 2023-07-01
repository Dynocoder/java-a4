public class Main {
    public static void main(String[] args) {

        Deck myDeck = new Deck();


        System.out.println(myDeck.toString());

        boolean test = false;
        double a = 52.932323;

        if (!test) {
            System.out.println("false");
            System.out.println((int)(Math.random()*52));
            System.out.println((int)a);
        }
    }
}
