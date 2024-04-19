package LAB9;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
	 Node root;

	    // Constructor for creating a new empty BST
	    BinarySearchTree() {
	        root = null;
	    }

	    // Insert a new key into the BST
	    void insert(int key) {
	        root = insertRec(root, key);
	    }

	    // Recursive insert utility function
	    Node insertRec(Node root, int key) {
	        if (root == null) {
	            root = new Node(key);
	            return root;
	        }
	        if (key < root.key)
	            root.left = insertRec(root.left, key);
	        else if (key > root.key)
	            root.right = insertRec(root.right, key);
	        return root;
	    }

	    // Calculate the maximum depth of the BST
	    int maxDepth(Node node) {
	        if (node == null)
	            return 0;
	        else {
	            int leftDepth = maxDepth(node.left);
	            int rightDepth = maxDepth(node.right);
	            return (Math.max(leftDepth, rightDepth) + 1);
	        }
	    }

	    // Calculate the size of the BST recursively
	    int size(Node node) {
	        if (node == null)
	            return 0;
	        else
	            return (size(node.left) + 1 + size(node.right));
	    }

	    // Calculate the size of the BST iteratively
	    int iterativeSize() {
	        if (root == null)
	            return 0;

	        Queue<Node> queue = new LinkedList<>();
	        queue.add(root);

	        int count = 0;
	        while (!queue.isEmpty()) {
	            Node node = queue.poll();
	            count++;
	            if (node.left != null)
	                queue.add(node.left);
	            if (node.right != null)
	                queue.add(node.right);
	        }
	        return count;
	    }

	    // In-order traversal
	    void inOrder(Node node) {
	        if (node != null) {
	            inOrder(node.left);
	            System.out.print(node.key + " ");
	            inOrder(node.right);
	        }
	    }

	    // Pre-order traversal
	    void preOrder(Node node) {
	        if (node != null) {
	            System.out.print(node.key + " ");
	            preOrder(node.left);
	            preOrder(node.right);
	        }
	    }

	    // Post-order traversal
	    void postOrder(Node node) {
	        if (node != null) {
	            postOrder(node.left);
	            postOrder(node.right);
	            System.out.print(node.key + " ");
	        }
	    }

	    // Driver method
	    public static void main(String[] args) {
	        BinarySearchTree bst = new BinarySearchTree();

	        // Inserting nodes into the BST
	        int[] keys = {25, 15, 50, 10, 22, 35, 70, 4, 12, 18, 24, 31, 44, 66, 90};
	        for (int key : keys) {
	            bst.insert(key);
	        }

	        // Display the maximum depth of the BST
	        System.out.println("Maximum depth of the BST is: " + bst.maxDepth(bst.root));

	        // Display the size of the BST (recursive and iterative)
	        System.out.println("Size of the BST (recursively): " + bst.size(bst.root));
	        System.out.println("Size of the BST (iteratively): " + bst.iterativeSize());

	        // Perform and display the in-order traversal of the BST
	        System.out.print("In-order traversal: ");
	        bst.inOrder(bst.root);
	        System.out.println();

	        // Perform and display the pre-order traversal of the BST
	        System.out.print("Pre-order traversal: ");
	        bst.preOrder(bst.root);
	        System.out.println();

	        // Perform and display the post-order traversal of the BST
	        System.out.print("Post-order traversal: ");
	        bst.postOrder(bst.root);
	        System.out.println();
	    }
	}

