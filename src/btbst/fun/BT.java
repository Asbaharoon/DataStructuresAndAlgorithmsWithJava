package btbst.fun;

import btbst.TreeNode;

import java.util.*;

// A simple Java program to introduce a linked list

public class BT {
    Scanner scanner = new Scanner(System.in);
    private TreeNode root = null;

    public void displayChoice() {
        System.out.println();
        System.out.println("====================Binary Tree Operations==================");
        System.out.println("-1: exit");
        System.out.println(" 0: create/insert ");
        System.out.println(" 1: inorder traversal ");
        System.out.println(" 2: preorder traversal ");
        System.out.println(" 3: postorder traversal ");
        System.out.println(" 4: get size");
        System.out.println(" 5: checkIfTwoTreesIdentical //not working");
        System.out.println(" 6: SGN identical");
        System.out.println(" 7: [new] insert/create");
        System.out.println(" 8: [new] inOrder");
        System.out.println(" 9: is the binary tree a BST");
        System.out.println("10: level order traversal");
        System.out.println("11: bottom view");
        System.out.println("12: is balanced?");
        System.out.println("13: createTreeFromArray");
        System.out.println("14: [TODO] levelWiseLLs");
        System.out.println("15: lowestCommonAncestor");
        System.out.println("16: [TODO]maxDiffBetweenANodeAndAncestor");
        System.out.println("17: [TODO]printPathsWithASumAsGivenValue");
        System.out.println("============================================================");
        System.out.println();
    }

    int size = 0;

    public boolean isBST(TreeNode node, Integer previous) throws Exception {
        if (node == null) {
            return true;
        }

        if (node != null) {
            isBST(node.getLeft(), previous);
            System.out.print(node.getKey() + "  ");
            if (previous == null) {
                previous = node.key;
            }
            if (previous > node.key) {
                System.out.println("not a bst");
                throw new Exception("not a bst");
            }
            previous = node.key;
            isBST(node.getRight(), previous);
        }

        return true;
    }

    public int inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.print(node.getKey() + "  ");
            size++;
            inOrder(node.getRight());
        }
        return size;
    }

    public void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.getKey() + "  ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(node.getKey() + "  ");
        }
    }

    public TreeNode insert(TreeNode root, int data) {

        if (root == null) {
            root = new TreeNode(data);
        } else {
            if (root.getLeft() == null) {
                // node.left = insert(node.left, data);
                // the above line is same as
                root.setLeft(insert(root.getLeft(), data));

            } else {
                // node.right = insert(node.right, data);
                // the above line is same as
                root.setRight(insert(root.getRight(), data));

            }
        }
        return root;

    }

    int treeSize = 0;

    public int getSize(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return getSize(root.getLeft()) + getSize(root.getRight()) + 1;
        }

    }

    /*
     * public void checkIfTwoTreesIdentical() { TreeNode root1 = new TreeNode();
     * TreeNode root2 = new TreeNode(); System.out.println("creating first tree..");
     * System.out.println("enter the number of nodes to be inserted"); int number =
     * scanner.nextInt(); for (int j = 0; j < number; j++) { root1 = insert(); }
     * System.out.println("creating second tree..");
     * System.out.println("enter the number of nodes to be inserted"); number =
     * scanner.nextInt(); for (int j = 0; j < number; j++) { root2 = insert(); }
     * boolean identical = checkIfTwoTreesIdentical(root1, root2);
     *
     * System.out.println("trees are identical :" + identical);
     *
     * }
     */
    private boolean checkIfTwoTreesIdentical(TreeNode root1, TreeNode root2) {
        if (root1 == root2) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return (root1.getKey() == root2.getKey() && checkIfTwoTreesIdentical(root1.getLeft(), root2.getLeft())
                && checkIfTwoTreesIdentical(root1.getRight(), root2.getRight()));

    }

    boolean identical;

    public boolean identical(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return true;
        if ((root1 == null && root2 != null) || (root1 != null && root2 == null))
            if (root1.getKey() != root2.getKey()) {
                return false;
            }
        identical(root1.getLeft(), root2.getLeft());
        identical(root1.getRight(), root2.getRight());
        return true;
    }

    public void newInOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        newInOrder(node.left);
        System.out.print(node.key + "  ");
        newInOrder(node.right);

    }

    public TreeNode newInsert() {
        TreeNode newRoot = null;
        System.out.println("enter the number of nodes ");
        for (int i = 0; i < scanner.nextInt(); i++) {
            System.out.println("enter a number");
            int number = scanner.nextInt();
            newRoot = newInsert(newRoot, number);
        }

        return newRoot;
    }

    private TreeNode newInsert(TreeNode newRoot, int number) {

        if (newRoot == null) {
            newRoot = new TreeNode(number);
        }
        if (newRoot.left == null) {
            newRoot.left = newInsert(newRoot.left, number);
        }
        if (newRoot.right == null) {
            newRoot.right = newInsert(newRoot.right, number);
        }
        return newRoot;
    }

    public void levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        int totalItemsPrinted = 1;
        int numberOfItemsPrintedInLastLevel = 1;
        int numberOfTabs = 8;

        System.out.print(level + ":  " + printNTabs(numberOfTabs));

        while (queue.size() != 0) {
            TreeNode node = queue.poll();
            if (node != null) {
                // uncomment below for printing only odd levels
                // if(level%2!=0){
                System.out.print(node.key + "\t");
                // }
                totalItemsPrinted++;
                if (totalItemsPrinted == numberOfItemsPrintedInLastLevel * 2) {
                    System.out.println("");
                    // for formatting after every level
                    System.out.print(++level + ":  " + printNTabs(--numberOfTabs));
                    numberOfItemsPrintedInLastLevel = totalItemsPrinted;
                }

                queue.add(node.left);
                queue.add(node.right);
            }
        }

    }

    private String printNTabs(int n) {

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append("\t");
        }
        return builder.toString();
    }

    public void bottomView(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if (root != null) {
            root.hd = 0;
            // optional step, hd =0 , default val of int
        }
        queue.add(root);
        Map<Integer, Integer> map = new HashMap<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            if (node != null) {
                map.put(node.hd, node.key);
                if (node.left != null) {
                    node.left.hd = node.hd - 1;
                    queue.add(node.left);
                }
                if (node.right != null) {
                    node.right.hd = node.hd + 1;

                    queue.add(node.right);
                }
            }
        }
        System.out.println(map);
        map.forEach((k, v) -> System.out.print(v + " "));

    }

	/*
     *
	 * 0 1 2 3 45 6
	 * 
	 * 
	 * 
	 * 
	 */

    public boolean isBalanced(TreeNode node) {
        if (node == null)
            return true;
        if (Math.abs(getHeight(node)) > 1)
            return false;
        else
            return true;

    }

    private int getHeight(TreeNode node) {
        // return height if balanced
        // return -1 if unbalanced
        if (root == null)
            return 0;
        int rightHeight = getHeight(node.right);
        int leftHeight = getHeight(node.left);

        if (rightHeight == -1)
            return -1;
        if (leftHeight == -1)
            return -1;

        int heightDiff = leftHeight - rightHeight + 1;
        if (Math.abs(heightDiff) > 1)
            return -1;
        else
            return Math.max(leftHeight, rightHeight) + 1;

    }

    public TreeNode createTreeFromArray(int[] a, int left, int right) {
        if (right < left) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(a[mid]);
        root.left = createTreeFromArray(a, 0, mid - 1);
        root.right = createTreeFromArray(a, mid + 1, right);
        return root;

    }

    public /*List<LinkedList<TreeNode>> */ void levelWiseLLs(TreeNode root, List<LinkedList<TreeNode>> list, int level) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() != 0) {
            int counter = queue.size();
            while (counter > 0) {
                counter--;
                TreeNode node = queue.poll();

                if (node != null) {
                    //counter--;
                    System.out.print(node.key + "\t");
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            System.out.println("");
        }
    }

    public void inOrderSuccessor(TreeNode root, int key) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {

        // assuming that both one and two exist in the tree
        if (root == null)
            return null;
        if (root == one || root == two)
            return root;
        boolean isOneOnLeft = contains(root.left, one);
        boolean isTwoOnLeft = contains(root.left, two);

        if (isOneOnLeft != isTwoOnLeft) {
            return root;
        }
        root = isOneOnLeft == true ? root.left : root.right;
        return lowestCommonAncestor(root, one, two);
    }

    private boolean contains(TreeNode root, TreeNode node) {
        if (node == null)
            return true;
        if (root == null)
            return false;
        if (root == node)
            return true;
        return contains(root.left, node) || contains(root.right, node);
    }

    public int maxDiffBetweenANodeAndAncestor(TreeNode root) {

        return Integer.MIN_VALUE;
    }

}
