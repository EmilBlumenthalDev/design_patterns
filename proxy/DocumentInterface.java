package proxy;

import java.time.LocalDateTime;

public interface DocumentInterface {
    int getId();
    LocalDateTime getCreationDate();
    String getContent(User user) throws AccessDeniedException;
}