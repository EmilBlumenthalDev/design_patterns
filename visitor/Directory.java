import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemElement {
    private String name;
    private List<FileSystemElement> elements;

     public Directory(String name) {
        this.name = name;
        this.elements = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addElement(FileSystemElement element) {
        elements.add(element);
    }

    public List<FileSystemElement> getChildren() {
        return elements;
    }

    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}
