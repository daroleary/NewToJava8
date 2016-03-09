import java.io.File;
import java.io.FileFilter;

public class FirstLambda {

    public static void main(String[] args) {

	// lambda replaces use of anonymous classes
//	FileFilter filter = new FileFilter() {
//
//	    @Override
//	    public boolean accept(File pathname) {
//		return pathname.getName().endsWith(".java");
//	    }
//	};

	FileFilter filter1 = (File pathname) -> pathname.getName().endsWith(".java");

	File dir = new File("/tmp/javaFiles");
	File[] files = dir.listFiles(filter1);

	for (File file : files) {
	    System.out.println(file);
	}
    }
}
