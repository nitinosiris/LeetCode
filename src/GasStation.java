public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalTank = 0; // Tracks total gas - cost for the entire circuit
        int currTank = 0;  // Tracks gas - cost for the current journey
        int start = 0;     // Candidate starting station

        for (int i = 0; i < n; i++) {
            int netGain = gas[i] - cost[i];
            totalTank += netGain;
            currTank += netGain;

            // If at any point the current tank is negative, the journey from `start` cannot continue
            if (currTank < 0) {
                // Reset the starting point to the next station
                start = (i + 1) % n;
                currTank = 0; // Reset the current tank for the new start
            }
        }

        // Check if the total gas - cost across all stations is non-negative
        return totalTank >= 0 ? start : -1;
    }
}
