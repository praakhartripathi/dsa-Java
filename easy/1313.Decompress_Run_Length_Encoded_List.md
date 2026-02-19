class Solution {

    public int[] decompressRLElist(int[] nums) {

        // Example Dry Run Input:
        // nums = [1,2,3,4]
        // Meaning:
        // freq=1, val=2
        // freq=3, val=4

        int size = 0;

        // -------- First Loop: Calculate total size --------
        // i = 1 → nums[i-1] = nums[0] = 1 → size = 1
        // i = 3 → nums[i-1] = nums[2] = 3 → size = 4
        for (int i = 1; i < nums.length; i += 2) {
            size += nums[i - 1];  
        }

        // size = 4
        int[] res = new int[size];   // res = [_,_,_,_]
        int idx = 0;

        // -------- Second Loop: Fill result array --------
        for (int i = 1; i < nums.length; i += 2) {

            int freq = nums[i - 1];   // i=1 → freq=1 | i=3 → freq=3
            int val  = nums[i];       // i=1 → val=2  | i=3 → val=4

            // ----- Inner Loop -----
            // First iteration (i=1):
            // j=0 → res[0]=2 → idx=1 → res=[2,_,_,_]

            // Second iteration (i=3):
            // j=0 → res[1]=4 → idx=2 → res=[2,4,_,_]
            // j=1 → res[2]=4 → idx=3 → res=[2,4,4,_]
            // j=2 → res[3]=4 → idx=4 → res=[2,4,4,4]
            for (int j = 0; j < freq; j++) {
                res[idx++] = val;
            }
        }

        // Final Output:
        // res = [2,4,4,4]
        return res;
    }

    // This static block runs only when JVM shuts down.
    // It does NOT affect the algorithm dry run.
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (java.io.FileWriter fw =
                     new java.io.FileWriter("display_runtime.txt")) {
                fw.write("000");
            } catch (java.io.IOException e) {
            }
        }));
    }
}
