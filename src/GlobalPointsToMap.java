import java.util.HashMap;
import java.util.Set;

class GlobalPointsToMap {

    private HashMap<FunctionSignature, PointsToInfo> map;

    public GlobalPointsToMap() {
	map = new HashMap<FunctionSignature, PointsToInfo>();
    }

    public void put(FunctionSignature signature, PointsToInfo ptsToInfo) {
	this.map.put(signature, ptsToInfo);
    }

    public PointsToInfo get(FunctionSignature signature) {
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
