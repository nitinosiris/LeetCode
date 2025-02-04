public class MaxArea {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maximumArea = 0;

        int area = 0;
        while(start < end)
        {
            if (height[start] > height[end])
            {
                area = (end - start) * height[end];
                end--;
            }
            else
            {
                area = (end - start) * height[start];
                start++;
            }
            maximumArea = Math.max(maximumArea, area);
        }
        return maximumArea;
    }
}
