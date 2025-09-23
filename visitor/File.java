public class File implements FileSystemElement {
    private float size;
    private String name;

    public File(String name, float size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public float getSize() {
        return size;
    }

    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}
