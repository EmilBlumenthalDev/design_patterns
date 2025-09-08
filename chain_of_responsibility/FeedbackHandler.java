package chain_of_responsibility;

public class FeedbackHandler implements Handler {
    private Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    @Override
    public void handleMessage(Message message) {
        if (message.getType() == MessageType.GENERAL_FEEDBACK) {
            System.out.println("FeedbackHandler: Handling general feedback from " + message.getSenderEmail());
            System.out.println("Thank you for your feedback: " + message.getContent());
        } else if (next != null) {
            next.handleMessage(message);
        } else {
            System.out.println("FeedbackHandler: No handler available for message type " + message.getType());
        }
    }
    
}
