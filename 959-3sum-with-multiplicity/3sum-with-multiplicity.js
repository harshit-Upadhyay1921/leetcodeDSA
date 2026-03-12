/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var threeSumMulti = function(nums, target) {
    nums.sort((a, b) => a - b);
    const n = nums.length;
    let count = 0;
    const MOD = 1_000_000_007;

    for (let i = 0; i < n - 2; i++) {
        let j = i + 1;
        let k = n - 1;
        let reqSum = target - nums[i];

        while (j < k) {
            let currentSum = nums[j] + nums[k];
            if (currentSum === reqSum) {
                // Case 1: nums[j] and nums[k] are different
                if (nums[j] !== nums[k]) {
                    let jCount = 1;
                    let kCount = 1;
                    // Count occurrences of nums[j]
                    while (j + 1 < k && nums[j] === nums[j+1]) {
                        jCount++;
                        j++;
                    }
                    // Count occurrences of nums[k]
                    while (k - 1 > j && nums[k] === nums[k-1]) {
                        kCount++;
                        k--;
                    }
                    
                    count += (jCount * kCount);
                    j++; // Move j to find new distinct number
                    k--; // Move k to find new distinct number
                } 
                // Case 2: nums[j] and nums[k] are the same
                else { // nums[j] === nums[k]
                    // All elements from j to k are identical
                    const length = k - j + 1;
                    // Choose 2 elements from 'length' identical elements
                    count += (length * (length - 1)) / 2;
                    break; // All valid pairs for current i are found
                }
            } else if (currentSum < reqSum) {
                j++;
            } else { // currentSum > reqSum
                k--;
            }
        }
    }
    
    return count % MOD;
};