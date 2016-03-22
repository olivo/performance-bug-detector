import java.util.*;
import soot.*;
import soot.jimple.*;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.util.*;

class PerformanceBugAnalysis extends SceneTransformer {

    // Main entry point to the analysis.
    protected void internalTransform(String phaseName, Map options) {

	System.out.println("=== STARTED PERFORMANCE BUG ANALYSIS ===");

	CallGraph cg = Scene.v().getCallGraph();
	SootClass sootClass = Scene.v().getSootClass("Example1");
	for(SootMethod sootMethod : sootClass.getMethods()) {
	    System.out.println("Found method: " + sootMethod.getSignature());
	}

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
