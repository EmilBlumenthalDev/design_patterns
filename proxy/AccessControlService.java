package proxy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class AccessControlService {
    private static AccessControlService instance;

    private HashMap<Integer, Set<String>> accessMap;

    private AccessControlService() {
        accessMap = new HashMap<>();
    }

    public static AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    public void allowUser(int documentId, String username) {
        accessMap.computeIfAbsent(documentId, k -> new HashSet<>()).add(username);
    }

    public boolean isAllowed(int documentId, String username) {
        return accessMap.containsKey(documentId) && accessMap.get(documentId).contains(username);
    }
}
