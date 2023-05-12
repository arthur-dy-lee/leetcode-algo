import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test2 {

    public static int solution(int[] candidates) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), candidates, 0, 0);
        System.out.println(JSONUtil.toJsonStr(res));
        return res.size();
    }

    public static void dfs(List<List<Integer>> res, List<Integer> tmp, int[] candidates, int s, int target) {
        if (target < 0)
            return;
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
        }


        for (int i = s; i < candidates.length; i++) {
            if (candidates[i] == 0) {
                continue;
            }
            tmp.add(candidates[i]);
            dfs(res, tmp, candidates, i + 1, target - candidates[i]);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
                int[] a = new int[] { 2, -2, 3, 0, 4, -7 };
                System.out.println(Test2.solution(a));

//        int[] candidates = new int[] { 2, 3, 5 };
//        System.out.println(Test2.solution(candidates));

    }
}
