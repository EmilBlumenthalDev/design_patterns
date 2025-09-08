package chain_of_responsibility;

public class SuggestionHandler implements Handler {
    private Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    @Override
    public void handleMessage(Message message) {
        if (message.getType() == MessageType.DEVELOPMENT_SUGGESTION) {
            System.out.println("Handling development suggestion: " + message.getContent());
            System.out.println("Damn, that's a good idea! We'll TOTALLY consider it for future updates.");
        } else if (next != null) {
            next.handleMessage(message);
        } else {
            System.out.println("No handler available for message type: " + message.getType());
        }
    }

}
