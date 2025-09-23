package proxy;

import java.time.LocalDateTime;

public class Document implements DocumentInterface {
    public int id;
    public LocalDateTime created_at;
    private String content;

    public Document(int id, String content) {
        this.id = id;
        this.created_at = LocalDateTime.now();
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getCreationDate() {
        return created_at;
    }

    public String getContent(User user) {
        return content;
    }
}
