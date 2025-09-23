public class Main {
    public static void main(String[] args) {
        File file1 = new File("report.docx", 2.5f);
        File file2 = new File("presentation.pptx", 5.0f);
        File file3 = new File("notes.txt", 1.2f);
        File file4 = new File("image.png", 3.0f);

        Directory root = new Directory("root");
        Directory docs = new Directory("docs");
        Directory images = new Directory("images");

        docs.addElement(file1);
        docs.addElement(file2);
        docs.addElement(file3);
        images.addElement(file4);
        root.addElement(docs);
        root.addElement(images);

        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("Total size of all files: " + sizeVisitor.getTotalSize() + " MB");

        SearchVisitor searchVisitor = new SearchVisitor(".png");
        root.accept(searchVisitor);
        System.out.println("Files matching '.png':");
        for (File f : searchVisitor.getMatchingFiles()) {
            System.out.println(" - " + f.getName());
        }
    }
}
