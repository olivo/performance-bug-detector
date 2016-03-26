import soot.*;
import soot.jimple.*;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;
import soot.util.*;
import java.util.Iterator;

class PointsToAnalysis {

    public GlobalPointsToMap computePointsToMap(String mainClassName) {
		
	CallGraph callGraph = Scene.v().getCallGraph();
	SootClass sootClass = Scene.v().getSootClass(mainClassName);
	GlobalPointsToMap globalPointsToMap = new GlobalPointsToMap();
	
	for(SootMethod sootMethod : sootClass.getMethods()) {
	    
	    PointsToMap pointsToMap = new PointsToMap();
	    System.out.println("Found method: " + sootMethod.getSignature());
	    Iterator<Edge> edges = callGraph.edgesInto(sootMethod);
	    System.out.println("The predecessors are: ");
	    while(edges.hasNext()) {
		Edge edge = edges.next();
		System.out.println("Predecessor: " + edge.getSrc().method().getSignature());
	    }
	    System.out.println();
	}

	return globalPointsToMap;
    }
}
