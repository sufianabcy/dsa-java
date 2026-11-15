# Problem log

| Date | Problem | Pattern | Alone? | Insight |
| --- | --- | --- | --- | --- |
| 8 Nov | 643 Maximum Average Subarray I | Sliding window, fixed size | Yes | the trick was to add the next element and remove the prev element so we can move forward with k window and that's how we get O(n) |
| 9 Nov | 3 Longest Substring Without Repeating Characters | Sliding window, grow and shrink | hints | In this problem the main concept was to keep moving forward (high) and when you find any duplicate character you have to move forward the low .Low removes each letter it passes from the set, until the duplicate is gone. |
| 15 Nov | 209 Minimum Size Subarray Sum | Sliding window, shortest (shrink while valid) | hints | Keep adding on the right; while sum >= target, record the length and push left forward, stopping at the exact point where dropping left makes the sum less than target. |
| 15 Nov | 1004 Max Consecutive Ones III | Sliding window, longest (at most k zeros) | hints | I already have this length, so to reach the next best one I remove elements from the left with a while loop until the window is back to at most k zeros, then record. |
| 15 Nov | 53 Maximum Subarray | Kadane | hints | At each number, compare carrying the running sum against starting fresh here; a negative running sum only hurts, so drop it. Start sum and best at nums[0] so all-negative arrays work. |
