import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindKClosest {
    public List<Integer> findClosestElements(int[] arr, int k, int x)
    {
        int present = binarySearch(arr, x);
        if(present == arr.length)
            present--;
        if (arr[present] != x)
        {
            if (x < arr[0])
            {
                return Arrays.stream(arr, 0, k)
                        .boxed()
                        .collect(Collectors.toList());
            }
            else if (x > arr[arr.length - 1])
            {
                return Arrays.stream(arr, arr.length - k, arr.length)
                        .boxed()
                        .collect(Collectors.toList());
            }
            else
            {
                System.out.println(present);
                // x is between first and last
                List<Integer> ans = new ArrayList<>();
                int left = present - 1, right = present;
                // ans.add(arr[left]);

                while (ans.size() < k)
                {
                    if (left >= 0 && right < arr.length)
                    {
                        if (Math.abs(arr[left] - x) < Math.abs(arr[right] - x) ||
                                (Math.abs(arr[left] - x) == Math.abs(arr[right] - x) && arr[left] < arr[right]))
                        {
                            ans.add(0, arr[left--]);
                        }
                        else
                        {
                            ans.add(arr[right++]);
                        }
                    }
                    else if (left >= 0)
                    {
                        ans.add(0, arr[left--]);
                    }
                    else if (right < arr.length)
                    {
                        ans.add(arr[right++]);
                    }
                }
                return ans;
            }
        }
        else
        {
            // If the element is found, we consider the k closest elements around it
            List<Integer> ans = new ArrayList<>();
            int left = present - 1, right = present + 1;
            ans.add(arr[present]);

            while (ans.size() < k)
            {
                if (left >= 0 && right < arr.length)
                {
                    if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x))
                    {
                        ans.add(0, arr[left--]);
                    }
                    else
                    {
                        ans.add(arr[right++]);
                    }
                }
                else if (left >= 0)
                {
                    ans.add(0, arr[left--]);
                }
                else if (right < arr.length)
                {
                    ans.add(arr[right++]);
                }
            }
            return ans;
        }
    }

    private int binarySearch(int[] arr, int num)
    {
        int lo = 0, hi = arr.length - 1;

        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == num)
                return mid;
            if (arr[mid] < num)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return lo;
    }
}
