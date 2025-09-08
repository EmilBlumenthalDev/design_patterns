package chain_of_responsibility;

public class main {
    public static void main(String[] args) {
        Handler generalFeedbackHandler = new FeedbackHandler();
        Handler compensationClaimHandler = new CompensationHandler();
        Handler contactRequestHandler = new ContactHandler();
        Handler developmentSuggestionHandler = new SuggestionHandler();

        generalFeedbackHandler.setNext(compensationClaimHandler);
        compensationClaimHandler.setNext(contactRequestHandler);
        contactRequestHandler.setNext(developmentSuggestionHandler);

        Message msg1 = new Message(MessageType.GENERAL_FEEDBACK, "YOU DENIED MY CLAIM!?", "Customer1@metropolia.fi");
        Message msg2 = new Message(MessageType.COMPENSATION_CLAIM, "I WANT MY MONEY BACK", "Customer2@metropolia.fi");
        Message msg3 = new Message(MessageType.CONTACT_REQUEST, "I WANT TO TALK TO YOUR MANAGER!!", "Customer3@metropolia.fi");
        Message msg4 = new Message(MessageType.DEVELOPMENT_SUGGESTION, "SUCK A *****", "Customer4@metropolia.fi");
        Message msg5 = new Message(MessageType.COMPENSATION_CLAIM, "Send robux plz", "Customer2@metropolia.fi");

        Message[] messages = {msg1, msg2, msg3, msg4, msg5};

        for (Message msg : new Message[]{msg1, msg2, msg3, msg4, msg5}) {
            generalFeedbackHandler.handleMessage(msg);
            System.out.println("-----");
        }
    }
}