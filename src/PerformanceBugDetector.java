import soot.*;
import soot.jimple.*;
import soot.util.*;

public class PerformanceBugDetector {

    public static void main(String[] args) {
	System.out.println("=== STARTED PERFORMANCE BUG DETECTION ===");
	Pack pack = PackManager.v().getPack("wjtp");
	Transform transform = new Transform("wjtp.PerformanceBugAnalysis", PerformanceBugAnalysis.v());
	pack.add(transform);
	soot.Main.main(args);
	System.out.println("=== FINISHED PERFORMANCE BUG DETECTION ===");
    }
}
