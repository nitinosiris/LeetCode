public class BuyAndSell {
    public int maxProfit(int[] prices) {
        int left = 0, right = 1;
        int ans = 0;
        while(right < prices.length)
        {
            if(prices[left] > prices[right])
            {
                left = right;
            }
            else
            {
                ans = Math.max(prices[right] - prices[left], ans);
            }
            right++;
        }

        return ans;
    }
}
