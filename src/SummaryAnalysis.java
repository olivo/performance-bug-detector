import soot.*;
import soot.jimple.*;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;
import soot.toolkits.graph.pdg.EnhancedUnitGraph;
import soot.toolkits.graph.UnitGraph;
import soot.util.*;
import java.util.Iterator;
import java.util.LinkedList;


class SummaryAnalysis {

    public GlobalSummary computeGlobalSummary(String mainClassName, GlobalPointsToMap globalPointsToMap) {

	CallGraph callGraph = Scene.v().getCallGraph();
	SootClass sootClass = Scene.v().getSootClass(mainClassName);
	GlobalSummary globalSummary = new GlobalSummary();
	LinkedList<SootMethod> methodQueue = new LinkedList<SootMethod>();

	// Add all methods to process summary.
	for(SootMethod method : sootClass.getMethods()) {

	    methodQueue.add(method);
	}

	return globalSummary;
    }
}
