public class OfficeComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public OfficeComputerBuilder() {
        this.computer = new Computer();
    }

    public void buildProcessor() {
        computer.setProcessor("Pentium Gold G6400");
    }

    public void buildRam() {
        computer.setRam("4 GB DDR3");
    }

    public void buildHardDrive() {
        computer.setHardDrive("128 GB HDD");
    }

    public void buildGraphicsCard() {
        computer.setGraphicsCard("Nvidia GeForce FX5200");
    }

    public void buildOperatingSystem() {
        computer.setOperatingSystem("Windows vista");
    }

    public Computer getComputer() {
        return computer;
    }
}
