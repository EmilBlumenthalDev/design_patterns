package chain_of_responsibility;

public class CompensationHandler implements Handler {
    private Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }
    
    @Override
    public void handleMessage(Message message) {
        if (message.getType() == MessageType.COMPENSATION_CLAIM) {
            System.out.println("CompensationHandler: Processing compensation claim for " + message.getSenderEmail());
            System.out.println("We are an american company, claim AUTODENIED");
        } else if (next != null) {
            next.handleMessage(message);
        }
    }
}
