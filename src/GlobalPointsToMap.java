import java.util.HashMap;
import java.util.Set;

class GlobalPointsToMap {

    private HashMap<FunctionSignature, PointsToMap> map;

    public GlobalPointsToMap() {
	map = new HashMap<FunctionSignature, PointsToMap>();
    }

    public void put(FunctionSignature signature, PointsToMap ptsToMap) {
	this.map.put(signature, ptsToMap);
    }

    public PointsToMap get(FunctionSignature signature) {
	return map.get(signature);
    }

    public Set<FunctionSignature> keySet() {
	return map.keySet();
    }

    public void print() {
	for(FunctionSignature signature : keySet()) {
	    System.out.println(signature);
	}
    }
}
