import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementNewAlgo {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(var num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        List<Integer> res = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : map.entrySet())
            if(entry.getValue() > Math.floor(n / 3))
                res.add(entry.getKey());

        return res;
    }
}
