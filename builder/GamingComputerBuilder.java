public class GamingComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer();
    }

    public void buildProcessor() {
        computer.setProcessor("Ryzen 7 9700X");
    }

    public void buildRam() {
        computer.setRam("32 GB DDR5");
    }

    public void buildHardDrive() {
        computer.setHardDrive("1 TB M2 SSD");
    }

    public void buildGraphicsCard() {
        computer.setGraphicsCard("NVIDIA RTX 5090");
    }

    public void buildOperatingSystem() {
        computer.setOperatingSystem("Windows 11");
    }

    public Computer getComputer() {
        return computer;
    }
}
