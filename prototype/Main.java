public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Astrid Lindgren", "Ronja, ryövärintytär", "Lastenkirjallisuus", 1949);
        Book book2 = new Book("Aleksis Kivi", "Seitsemän veljestä", "Romaani", 1870);
        Book book3 = new Book("Astrid Lindgren", "Mio, poikani mio", "Fantasiafiktio", 1954);

        Recommendation rec1 = new Recommendation("Lastenkirjallisuus");
        rec1.addBook(book1);
        rec1.addBook(book3);

        System.out.println("Original recommendation:");
        System.out.println(rec1);

        Recommendation rec2 = rec1.clone();
        rec2.setTargetAudience("Kaikki lukijat");
        rec2.addBook(book2);

        System.out.println("Cloned and modified recommendation:");
        System.out.println(rec2);

        System.out.println("Original recommendation after cloning:");
        System.out.println(rec1);
    }
}
