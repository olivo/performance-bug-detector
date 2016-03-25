import soot.*;
import soot.jimple.*;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;
import soot.util.*;
import java.util.Iterator;

class PointsToAnalysis {

    public PointsToMap computePointsToMap(String mainClassName) {
		
	CallGraph callGraph = Scene.v().getCallGraph();
	SootClass sootClass = Scene.v().getSootClass(mainClassName);
	PointsToMap pointsToMap = new PointsToMap();
	
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

	return pointsToMap;
    }
}
