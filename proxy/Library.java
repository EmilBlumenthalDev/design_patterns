package proxy;

import java.util.HashMap;

public class Library {
    private HashMap<Integer, DocumentInterface> documents = new HashMap<>();

    public void addDocument(Document doc) {
        documents.put(doc.getId(), doc);
    }

    public DocumentProxy addProtectedDocument(int id, String content, String[] allowedUsers) {
        Document realDoc = new Document(id, content);

        AccessControlService acs = AccessControlService.getInstance();
        for (String username : allowedUsers) {
            acs.allowUser(id, username);
        }

        DocumentProxy proxy = new DocumentProxy(realDoc);

        documents.put(id, proxy);

        return proxy;
    }

    public DocumentInterface getDocument(int id) {
        return documents.get(id);
    }
}
