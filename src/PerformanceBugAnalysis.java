import java.util.*;
import soot.*;
import soot.jimple.*;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;
import soot.util.*;

class PerformanceBugAnalysis extends SceneTransformer {

    String mainClassName;

    public PerformanceBugAnalysis(String mainClassName) {
	this.mainClassName = mainClassName;
    }
    
    // Main entry point to the analysis.
    protected void internalTransform(String phaseName, Map options) {

	System.out.println("=== STARTED PERFORMANCE BUG ANALYSIS ===");

	CallGraph callGraph = Scene.v().getCallGraph();
	SootClass sootClass = Scene.v().getSootClass(mainClassName);
	
	for(SootMethod sootMethod : sootClass.getMethods()) {
	    System.out.println("Found method: " + sootMethod.getSignature());
	    Iterator<Edge> edges = callGraph.edgesInto(sootMethod);
	    System.out.println("The predecessors are: ");
	    while(edges.hasNext()) {
		Edge edge = edges.next();
		System.out.println("Predecessor: " + edge.getSrc().method().getSignature());
	    }
	    System.out.println();
	}

	System.out.println("=== FINISHED PERFORMANCE BUG ANALYSIS ===");
    }

    private static PerformanceBugAnalysis instance = null;
    
    public static PerformanceBugAnalysis v(String mainClassName) {
	if(instance == null) {
	    instance = new PerformanceBugAnalysis(mainClassName);
	}
	return instance;
    }
}
