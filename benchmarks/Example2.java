import java.util.*;

class Example2 {

    public static int computeMin(ArrayList<Integer> list) {
	int res = list.get(0).intValue();
	for(Integer IntVal : list) {
	    res = Math.min(res, IntVal);
	}
	return res;
    }

    public static void main(String[] args) {

	ArrayList<Integer> list = new ArrayList<>();
	int N = 10;

	for(int i = 0; i < N; i++) {
	    list.add(new Integer(i));
	}

	int min = Integer.MAX_VALUE;
	for(Integer Int : list) {
	    int val = computeMin(list);
	    min = Math.min(min, val);
	}
    }
}
