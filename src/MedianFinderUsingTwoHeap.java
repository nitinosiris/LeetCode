import java.util.PriorityQueue;

public class MedianFinderUsingTwoHeap {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinderUsingTwoHeap() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        if(maxHeap.isEmpty() || maxHeap.peek() >= num)
            maxHeap.add(num);
        else
            minHeap.add(num);

        balance();
    }

    private void balance()
    {
        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
        else if (maxHeap.size() < minHeap.size())
            maxHeap.add(minHeap.poll());
    }

    public double findMedian() {
        if(maxHeap.size() == minHeap.size())
            return (double) (maxHeap.peek() + minHeap.peek()) / 2.0;
        else
            return (double) maxHeap.peek();
    }
}
