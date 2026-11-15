# Pattern card: sliding window

A window is a contiguous stretch `nums[left..right]` that moves left to right. Each element enters the window once (on the right) and leaves at most once (on the left), so the whole scan is O(n) instead of the O(n²) "restart from every start" loop.

## When to use it (trigger words in the problem)

- "subarray" or "substring" (contiguous), and a condition on that stretch
- "of size k", "k consecutive" → **fixed size**
- "minimum length", "smallest subarray with sum ≥ target" → **shortest valid**
- "longest", "maximum length", "at most k", "without repeating" → **longest valid**
- Grow/shrink only works if adding an element can only make the window "more" and removing only "less" (for example all numbers positive). With negative numbers, think prefix sums instead.

## Fixed size (LC 643)

My idea: remove the first element of the window and add the next element, so the window slides without two loops.

```java
int sum = 0;
for (int i = 0; i < k; i++) sum += nums[i];      // first window
int best = sum;
for (int i = k; i < n; i++) {
    sum += nums[i];          // comes in on the right
    sum -= nums[i - k];      // falls off on the left
    best = Math.max(best, sum);
}
```

## Shortest valid (LC 209)

My idea: keep growing the right side until the window meets the target, then remove elements from the left and note the length each time, until the sum drops below the target, so the next element added can give a better length.

```java
int left = 0, sum = 0, ans = Integer.MAX_VALUE;
for (int right = 0; right < n; right++) {
    sum += nums[right];                  // grow
    while (sum >= target) {              // valid: record, then try shorter
        ans = Math.min(ans, right - left + 1);
        sum -= nums[left++];
    }
}
return ans == Integer.MAX_VALUE ? 0 : ans;
```

## Longest valid (LC 3, LC 1004)

My idea: I already have this length, so to move on to the next best length I may need to remove many elements from the start. Use a while loop to drop elements from the left until the window is valid again (back to at most k zeros, or no repeat).

```java
int left = 0, bad = 0, ans = 0;           // bad = zeros (1004) or repeats (3)
for (int right = 0; right < n; right++) {
    if (isBad(nums[right])) bad++;        // grow
    while (bad > k) {                     // broken: shrink until valid
        if (isBad(nums[left])) bad--;
        left++;
    }
    ans = Math.max(ans, right - left + 1); // valid again: record
}
```

**Shortest records inside the `while` (every step is still valid). Longest records after it (only valid once shrinking stops).**

Problems: 643, 3, 209, 1004 (see problem-log.md). Still to do: 438 (fixed size + counts), 424 (longest valid with a max-frequency check).
