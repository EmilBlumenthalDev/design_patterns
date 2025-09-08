package chain_of_responsibility;

public class ContactHandler implements Handler {
    private Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    @Override
    public void handleMessage(Message message) {
        if (message.getType() == MessageType.CONTACT_REQUEST) {
            System.out.println("ContactHandler processed message: " + message.getContent());
            System.out.println("Replying: 'Have you tried taking a look at our webstite " + message.getSenderEmail() + "?'");
        } else if (next != null) {
            next.handleMessage(message);
        } else {
            System.out.println("No handler available for message: " + message.getContent());
        }
    }
    
}
