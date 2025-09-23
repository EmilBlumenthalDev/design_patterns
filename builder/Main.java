public class Main {
    public static void main(String[] args) {
        System.out.println("Building a Gaming Computer:");
        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        ComputerDirector director = new ComputerDirector(gamingBuilder);
        Computer gamingComputer = director.constructComputer();
        System.out.println(gamingComputer);
        System.out.println();

        System.out.println("Building an Office Computer:");
        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        director.setBuilder(officeBuilder);
        Computer officeComputer = director.constructComputer();
        System.out.println(officeComputer);
        System.out.println();

        System.out.println("Building a Custom Gaming Computer (without director):");
        ComputerBuilder customBuilder = new GamingComputerBuilder();
        customBuilder.buildProcessor();
        customBuilder.buildRam();
        customBuilder.buildHardDrive();
        customBuilder.buildGraphicsCard();
        customBuilder.buildOperatingSystem();
        Computer customComputer = customBuilder.getComputer();
        System.out.println(customComputer);
    }
}
