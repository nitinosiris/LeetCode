public class Concatination {
    public int[] getConcatenation(int[] nums) {
        int size = nums.length;
        int[] newArray = new int[2 * size];
        int i = 0;
        for(i = 0; i < size; i++)
            newArray[i] = nums[i];

        for( ;i < 2 * size; i++)
            newArray[i] = nums[i];

        return newArray;
    }
}
