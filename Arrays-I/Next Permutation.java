class Solution {
    public void nextPermutation(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        //  Map is just to store the index of all the numbers, in case to find the smallest element greater than nums[i]
        boolean is_ok = false;
        for(int i = nums.length - 1; i >= 0; i--) {
            // Find the break-point, i: Break-point means the first index i from the back of the given array where arr[i] becomes smaller than arr[i+1].
            if(i < nums.length - 1 && nums[i] < nums[i + 1]) {
                int ind = -1;
                // swap with the number just greater than the nums[i], and sort the succesing half i.e., (i + 1, n)
                if(map.ceilingKey(nums[i] + 1) != null) {
                    ind = map.get(map.ceilingKey(nums[i] + 1));
                    int temp = nums[ind];
                    nums[ind] = nums[i];
                    nums[i] = temp;
                    Arrays.sort(nums, i + 1, nums.length);
                    is_ok = true;
                    break;
                }
            }
                map.put(nums[i], i);
        }
        if(!is_ok) Arrays.sort(nums);
    }
}
