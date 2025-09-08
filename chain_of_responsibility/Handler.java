package chain_of_responsibility;

public interface Handler {
    void handleMessage(Message message);
    void setNext(Handler next);
}
