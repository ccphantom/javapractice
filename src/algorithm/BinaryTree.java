package algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import custom.TreeNode;

public class BinaryTree {
    // 古城模板 － 理解记忆
    // step 1. 一路向左push进stack
    // step 2. pop()出node
    // step ３. 处理该node
    // step 4. node = node.right
    public List<Integer> inordertraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

}
