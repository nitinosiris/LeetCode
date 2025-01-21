import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for(int i = 0; i < stones.length; i++)
        {
            pq.add(stones[i]);
        }

        while(pq.size() > 1)
        {
            int y = pq.poll();
            int x = 0;
            if(pq.size() > 0)
                x = pq.poll();

            if(x != y)
                pq.offer(y - x);
        }

        if(pq.size() > 0 && pq.peek() != 0)
            return pq.peek();

        return 0;
    }
}
