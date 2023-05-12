import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Test3 {

    public static int solution(int[] a) {
        if (a.length == 0 || a.length > 100000) {
            return -1;
        }
        Arrays.sort(a);
        if (a[0] > 0) {
            return 0;
        }
        List<Deque<Integer>> res = new ArrayList<>();
        backtrack(a, 0, res, 0, new LinkedList<>());
        return res.size();
    }

    static void backtrack(int[] candidates, int target, List<Deque<Integer>> res, int i, Deque<Integer> tmp_list) {
        if (target < 0)
            return;
        if (target == 0) {
            res.add(tmp_list);
            return;
        }

        for (int start = i; start < candidates.length; start++) {
            if (target < candidates[start])
                break;
            if (start > i && candidates[start] == candidates[start - 1]) {
                continue;
            }
            tmp_list.push(candidates[start]);
            backtrack(candidates, target - candidates[start], res, start + 1, tmp_list);

            tmp_list.pop();
        }
    }

    public static void main(String[] args) {
        int[] a = new int[] { 2, -2, 3, 0, 4, -7 };
        System.out.println(Test3.solution(a));

    }
}
