import java.util.Random;

public class RandomIndexWithProb {
    int[] preFix;
    int sz;
    Random rand;

    public Solution(int[] w) {
        sz = w.length;
        preFix = new int[sz];
        rand = new Random();

        preFix[0] = w[0];
        for (int i = 1; i < sz; i++) {
            preFix[i] = preFix[i - 1] + w[i];
        }
    }

    public int pickIndex() {
        int randomValue = rand.nextInt(preFix[sz - 1]); // Range: [0, preFix[sz - 1] - 1]

        int lo = 0, hi = sz - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (preFix[mid] <= randomValue)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }
}
