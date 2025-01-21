import java.util.PriorityQueue;

public class KthLargetInUnsortedArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int num : nums) {
            pq.offer(num);  // offer() method se element ko heap mein add karte hain
        }

        for(int i = 1; i < k; i++)
        {
            pq.poll();
        }

        return pq.peek();
    }
}
