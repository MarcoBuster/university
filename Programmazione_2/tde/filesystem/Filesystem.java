package filesystem;

public class Filesystem {
    public static void main(String[] args) {
        System.out.println("test");

        Directory root = new Directory("");
        
        File a = new File("a", 10);
        root.addEntry(a);
        System.out.println(a.path.toString());
        
        Directory d = new Directory("d");
        root.addEntry(d);
        File b = new File("b", 20);
        File c = new File("c", 40);
        d.addEntry(b);
        d.addEntry(c);
        System.out.println(b.path.toString());
        System.out.println("Dimensione root: " + root.dimensione());

        Shell bash = new Shell(root);
        bash.pwd();
        bash.cd("d");
        bash.ls();
        bash.cd();
        bash.pwd();
        bash.ls("d");
        bash.mkdir("test");
    }
}
