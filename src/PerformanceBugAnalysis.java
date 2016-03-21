import java.util.*;
import soot.*;
import soot.jimple.*;
import soot.util.*;


class PerformanceBugAnalysis extends SceneTransformer {

    // Main entry point to the analysis.
    protected void internalTransform(String phaseName, Map options) {

	System.out.println("=== STARTED PERFORMANCE BUG ANALYSIS ===");

	System.out.println("=== FINISHED PERFORMANCE BUG ANALYSIS ===");
    }

    private static PerformanceBugAnalysis instance = null;
    public static PerformanceBugAnalysis v() {
	if(instance == null) {
	    instance = new PerformanceBugAnalysis();
	}
	return instance;
    }
}
