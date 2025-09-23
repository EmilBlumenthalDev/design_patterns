package proxy;

public class Main {
    public static void main(String[] args) {
        User matti = new User("Matti");
        User teppo = new User("Teppo");
        User jaska = new User("Jaska");

        Library library = new Library();

        Document doc1 = new Document(IdCounter.getNextId(), "Unprotected document content");
        library.addDocument(doc1);

        String[] allowedUsers = {"Matti", "Teppo"};
        library.addProtectedDocument(IdCounter.getNextId(), "Secret document content", allowedUsers);

        try {
            System.out.println("Matti reads doc1: " + library.getDocument(1).getContent(matti));
            System.out.println("Teppo reads doc1: " + library.getDocument(1).getContent(teppo));
            System.out.println("Jaska reads doc1: " + library.getDocument(1).getContent(jaska));

            System.out.println("Matti reads protectedDoc: " + library.getDocument(2).getContent(matti));
            System.out.println("Teppo reads protectedDoc: " + library.getDocument(2).getContent(teppo));

            System.out.println("Jaska reads protectedDoc: " + library.getDocument(2).getContent(jaska));
        } catch (AccessDeniedException e) {
            System.out.println("Access denied: " + e.getMessage());
        }
    }
}
