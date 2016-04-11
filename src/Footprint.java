import java.util.HashSet;
class Footprint {

    private HashSet<HeapObject> values;

    public Footprint(){
	values = new HashSet<HeapObject>();
    }
}
