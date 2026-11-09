# Problem log

| Date | Problem | Pattern | Alone? | Insight |
| --- | --- | --- | --- | --- |
| 8 Nov | 643 Maximum Average Subarray I | Sliding window, fixed size | Yes | the trick was to add the next element and remove the prev element so we can move forward with k window and that's how we get O(n) |
| 9 Nov | 3 Longest Substring Without Repeating Characters | Sliding window, grow and shrink | hints | In this problem the main concept was to keep moving forward (high) and when you find any duplicate character you have to move forward the low .Low removes each letter it passes from the set, until the duplicate is gone. |