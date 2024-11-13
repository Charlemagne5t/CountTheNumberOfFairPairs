class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        Arrays.sort(nums);
        
        long res = 0L;

        for(int i = 0; i < n; i++){
            int targetLow = lower - nums[i];
            int targetUpper = upper - nums[i];
            if(targetLow > nums[n - 1] || targetUpper < nums[0]) {
                continue;
            }
            int left = bsl(nums, targetLow, i);
            int right = bsu(nums, targetUpper);

            res += right - left >= 0 ? right - left + 1 : 0 ;

        }    

        return res;
    }

    int bsl(int[] nums, int target, int left) {
        int l = left + 1;
        int r = nums.length - 1;
        int mid;

        int res = l;

        while(l <= r) {
            mid = l + (r - l) / 2;

            if(nums[mid] < target) {
                l = mid + 1;
            }else {
                r = mid -1;
                res = mid;
            }
        }

        return res;
    }

    int bsu(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid;

        int res = nums.length - 1;

        while(l <= r) {
            mid = l + (r - l) / 2;

            if(nums[mid] <= target) {
                l = mid + 1;
                res = mid;
            }else {
                r = mid -1;
            }
        }

        return res;
    }
}