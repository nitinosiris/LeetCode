public class RecTakeNoTake {
    //    You are given an array arr of n positive integers, where each element represents both the score you can gain and
    //    the jump length if you choose that element.

    public int maxJumpScore(int[] arr)
    {
        return rec(0, arr);
    }

    public int rec(int index, int[] arr)
    {
        if(index >= arr.length)
            return 0;

        int take = arr[index] + rec(index + arr[index], arr);
        int noTake = rec(index + 1, arr);

        return Math.max(take, noTake);
    }
}
