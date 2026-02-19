
---

```md
#  Difference Between Stack vs Monotonic Stack

The **main difference** is simple:

 A **Stack** is a **data structure**  
 A **Monotonic Stack** is a **pattern/technique** built using a stack

---

#  1. Normal Stack

A **Stack** follows the **LIFO** principle:

> Last In, First Out

## Basic Operations

- `push()` → Add element on top
- `pop()` → Remove top element
- `peek()` → View top element

## Example

```

push 5 → [5]
push 3 → [5,3]
push 8 → [5,3,8]
pop    → [5,3]

```

✔ No ordering rules  
✔ Any number can be pushed anytime  

 Stack is just a **container**.

---

#  2. Monotonic Stack

A **Monotonic Stack** is NOT a new data structure.

It is a **strategy** where elements in the stack are kept in a sorted order.

## Types

### 1️Increasing Monotonic Stack

```

Bottom → Top : Increasing order
Example: [1,3,5,7]

```

### 2️ Decreasing Monotonic Stack

```

Bottom → Top : Decreasing order
Example: [9,6,4,2]

```

## Rule

Before pushing a new element, we may **pop elements** to maintain monotonic order.

### Example (Increasing Stack)

```

Numbers: 3,1,4

push 3 → [3]
push 1 → pop 3 → [1]
push 4 → [1,4]

````

 Elements are removed to keep the stack monotonic.

---

#  Key Differences

| Feature | Stack | Monotonic Stack |
|---|---|---|
| What is it? | Data structure | Algorithmic technique |
| Order required? |  No |  Yes |
| Pop condition | Manual | Pop to maintain order |
| Usage | General problems | Advanced DSA patterns |

---

#  When Do We Use Monotonic Stack?

Common **Interview Problems**:

-  Next Greater Element
- Largest Rectangle in Histogram
- Daily Temperatures
-  Stock Span
- Sliding Window Maximum

 Helps reduce time complexity from **O(n²)** → **O(n)**.

---

# Java Examples

## Normal Stack

```java
Stack<Integer> stack = new Stack<>();
stack.push(5);
stack.push(2);
stack.push(9);
````

---

## Monotonic Increasing Stack

```java
while (!stack.isEmpty() && stack.peek() > num) {
    stack.pop();
}
stack.push(num);
```

 Same `Stack` class — only logic changes.

---

#  Easy Memory Trick

 **Stack** = Container
 **Monotonic Stack** = Strategy + Rules

---

#  Pro Tip (Modern Java)

Prefer using:

```java
Deque<Integer> stack = new ArrayDeque<>();
```

Instead of `Stack<Integer>` because it is faster and recommended.

---

```
