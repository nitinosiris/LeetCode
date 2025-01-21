import java.util.PriorityQueue;

public class kthLargest {
    private int k = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public kthLargest(int k, int[] nums) {
        this.k = k;
        for(int i = 0; i < nums.length; i++)
        {
            pq.add(nums[i]);
        }
    }

    public int add(int val) {
        pq.add(val);

        while(pq.size() > k)
            pq.poll();

        return pq.peek();
    }
}
