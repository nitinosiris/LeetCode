public class BinarySearchTemplate {
    private int BinarySearch(int[] arr, int target)
    {
        int low = 0;
        int high = arr.length - 1;

        while(low <= high)
        {
            int mid = low + (high - low) / 2;

            if(arr[mid] == target)
                return mid;
            else if(arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }

    private int LowerBound(int[] arr, int target) {
        int low = 0, high = arr.length;
    
        while (low < high) 
        {
            int mid = low + (high - low) / 2;
    
            if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid;
        }
    
        return (low < arr.length) ? arr[low] : -1;
    }
    
    private int UpperBound(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
    
        while (low <= high) 
        {
            int mid = low + (high - low) / 2;
    
            if (arr[mid] <= target)
                low = mid + 1;
            else
                high = mid - 1;
        }
    
        return (low < arr.length) ? arr[low] : -1;
    }
    

    public static void main(String[] args)
    {
        BinarySearchTemplate sol = new BinarySearchTemplate();
        int[] arr = {1, 2, 3, 4, 6, 7, 8, 9};
        // System.out.println(sol.BinarySearch(arr, 2));
        // System.out.println(sol.BinarySearch(arr, 1));
        // System.out.println(sol.BinarySearch(arr, 9));
        // System.out.println(sol.BinarySearch(arr, -1));

        // System.out.println(sol.LowerBound(arr, 2));
        // System.out.println(sol.LowerBound(arr, 1));
        // System.out.println(sol.LowerBound(arr, 9));
        // System.out.println(sol.LowerBound(arr, 5));

        System.out.println(sol.UpperBound(arr, 2));
        System.out.println(sol.UpperBound(arr, 1));
        System.out.println(sol.UpperBound(arr, 10));
        System.out.println(sol.UpperBound(arr, 5));
    }
}

