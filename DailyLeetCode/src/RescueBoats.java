import java.util.Arrays;

public class RescueBoats {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;
        int start = 0, end = people.length - 1;
        if(start == end)
            return 1;

        int i = end;
        while(i >= 0 && people[i] >= limit)
        {
            ans++;
            i--;
        }

        end = i;
        while(start < end)
        {
            var sum = people[start] + people[end];
            if(sum == limit)
            {
                start++;
                end--;
            }
            else if(sum > limit)
            {
                end--;
            }
            else
            {
                start++;
                end--;
            }
            ans++;
        }
        if(start == end)
            ans++;
        return ans;
    }
}
