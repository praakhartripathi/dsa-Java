


# DFS (Depth-First Search) on Binary Tree — Beginner Friendly

## Overview

Depth-First Search (DFS) is a tree traversal technique where we explore a branch as deeply as possible before backtracking.
It is commonly used in binary trees, graphs, recursion problems, and many coding interview questions.

This README explains DFS using a simple tree example and a Java implementation.

---

## Basic Idea

Think of DFS as following one rule:

> Go deep first, then come back and explore other branches.

Steps:

1. Move down one branch.
2. Continue deeper while possible.
3. If no further nodes exist, return to the previous node.
4. Explore remaining branches.

---

## Example Tree

```
        1
       / \
      2   3
     / \
    4   5
```

### DFS Traversal Order (Preorder)

```
1 → 2 → 4 → 5 → 3
```

---

## Definition

DFS (Depth-First Search) explores nodes by prioritizing depth before breadth.
In trees, DFS is typically implemented using recursion.

---

## Java Implementation

### TreeNode Class

```java
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
```

---

### DFS Traversal (Preorder)

```java
public class DFSTreeExample {

    public static void dfs(TreeNode root) {

        if (root == null) return;

        // Visit current node
        System.out.print(root.val + " ");

        // Traverse left subtree
        dfs(root.left);

        // Traverse right subtree
        dfs(root.right);
    }

    public static void main(String[] args) {

        /*
                1
               / \
              2   3
             / \
            4   5
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        dfs(root);
    }
}
```

---

## Output

```
1 2 4 5 3
```

---

## Why DFS is Important

* Works efficiently on trees and graphs
* Natural fit for recursive problems
* Frequently used in coding interviews
* Common in backtracking and path-based problems

---

## Complexity Analysis

| Metric           | Complexity                  |
| ---------------- | --------------------------- |
| Time Complexity  | O(n)                        |
| Space Complexity | O(h) where h is tree height |

---

## Memory Tip

Preorder DFS follows:

```
Root → Left → Right
```

---

