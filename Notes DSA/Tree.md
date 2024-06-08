# Trees


### [Lowest Common Ancestor of a Binary Search Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/) ⭐️⭐️

- if both p and q are bigger recurse of root.right
- if both p and q are smaller recurse of root.left
- else return root

### [Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/) ⭐️⭐️⭐️

- My approach was to find both p and q and return their parent stack and compare. Not efficient
- This approach is very hard to think :

``` java
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
    if(root == null || root.val == p.val || root.val == q.val) return root;

    TreeNode left =  lowestCommonAncestor(root.left,p,q);
    TreeNode right =  lowestCommonAncestor(root.right,p,q);
    
    if(left == null) return right ;
    if(right == null) return left;
    
    return root;
}
```

### [Binary Tree Right Side View](https://leetcode.com/problems/binary-tree-right-side-view/description/)

- Very similar to level order traversal


### [Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/)

- Do an in order traversal


### [Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/description/) ⭐️

- Similar to Diameter of Binary Tree
- In diameter every node has 1 weight, here it will node's value
- Be careful to handle negative weights

### [Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/) ⭐️⭐️

- Use pre order traversal


### [Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/) ⭐️⭐️⭐️

- Somehow I wrote whatever code came to my mind and it worked!!


### [Maximum Width of Binary Tree](https://leetcode.com/problems/maximum-width-of-binary-tree/description/) ⭐️⭐️

- Store the horizontal position in the node's value as we dont care about node's value
- Then do a level order traversal and find the width at each level
- if node's horizontal position is `i` then right child will be `2i` and left will be `2i-1`

<br><br>

## BST operations implementation 
- Construct : easy
- Insert : easy
- [Delete : TODO](https://leetcode.com/problems/delete-node-in-a-bst/description/)
- Find : easy
- [Successor / predecessor : TODO](https://leetcode.com/problems/inorder-successor-in-bst/description/)








