import java.util.ArrayList;
import java.util.List;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>();
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--)
        {
            var sum = digits[i] + carry;
            if(sum >= 10)
            {
                list.add(0);
                carry = 1;
            }
            else
            {
                list.add(sum);
                carry = 0;
            }
        }
        if(carry == 1)
            list.add(1);

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(list.size() - 1 - i);  // Reverse the list to get the correct order
        }
        return result;
    }
}
