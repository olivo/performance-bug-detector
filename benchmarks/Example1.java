import java.util.*;

class Example1 {

    public static void main(String[] args) {

	ArrayList<Integer> list = new ArrayList<>();
	int N = 10;

	for(int i = 0; i < N; i++) {
	    list.add(new Integer(i));
	}

	int min = Integer.MAX_VALUE;
	for(Integer Int : list) {
	    for(Integer IntVal : list) {
		if(IntVal.intValue() < min) {
		    min = IntVal.intValue();
		}
	    }
	}
    }
}
