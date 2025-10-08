package jokes.solutions;

import java.io.IOException;

public class FacadeDemo {
    
    private ApiFacade facade;
    
    public FacadeDemo() {
        this.facade = new ApiFacade();
    }
    
    public String getRandomJoke() throws IOException {
        return facade.getAttributeValueFromJson(
            "https://api.chucknorris.io/jokes/random", 
            "value"
        );
    }
    
    public String getEurToUsdRate() throws IOException {

        String rates = facade.getAttributeValueFromJson(
            "https://api.exchangerate-api.com/v4/latest/EUR",
            "rates"
        );

        return facade.extractAttributeFromJson(rates, "USD");
    }
    
    public static void main(String[] args) {
        FacadeDemo demo = new FacadeDemo();
        
        System.out.println("Chuck Norris Joke API");
        try {
            String joke = demo.getRandomJoke();
            System.out.println("Joke: " + joke);
            System.out.println();
        } catch (IOException e) {
            System.err.println("Error fetching joke: " + e.getMessage());
        }
        
        System.out.println("Foreign Exchange Rates API");
        try {
            String rates = demo.getEurToUsdRate();
            System.out.println("Exchange rates from EUR: " + rates);
            System.out.println();
        } catch (IOException e) {
            System.err.println("Error fetching exchange rates: " + e.getMessage());
        }
        
        System.out.println("Error Handling: Invalid URL");
        try {
            ApiFacade facade = new ApiFacade();
            facade.getAttributeValueFromJson("not-a-valid-url", "value");
        } catch (IOException e) {
            System.out.println("Caught expected error: " + e.getMessage());
            System.out.println();
        }
        
        System.out.println("Error Handling: Attribute Not Found");
        try {
            ApiFacade facade = new ApiFacade();
            facade.getAttributeValueFromJson(
                "https://api.chucknorris.io/jokes/random", 
                "nonexistent_attribute"
            );
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected error: " + e.getMessage());
            System.out.println();
        } catch (IOException e) {
            System.err.println("Unexpected IO error: " + e.getMessage());
        }
        
        System.out.println("Error Handling: Invalid Domain");
        try {
            ApiFacade facade = new ApiFacade();
            facade.getAttributeValueFromJson(
                "https://this-domain-does-not-exist-12345.com/api", 
                "value"
            );
        } catch (IOException e) {
            System.out.println("Caught expected error: " + e.getMessage());
        }
    }
}