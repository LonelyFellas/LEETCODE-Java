import SearchBinary.SearchBinaryDay1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SearchBinaryDay1 searchBinaryDay1 = new SearchBinaryDay1();
//        List<Integer> result = searchBinaryDay1.targetIndices(new int[] {1,2,5,2,3}, 5);
        int result = searchBinaryDay1.search(new int[] {-1,0,3,5,9,12}, -1, false);
        System.out.println(result);
    }
}