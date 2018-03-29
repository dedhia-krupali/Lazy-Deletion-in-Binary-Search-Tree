/* Name: Krupali dedhia
 * Class: CS 3345
 * Section: 003
 * Professor: Anjum Chida
 */

/* 
 * This class implements a Binary Search Tree with 
 * lazy deletion.
 */

public class LazyBinarySearchTree
{
	/*
	 * TreeNode class 
	 * and structure with various variables
	 */
    private class TreeNode
    {
    		int element;
    		boolean isDeleted;
        TreeNode left;
        TreeNode right;
    		
        TreeNode(int e) {
    			element = e;
    			isDeleted = false;
    			left = null;
    			right = null;
    		}
        
        
    }
    
    // class variables
    private TreeNode root;
    private int nodesCounter = 0;
    private int deletedCounter = 0;
    
    // default constructor
    public LazyBinarySearchTree()
    {
        root = null;
    }
    
    // parameterized constructor
    public LazyBinarySearchTree(TreeNode node)
    {
        root = node;
    }
    
    // public function to insert a variable in the BST
    public boolean insert(int element) throws IllegalArgumentException {
    	 
    	// throws an exception is element is not with in given range
    	if(element<1 || element>99)
        {
           throw new IllegalArgumentException("IllegalArgumentException raised");
        }
    	
        TreeNode z = new TreeNode(element);
        if (root == null) {
            root = z;
            return true;
        }
        
        TreeNode parent = null, x = root;
        while (x != null) {
            parent = x;
            
            if(x.element > element) {
            		x = x.left;
            		
            } else { 
            		x = x.right;
            }

        }
        
        if (element < parent.element) {
        		parent.left  = z;
        		return true;
        } else if(element > parent.element) {
        		parent.right = z;
        		return true;
        }
        
        return false;
    }
    
   
    // public function for lazy deletion of element from BST
    public boolean delete(int element)throws IllegalArgumentException
    {
    	// throws an exception is element is not with in given range
        if(element<1 || element>99)
        {
           throw new IllegalArgumentException("IllegalArgumentException raised");
        }
        
        // check if tree is null
        if(root == null)
        {
           return false;
        }
        
        
        TreeNode node = root;
        while(node != null)
        {
        	// lazy deletion
            if(node.element == element)
            {
                if(node.isDeleted == false)
                {
                	   node.isDeleted = true;
                	   deletedCounter++;
                   return true;
                }
                else
                {
                    return false;
                }
           }
           else if(node.element < element)
           {
                node = node.right;
           }
           else if(node.element > element)
           {
                node = node.left;
           }
        }
        return false;
    }
    
   // finds minimum element in the BST
    public int findMin() {
		if(isEmpty()) {
			System.out.print("The Tree is Empty! :(");
		}
		return findMin(root).element;
	}
   
    // finds maximum element in the BST
    public int findMax() {
		if(isEmpty()) {
			System.out.print("The tree is empty! :(");
		}
		return findMax(root).element;
	}
    
    // private TreeNode method to find the minimum from BST
    private TreeNode findMin(TreeNode node){
		if(node == null) {
			return null;
		} else if(leftSubTree(node)) {
			return findMin(node.left);
		} else if(!node.isDeleted) {
			return node;
		} else if(rightSubTree(node)) {
			return findMin(node.right);
		} 
		return null;
	}
	
    // private TreeNode method to find the maximum from BST
	private TreeNode findMax(TreeNode node) {
		if(node == null) {
			return null;
		} else if(rightSubTree(node)) {
			return findMax(node.right);
		} else if(!node.isDeleted) {
			return node;
		} else if(leftSubTree(node)) {
			return findMax(node.left);
		}
		return null;
	}
	
	// check if left sub tree exists
	private boolean leftSubTree(TreeNode node) {
		boolean exists = false;
		
		if(node == null) {
			exists = false;
		} 
		if(node.left != null) {
			if(!node.left.isDeleted) {
				exists = true;
			} else if(leftSubTree(node.left) ||rightSubTree(node.left)){
				exists = true;
			} else {
				exists = false;
			}
		}
		return exists;
	}
	
	// check if right sub tree exists
	private boolean rightSubTree(TreeNode node) {
		boolean exists = false;
		
		if(node == null) {
			exists = false;
		} 
		if(node.right != null) {
			if(!node.right.isDeleted) {
				exists = true;
			} else if(rightSubTree(node.right) || leftSubTree(node.right)){
				exists = true;
			} else {
				exists = false;
			}
		}
		return exists;
	}

    public boolean contains(int element)throws IllegalArgumentException
    {
    	// throws an exception is element is not with in given range
        if(element < 1 || element >99)
        {
            throw new IllegalArgumentException("IllegalArgumentException raised");
        }
        
        //return false is the tree is empty
        if(root == null)
        {
            return false;
        }
        TreeNode node = root;
        
        //iterate through the BST
        while(node != null)
        {
            if(element == node.element)
            {
                if (node.isDeleted == false)
                    return true;
                else
                   return false;
            }
            else if(element < node.element)
               node = node.left;
            else if(element > node.element)
               node =node.right;
        }
        return false;
      }
    
    // public function that returns the height of the BST
    public int height() {
		return height(root);
	}
    
    // public function that returns the size of the BST
	public int size() {
		return size(root);
	}
	
	// check if the BST is empty
	public boolean isEmpty() {
		return deletedCounter == nodesCounter;
	}
	
	// public function to print the BST in preOrderTraveral
	public String toString()  {
		return toString(root);
	}
	
	// Prints the BST in preOrder Traversal
	private String toString(TreeNode node) {
		if(node == null) {
			return "";
		}
		String str1 = "";
		String str2 = "";
		String str = "";
		
			if(!node.isDeleted) {
				str = str + node.element + " ";
			} else{
				str = str + "*" + node.element + " ";
			}
			str1 = toString(node.left);
			str2 = toString(node.right);
		return str + str1 + str2;
	}
	
	// finds the height of the BST
	private int height(TreeNode node) {
		if(node == null) {
			return -1;
		} 
		int leftHeight = height(node.left);
		int rightHeight = height(node.right);
		
		if(leftHeight > rightHeight) {
			return leftHeight + 1;
		} else {
			return rightHeight + 1;
		}
	}
	
	// finds the size of the BST
	private int size(TreeNode node) {
		if(node == null) {
			return 0;
		} else {
			return size(node.left) + size(node.right) + 1;
		}
	}

}