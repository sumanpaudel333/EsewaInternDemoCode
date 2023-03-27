package Week1;

public class IntChecker {
    public int getSingNum(int[] nums) {
        int count = 0;
        for (int i : nums) {
            for (int j : nums) {
                if (nums[i] == nums[j]) {
                    count = count + 1;
                }
            }
            if (count == 1) {
                System.out.println(nums[i]);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        IntChecker in = new IntChecker();
        System.out.println(in.getSingNum(new int[]{1, 1, 2, 3, 4, 3, 4}));
    }
}
