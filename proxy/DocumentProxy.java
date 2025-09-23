package proxy;

import java.time.LocalDateTime;

public class DocumentProxy implements DocumentInterface {
    private Document realDocument;

    public DocumentProxy(Document realDocument) {
        this.realDocument = realDocument;
    }

    @Override
    public int getId() {
        return realDocument.getId();
    }

    @Override
    public LocalDateTime getCreationDate() {
        return realDocument.getCreationDate();
    }

    @Override
    public String getContent(User user) throws AccessDeniedException {
        AccessControlService acs = AccessControlService.getInstance();
        if (acs.isAllowed(realDocument.getId(), user.getUsername())) {
            return realDocument.getContent(user);
        } else {
            throw new AccessDeniedException("User " + user.getUsername() + " is not allowed to access this document.");
        }
    }
}
