package algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import custom.TreeNode;

/**
 * BST_Iterator
 */
// 94 Binary Tree Inorder Traversal

//古城模板　－　理解记忆
//step 1. 一路向左push进stack
//step 2. pop()出node
//step ３. 处理该node
//step 4. node = node.right

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root!= null || !stack.isEmpty()) {
            while (root != null) {                  // step 1
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();                     // step 2
            result.add(root.val);                   // 处理
            root = root.right;                      // step 4
        }
        return result;
    }
}


// 173. Binary Search Tree Iterator
// 古城模板的分解
// 补充两点认识：
// 1.　从一个节点开始可以call next()到BST的末尾的条件是 : stack里记录从根节点到这个点的node路径中比这个node大的node
// 2.  next()调用平均时间复杂度是O(1), 参考leetcode讨论，https://leetcode.cn/problems/binary-search-tree-iterator/solution/er-cha-sou-suo-shu-die-dai-qi-by-leetcod-4y0y/　这也是272题是Ｏ(nlogn + k) 的时间复杂度的前提

class BSTIterator {
    Deque<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        if (stack.isEmpty()) {
            return -1;
        }
        TreeNode node = stack.pop();
        int val = node.val;
        node = node.right;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        
        return val;
        
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

//653. Two Sum IV - Input is a BST
//１.这道题可以用BFS/DFS加MAP做
//２.用双指针和iterator做和用BFS/DFS加MAP做时间复杂度和空间复杂度是一样的

// class Solution {
//     public boolean findTarget(TreeNode root, int k) {
//         TreeNode left = root, right = root;
//         Deque<TreeNode> leftStack = new ArrayDeque<>();
//         Deque<TreeNode> rightStack = new ArrayDeque<>();
        
//         leftStack.push(left);
//         while (left.left != null) {
//             leftStack.push(left.left);
//             left = left.left;            
//         }
        
//         rightStack.push(right);
//         while(right.right != null) {
//             rightStack.push(right.right);
//             right = right.right;
//         }
        
//         while (left != right) {
//             if (left.val + right.val == k) {
//                 return true;
//             }
//             if (left.val + right.val > k) {
//                 right = getPre(rightStack);
//             } else {
//                 left = getNext(leftStack);
//             }
//         }
//         return false;
        
//     }
//     private TreeNode getNext(Deque<TreeNode> stack) {
//         TreeNode node = stack.pop();
//         TreeNode right = node.right;
//         while (right != null) {
//             stack.push(right);
//             right = right.left;        
//         }        
//         return node;
//     }
//     private TreeNode getPre(Deque <TreeNode> stack) {
//         TreeNode node = stack.pop();
//         TreeNode left = node.left;
//         while (left!= null) {
//             stack.push(left);
//             left = left.right;
//         }
//         return node;
//     }
// }

// 272. Closest Binary Search Tree Value II
// 1. 在blananced BST前提下，找到target最接近的两个node时间复杂度是O(logn) 
// 2. getNext(), getPre()和binary tree iterator的方法一样是O(1)操作
// 3. 总的时间复杂度O(logn + k)
// class Solution {
//     public List<Integer> closestKValues(TreeNode root, double target, int k) {
//         List<Integer> result = new ArrayList<>();
//         if (root == null || k == 0) {
//             return result;
//         }
        
//         Deque<TreeNode> leftStack = new ArrayDeque<>();
//         Deque<TreeNode> rightStack = new ArrayDeque<>();
        
//         TreeNode node = root;
//         while (node != null) {
//             if (node.val > target) {
//                 rightStack.push(node);
//                 node = node.left;
//             } else {
//                 leftStack.push(node);
//                 node = node.right;
//             }
//         }
        
//         for (int i = 0; i < k; i++) {
//             if (leftStack.isEmpty() || 
//                 !rightStack.isEmpty() && target - leftStack.peek().val > rightStack.peek().val - target) {
//                 result.add(getNext(rightStack).val);
//             } else {
//                 result.add(getPre(leftStack).val);
//             }            
//         }
        
//         return result;
//     }
//     private TreeNode getNext(Deque<TreeNode> stack) {
//         TreeNode node = stack.pop();
//         TreeNode right = node.right;
//         while (right != null) {
//             stack.push(right);
//             right = right.left;
//         }       
        
//         return node;
//     }
        
//     private TreeNode getPre(Deque<TreeNode> stack) {
//         TreeNode node = stack.pop();
//         TreeNode left = node.left;
//         while (left != null) {
//             stack.push(left);
//             left = left.right;
//         }       
        
//         return node;
//     }
// }
