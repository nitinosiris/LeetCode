import java.util.HashMap;

public class SubArrayWithSumK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int res = 0, currPrefixSum = 0;

        for(var num : nums)
        {
            currPrefixSum += num;

            if(map.containsKey(currPrefixSum - k))
            {
                res += map.get(currPrefixSum - k);
            }

            map.put(currPrefixSum, map.getOrDefault(currPrefixSum, 0) + 1);
        }
        return res;
    }
}
