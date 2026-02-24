# 🎯 Interview Questions: SQL & Java DSA

> 📺 *YouTube-ready study guide — perfect for Java & SQL coding interview prep*

---

## 📋 Table of Contents

- [📊 Problem 1: Average Response Time (SQL)](#-problem-1-average-response-time-sql)
- [⏱️ Problem 2: Maximum Non-Overlapping Intervals (Java)](#️-problem-2-maximum-non-overlapping-intervals-java)

---

## 📊 Problem 1: Average Response Time (SQL)

### 🧩 Problem Statement

A customer support team wants to analyze response times for resolved tickets to measure performance and improve service quality.

**Table: `support_tickets`**

| Column | Type | Description |
|--------|------|-------------|
| `id` | INT | Unique ticket identifier |
| `customer_id` | INT | Customer reference |
| `created_at` | DATETIME | Ticket creation time |
| `resolved_at` | DATETIME | Ticket resolution time (NULL if not resolved) |

---

### 🎯 Goal

Calculate the **average response time** (in hours) across all **resolved** tickets, rounded to 2 decimal places.

---

### 📥 Example Input

**`support_tickets`**

| id | customer_id | created_at | resolved_at |
|----|-------------|--------------------------|--------------------------|
| 1 | 1 | 2023-12-21 05:42:00 | 2024-01-01 05:42:00 |
| 2 | 2 | 2023-07-08 14:22:00 | NULL |
| 3 | 3 | 2023-05-22 08:54:00 | 2023-06-17 08:54:00 |

### 📤 Expected Output

| average_response_time |
|-----------------------|
| 444.00 |

---

### 🧠 Dry Run (Visual Walkthrough)

```
Ticket 1: resolved_at - created_at = 11 days = 264 hours  ✅ Include
Ticket 2: resolved_at IS NULL                              ❌ Skip
Ticket 3: resolved_at - created_at = 26 days = 624 hours  ✅ Include

AVG(264, 624) = 888 / 2 = 444.00 ✅
```

---

### 💡 Approach

1. **Filter** → Ignore tickets where `resolved_at IS NULL`
2. **Difference** → Calculate time between `created_at` and `resolved_at`
3. **Convert** → Transform seconds → hours (divide by 3600)
4. **Average** → Use `AVG()` across all resolved tickets
5. **Format** → Round to 2 decimal places using `ROUND(..., 2)`

---

### 🛠️ SQL Solution

```sql
SELECT 
    ROUND(
        AVG(TIMESTAMPDIFF(SECOND, created_at, resolved_at) / 3600),
        2
    ) AS average_response_time
FROM support_tickets
WHERE resolved_at IS NOT NULL;
```

---

### 🔍 Line-by-Line Explanation

| Code | What it does |
|------|--------------|
| `WHERE resolved_at IS NOT NULL` | Filters out unresolved tickets |
| `TIMESTAMPDIFF(SECOND, created_at, resolved_at)` | Gets exact difference in seconds |
| `/ 3600` | Converts seconds → hours with decimals |
| `AVG(...)` | Computes the mean response time |
| `ROUND(..., 2)` | Formats result to 2 decimal places |

---

### ⚠️ Common Mistake

```sql
-- ❌ WRONG — loses decimal precision
TIMESTAMPDIFF(HOUR, created_at, resolved_at)

-- ✅ CORRECT — calculates in seconds, then converts
TIMESTAMPDIFF(SECOND, created_at, resolved_at) / 3600
```

> `TIMESTAMPDIFF(HOUR, ...)` truncates to whole hours — you lose precision!
> Always calculate in **seconds**, then divide by **3600**.

---

### ⏱️ Complexity

| | Complexity |
|-|------------|
| **Time** | O(n) — single pass over resolved tickets |
| **Space** | O(1) — no extra storage needed |

---

### 🚀 Key Interview Insights

- Always use `IS NOT NULL` (not `!= NULL`) for NULL checks in SQL
- Use `SECOND` precision + `/3600` instead of `HOUR` to preserve decimal values
- `ROUND(value, 2)` ensures consistent output formatting for reports

---
---

## ⏱️ Problem 2: Maximum Non-Overlapping Intervals (Java)

### 🧩 Problem Statement

You are given two lists:
- `l[i]` → start time of interval `i`
- `r[i]` → end time of interval `i`

Each index `i` represents an interval: **`[l[i], r[i]]`**

Two intervals are **non-overlapping** if one ends **before or exactly when** the other begins.

---

### 🎯 Goal

Find the **maximum number** of non-overlapping (disjoint) intervals that can be selected.

---

### 📥 Examples

**Example 1**
```
Input:
l = [3, 4, 5]
r = [5, 9, 8]

Intervals: [3,5], [4,9], [5,8]

Output: 2
```

**Example 2**
```
Input:
l = [3, 5, 7]
r = [4, 6, 8]

Intervals: [3,4], [5,6], [7,8]

Output: 3   ← all are non-overlapping!
```

---

### 💡 Approach — Greedy (Activity Selection)

**Key Idea:** Always pick the interval that **finishes earliest** — it leaves the most room for future selections.

#### Steps:
1. Combine `l` and `r` into pairs: `[start, end]`
2. **Sort by end time** (earliest end first)
3. Track `lastEnd` — the end time of the last selected interval
4. For each interval: if `start >= lastEnd`, select it and update `lastEnd`

---

### 🧠 Dry Run — Example 1

```
Input intervals: [3,5], [4,9], [5,8]

After sorting by end time:
  [3,5]  → end=5
  [5,8]  → end=8
  [4,9]  → end=9

lastEnd = MIN_VALUE, count = 0

Step 1: [3,5]  → start(3) >= lastEnd(-∞) ✅ → count=1, lastEnd=5
Step 2: [5,8]  → start(5) >= lastEnd(5)  ✅ → count=2, lastEnd=8
Step 3: [4,9]  → start(4) >= lastEnd(8)  ❌ → skip

Result: 2 ✅
```

---

### 🛠️ Java Solution

```java
import java.util.*;

public class Solution {

    public static int getMaxDisjointIntervals(List<Integer> l, List<Integer> r) {

        int n = l.size();

        // Step 1: Create interval pairs [start, end]
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new int[]{l.get(i), r.get(i)});
        }

        // Step 2: Sort by END time (greedy key!)
        Collections.sort(list, (a, b) -> a[1] - b[1]);

        int count = 0;
        int lastEnd = Integer.MIN_VALUE;

        // Step 3: Greedy selection
        for (int[] cur : list) {
            int start = cur[0];
            int end   = cur[1];

            if (start >= lastEnd) {  // Non-overlapping check
                count++;
                lastEnd = end;
            }
        }

        return count;
    }
}
```

---

### 🔍 Line-by-Line Explanation

| Code | What it does |
|------|--------------|
| `list.add(new int[]{l.get(i), r.get(i)})` | Pairs up start and end times |
| `Collections.sort(..., (a,b) -> a[1]-b[1])` | Sorts by end time (greedy key) |
| `int lastEnd = Integer.MIN_VALUE` | Ensures first interval always qualifies |
| `if (start >= lastEnd)` | Allows touching boundaries like [3,5] & [5,8] |
| `lastEnd = end` | Updates boundary for next comparison |

---

### ⚠️ Common Mistakes

```java
// ❌ WRONG — sort by start time
Collections.sort(list, (a, b) -> a[0] - b[0]);

// ✅ CORRECT — sort by end time
Collections.sort(list, (a, b) -> a[1] - b[1]);
```

```java
// ❌ WRONG — strict greater than misses touching intervals
if (start > lastEnd)    // [3,5] and [5,8] would be skipped!

// ✅ CORRECT — >= allows touching boundaries
if (start >= lastEnd)
```

---

### ⏱️ Complexity

| | Complexity |
|-|------------|
| **Time** | O(n log n) — dominated by sorting |
| **Space** | O(n) — storing interval pairs |

---

### 🚀 Key Interview Insights

- This is a classic **Activity Selection / Greedy** problem
- **Why end-time sorting works:** Choosing the earliest finishing interval maximizes future options
- The `>=` boundary condition is crucial — intervals sharing a point are still disjoint
- `Integer.MIN_VALUE` as the initial `lastEnd` guarantees the first interval is always selected

---

### ✅ Edge Cases to Handle

| Edge Case | Behavior |
|-----------|----------|
| Empty list | Returns 0 |
| Single interval | Returns 1 |
| All overlapping | Returns 1 |
| None overlapping | Returns n |
| Touching boundaries (`[3,5]` & `[5,8]`) | Both selected ✅ |
| Negative values | Works correctly ✅ |

---

### 🔗 Related Problems (LeetCode)

| Problem | Number |
|---------|--------|
| Non-overlapping Intervals | #435 |
| Meeting Rooms II | #253 |
| Activity Selection (Classic) | — |
| Merge Intervals | #56 |

---

## 🏁 Summary

| Problem | Approach | Time | Space |
|---------|----------|------|-------|
| Avg Response Time (SQL) | Filter + TIMESTAMPDIFF in seconds / 3600 | O(n) | O(1) |
| Max Non-Overlapping Intervals (Java) | Greedy — sort by end time | O(n log n) | O(n) |

---

> 💡 **Pro Tip for Interviews:** Always think about *what to sort by* in greedy interval problems. Sorting by **end time** is the key insight that makes the solution optimal — and is what interviewers are listening for!

---

*⭐ Star this repo if it helped you! Follow for more interview prep content.*
