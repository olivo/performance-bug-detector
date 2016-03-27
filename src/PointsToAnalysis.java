import soot.*;
import soot.jimple.*;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;
import soot.util.*;
import java.util.Iterator;
import java.util.LinkedList;

class PointsToAnalysis {

    public GlobalPointsToMap computePointsToMap(String mainClassName) {
		
	CallGraph callGraph = Scene.v().getCallGraph();
	SootClass sootClass = Scene.v().getSootClass(mainClassName);
	GlobalPointsToMap globalPointsToMap = new GlobalPointsToMap();
	LinkedList<SootMethod> methodQueue = new LinkedList<SootMethod>();
	
	// Add all method to the processing queue, and create empty starting points-to maps for them.
	for(SootMethod sootMethod : sootClass.getMethods()) {
	    
	    methodQueue.add(sootMethod);
	    PointsToMap pointsToMap = new PointsToMap();
	    FunctionSignature signature = new FunctionSignature(sootMethod.getDeclaration());
	    globalPointsToMap.put(signature, pointsToMap);
	}

	System.out.println("=== Points-To Maps ===");
	for(FunctionSignature signature : globalPointsToMap.keySet()) {
	    System.out.println(signature);
	}

	return globalPointsToMap;
    }
}
