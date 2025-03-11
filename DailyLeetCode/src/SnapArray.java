import java.util.HashMap;

class SnapArray {
    int[] currData;
    HashMap<Integer, HashMap<Integer, Integer>> snapshots;
    int snapCount;

    public SnapArray(int length) {
        currData = new int[length];
        snapshots = new HashMap<>();
        snapCount = 0;
    }

    public void set(int index, int val) {
        currData[index] = val;
    }

    public int snap() {
        HashMap<Integer, Integer> snapshot = new HashMap<>();

        if (snapCount == 0) {
            for (int i = 0; i < currData.length; i++) {
                snapshot.put(i, currData[i]);
            }
        } else {
            HashMap<Integer, Integer> lastSnapshot = snapshots.get(snapCount - 1);
            for (int i = 0; i < currData.length; i++) {
                if (!lastSnapshot.containsKey(i) || lastSnapshot.get(i) != currData[i]) {
                    snapshot.put(i, currData[i]);
                }
            }
        }

        snapshots.put(snapCount, snapshot);
        return snapCount++;
    }

    public int get(int index, int snap_id) {
        while (snap_id >= 0) {
            HashMap<Integer, Integer> snapshot = snapshots.get(snap_id);
            if (snapshot != null && snapshot.containsKey(index)) {
                return snapshot.get(index);
            }
            snap_id--;
        }
        return 0; // Default value for indices not set in any snapshot
    }
}
