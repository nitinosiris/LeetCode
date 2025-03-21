import java.util.*;

public static class MusicalNotes {
//    Given the following constraints, generate all possible sequences of "musical notes":
//    Each sequence must sum to 12.
//    The possible notes in a sequence are 1, 2, and 3.
//    The transitions between notes are restricted as follows:
//            1 can be followed only by 2 or 3.
//            2 can be followed only by 1 or 2.
//            3 can be followed only by 1.
//    The first and last notes of a sequence must also follow the valid transition rules.
//    Return all possible valid sequences as an array of sequences, in any order.

    static List<List<Integer>> res;
    static HashMap<Integer, HashSet<Integer>> map;
    public static List<List<Integer>> MusicNotes(int sum)
    {
        map = new HashMap<>();
        map.put(1, new HashSet<>(Arrays.asList(2, 3)));
        map.put(2, new HashSet<>(Arrays.asList(1, 2)));
        map.put(3, new HashSet<>(Arrays.asList(1)));


        res = new ArrayList<>();
        if(sum == 0)
        {
            res.add(new ArrayList<>());
        }
        for(int i = 1; i <=3; i++)
        {
            backtrack(new ArrayList<>(), 0, i);
        }
        return res;
    }
    public static void backtrack(List<Integer> currList, int currSum, int num)
    {

        if(currSum > 12)
        {
            return;
        }
        if (currSum == 12) {

            if (map.get(currList.get(0)).contains(currList.get(currList.size() - 1)))
            {
                res.add(new ArrayList<>(currList));
            }
            return;
        }
        else
        {
            for (var next : map.get(num))
            {
                if (currSum + next <= 12)
                {
                    currList.add(next);
                    backtrack(currList, currSum + next, next);
                    currList.removeLast();
                }
            }
        }
    }

    public static void main(String[] args)
    {
        var res = MusicalNotes.MusicNotes(12);
        for(var temp : res)
            System.out.println(temp);

    }
}
