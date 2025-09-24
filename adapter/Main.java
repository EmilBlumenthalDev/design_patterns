public class Main {

    public static void main(String[] args) {
        NewDateInterface dateAdapter = new CalendarToNewDateAdapter();

        System.out.println("Initial date: " + dateAdapter.toString());
        System.out.println("Day: " + dateAdapter.getDay());
        System.out.println("Month: " + dateAdapter.getMonth());
        System.out.println("Year: " + dateAdapter.getYear());

        System.out.println("\n --- Setting a specific date ---");

        dateAdapter.setDay(25);
        dateAdapter.setMonth(12);
        dateAdapter.setYear(2024);

        System.out.println("After setting date to Christmas 2024:");
        System.out.println("Date: " + dateAdapter.toString());
        System.out.println("Day: " + dateAdapter.getDay());
        System.out.println("Month: " + dateAdapter.getMonth());
        System.out.println("Year: " + dateAdapter.getYear());

        System.out.println("\n--- Advancing the date ---");

        System.out.println("Advancing by 10 days...");
        dateAdapter.advanceDays(10);
        System.out.println("New date: " + dateAdapter.toString());

        System.out.println("Advancing by 30 more days...");
        dateAdapter.advanceDays(30);
        System.out.println("New date: " + dateAdapter.toString());

        System.out.println("Going back 50 days...");
        dateAdapter.advanceDays(-50);
        System.out.println("New date: " + dateAdapter.toString());

        System.out.println("\n --- Testing year boundary ---");

        dateAdapter.setDay(31);
        dateAdapter.setMonth(12);
        dateAdapter.setYear(2023);
        System.out.println("Set to New Year's Eve 2023: " + dateAdapter.toString());

        dateAdapter.advanceDays(1);
        System.out.println("After advancing 1 day (crossing year): " + dateAdapter.toString());
    }
}