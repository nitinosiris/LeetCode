public class KokoEatingBanan {
    public int minEatingSpeed(int[] piles, int h) {
        int maxSpeed = 0;
        for(var pile : piles)
            maxSpeed = Math.max(maxSpeed, pile);

        int start = 1, end = maxSpeed;
        while(start <= end)
        {
            int mid = start + (end - start) / 2;
            if(isItPossible(mid, piles) > h)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return start;
    }

    private Integer isItPossible(int k, int[] piles)
    {
        int totalTime = 0;
        for(int pile : piles)
        {
            totalTime += Math.ceil((pile + k - 1)/ k);
        }
        return totalTime;
    }

}
