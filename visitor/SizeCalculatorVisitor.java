import java.util.List;

public class SizeCalculatorVisitor implements FileSystemVisitor {
    private float totalSize = 0;

    public float getTotalSize() {
        return totalSize;
    }

    @Override
    public void visit(File file) {
        totalSize += file.getSize();  // add file size
    }

    @Override
    public void visit(Directory directory) {
        // visit each element in the directory
        for (FileSystemElement element : directory.getChildren()) {
            element.accept(this);
        }
    }
}
