// Class representing a method summary

import java.util.HashSet;
import soot.Value;


class MethodSummary {
    private HashSet<Value> traversals;
    private HashSet<Value> writes;
    private HashSet<Value> accesses;
    
    public MethodSummary() {
	this.traversals = new HashSet<Value>();
	this.writes = new HashSet<Value>();
	this.accesses = new HashSet<Value>();
    }
}
