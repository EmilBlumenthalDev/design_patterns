import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable {
    private String targetAudience;
    private List<Book> books = new ArrayList<>();

    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    @Override
    public Recommendation clone() {
        Recommendation copy = new Recommendation(
            this.targetAudience
        );
        copy.targetAudience = this.targetAudience;
        for (Book b : books) {
            copy.books.add(b.clone());
        }
        return copy;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Recommendation for: ").append(targetAudience).append("\n");
        for (Book b : books) {
            sb.append(" - ").append(b).append("\n");
        }
        return sb.toString();
    }
}
