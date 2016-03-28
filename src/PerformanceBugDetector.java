import soot.*;
import soot.jimple.*;
import soot.util.*;

public class PerformanceBugDetector {

    public static void main(String[] args) {
	System.out.println("=== STARTED PERFORMANCE BUG DETECTION ===");
	String mainClassName = "";
	//The last argument is the main class name.
	if(args.length >= 7) {
	    mainClassName = args[args.length - 1];
	}
	System.out.println("Starting analysis over class: " + mainClassName);

	Pack pack = PackManager.v().getPack("wjtp");
	Transform transform = new Transform("wjtp.PerformanceBugAnalysis", PerformanceBugAnalysis.v(mainClassName));
	pack.add(transform);
	soot.Main.main(args);
	System.out.println("=== FINISHED PERFORMANCE BUG DETECTION ===");



    }
}
