package interview;
/**
 * General interface for trees.
 * Copyright (c) 2006
 * Dept. of Computer Science, University College London
 * @author Graham Roberts
 * @version 2.0 01-Mar-06
 */

import java.util.*;

/**
 *  A simple generic binary tree class to demonstrate the basic principles
 *  of implementing a tree data structure. This should not be taken as a production
 *  quality class (see the text book instead).
 *  Copyright (c) 2006
 *  Dept. of Computer Science, University College London
 *  @author Graham Roberts
 *  @version 2.0 01-Mar-06
 */

import java.util.Stack;
import java.util.Iterator;

public class BinaryTree {
	static int lsize;
	static private BinTree<Integer> bt;
	static private BinTree<Integer> empty ;
	static private BinTree<Integer> one ;
	static private SingleLinkedList slist;
	
	public static void main(String[] args) {
		// SingleLinkedList is integers
		empty = new BinTree<Integer>() ;
	    one = new BinTree<Integer>() ;
	    one.add(0) ;
	    bt = new BinTree<Integer>();
		lsize = 20;
		slist = new SingleLinkedList(lsize);
		slist.show();
		populateBinTree(slist);
		System.out.print("List:");
		printInOrder(bt);
		System.out.println("");
		/*
		Implement the following functions for a binary tree:
		Insert
		PrintInOrder
		PrintPreOrder
		PrintPostOrder
		Implement a non-recursive PrintInOrder
		*/
		
		
	    System.out.println("testEmptyContainsZeroItems:");
		testEmptyContainsZeroItems();
		System.out.println("testOneContainsOneItem:");
		testOneContainsOneItem();
		setup();
		System.out.println("bt ContainsListItems:");
		testSeveralContainsListItems();
		System.out.println("does not Contain:");
		testSeveralDoesNotContain();
		System.out.println("remove from empty:");
		testRemoveFromEmpty();
		System.out.println("remove from one:");
		testRemoveFromOne();
		System.out.println("remove by leaf:");
		testRemoveByLeaf();
		setup();
		System.out.println("remove by root:");
		testRemoveByRoot();
		System.out.println("remove duplicates:");

		testDuplicates();
	}
	static void setup()
	{
		cleanUp();
		lsize = 6;
		bt.add(5) ;
	    bt.add(2) ;
	    bt.add(1) ;
	    bt.add(9) ;
	    bt.add(8) ;
	    bt.add(10) ;
	}
	static void cleanUp()
	{
		for(int i = 0; i < lsize && slist.get(i) > 0; i++)
			bt.remove(slist.get(i));
	}

	static private void printInOrder(BinTree<Integer>tree){
	    Iterator<Integer> iterator = tree.iterator() ;
	    while (iterator.next() != null)
	    {
	    	System.out.print(iterator.next().intValue() + ",");
	    }

	}
	static private void populateBinTree(SingleLinkedList theList) {
	    for(int i = 0;i < lsize;i++) {
	        bt.add(theList.get(i));
	    }
	}
	static public void testEmptyContainsZeroItems()
	  {
	    assertTreeEmpty(empty);
	  }

	  static public void testOneContainsOneItem()
	  {
	    assertTrue("One should contain 0",one.contains(0)) ;
	    assertIterationValid(one,new int[]{0});
	  }

	  static public void testSeveralContainsListItems()
	  {
	    assertContains(bt,new int[]{1,2,5,8,9,10});
	    assertIterationValid(bt,new int[]{1,2,5,8,9,10});
	  }

	  static public void testSeveralDoesNotContain()
	  {
		  
	    assertDoesNotContain(bt,new int[]{-1,3,7,13}) ;
	  }

	  static public void testRemoveFromEmpty()
	  {
	    empty.remove(0);
	    assertTreeEmpty(empty);
	  }
	  static public void testRemoveFromOne()
	  {
	    one.remove(0) ;
	    assertTrue("0 not removed from one",!one.contains(0)) ;
	    assertTreeEmpty(one);
	  }

	  static public void testRemoveByLeaf()
	  {
	    assertRemoveAll(bt,new int[]{5,2,1,8,10,9,5});
	  }

	  static public void testRemoveByRoot()
	  {
	    assertRemoveAll(bt,new int[]{5,8,9,10,2,1});
	  }

	  static public void testDuplicates()
	  {
	    empty.add(1) ;
	    empty.add(1) ;
	    empty.add(1) ;
	    assertIterationValid(empty,new int[] {1,1,1});
	    assertTrue("Should contain 1",empty.contains(1)) ;
	    empty.remove(1) ;
	    assertTrue("Should still contain 1",empty.contains(1)) ;
	    assertIterationValid(empty,new int[] {1,1});
	    empty.remove(1) ;
	    assertTrue("Should still contain 1",empty.contains(1)) ;
	    assertIterationValid(empty,new int[] {1});
	    empty.remove(1) ;
	    assertTrue("Should not contain 1",!empty.contains(1)) ;
	    assertTreeEmpty(empty);
	  }

	  static private void assertTreeEmpty(BinTree<Integer> tree)
	  {
	    Iterator<Integer> iterator = tree.iterator() ;
	    assertTrue("Tree not empty",!iterator.hasNext()) ;
	  }

	  static private void assertRemoveAll(BinTree<Integer> tree, int[] elements)
	  {
	    for (int i = 0 ; i < elements.length ; i++)
	    {
	      tree.remove(elements[i]);
	      assertFalse(elements[i] + " Still in tree after being removed",
	                 tree.contains(elements[i])) ;
	    }
	    assertTreeEmpty(tree);
	  }
	  static private void assertContains(BinTree<Integer> tree, int[] elements)
	  {
	    for (int i = 0 ; i < elements.length ; i++)
	    {
	      assertTrue(elements[i] + " not in tree",
	                 tree.contains(elements[i])) ;
	    }
	  }

	  static private void assertDoesNotContain(BinTree<Integer> tree, int[] elements)
	  {
	    for (int i = 0 ; i < elements.length ; i++)
	    {
	      assertFalse(elements[i] + " unexpectedly found in tree",
	                  tree.contains(elements[i])) ;
	    }
	  }

	  static private void assertIterationValid(BinTree<Integer> tree, int[] elements)
	  {
	    Iterator<Integer> iterator = tree.iterator() ;
	    for (int i = 0 ; i < elements.length ; i++)
	    {
	      assertEquals(elements[i] + " missing from tree",
	                   new Integer(elements[i]),iterator.next()) ;
	    }
	    assertFalse("Not reached end of iteration",iterator.hasNext());
	  }
	  static private void assertTrue(String in1, boolean in2){
	  
		  if(!in2)
			  System.out.println(in1);
	  }
	  static private void assertFalse(String in1, boolean in2){
		  if(in2)
			  System.out.println(in1);
	  }
	  static private void assertEquals(String in1, int in2, int in3){
		  if(in2 != in3)
			  System.out.println(in1);
		  
	  }
	  
}

/**
 * Objects stored in a tree must conform to Comparable so that their values can
 * be compared. The type parameter is constained to conform to Comparable to
 * enforce this.
 */
class BinTree<E extends Comparable<E>>
{
  /**
   * A tree is a hierarchical structure of TreeNode objects. root references
   * the first node on the tree.
   */
  private TreeNode<E> root;

  public interface Tree<E>
  {
    /**
     * Store an object in the tree. The object must conform to type Comparable
     * in order to be inserted in the correct location. Multiple objects representing the
     * same value can be added.
     *
     * @param obj reference to Comparable object to add.
     */
    void add(E obj);

    /**
     * Determine whether the tree contains an object with the same value as the
     * argument.
     *
     * @param obj reference to Comparable object whose value will be searched for.
     * @return true if the value is found.
     */
    boolean contains(E obj);

    /**
     * Remove an object with a matching value from the tree. If multiple
     * matches are possible, only the first matching object is removed.
     *
     * @param obj Remove an object with a matching value from the tree.
     */
    void remove(E obj);

    /**
     * Return a new tree iterator object.
     *
     * @return new iterator object.
     */
    Iterator<E> iterator();
  }
  
  /**
   *  Helper class used to implement tree nodes. As this is a private helper
   *  class it is acceptable to have public instance variables. Instances of
   *  this class are never made available to client code of the tree.
   */
  private static class TreeNode<T extends Comparable<T>>
  {
    /**
     *  Data object reference.
     */
    public T val;

    /**
     *  Left and right child nodes.
     */
    public TreeNode<T> left,right;
    /**
     *  Constructor for TreeNode.
     *
     *@param  val    data object reference
     *@param  left   left child node reference or null
     *@param  right  right child node reference or null
     */
    public TreeNode(T val, TreeNode<T> left, TreeNode<T> right)
    {
      this.val = val;
      this.left = left;
      this.right = right;
    }

    /**
     * Insert an object into the tree.
     *
     * @param obj object to insert into tree.
     */
    public void insert(T obj)
    {
      if (val.compareTo(obj) < 0)
      {
        if (right != null)
        {
          right.insert(obj) ;
        }
        else
        {
          right = new TreeNode<T>(obj,null,null) ;
        }
      }
      else
      {
        if (left != null)
        {
          left.insert(obj) ;
        }
        else
        {
          left = new TreeNode<T>(obj,null,null) ;
        }
      }
    }

    /**
     * Find an object in the tree. Objects are compared using the compareTo method, so
     * must conform to type Comparable.
     * Two objects are equal if they represent the same value.
     *
     * @param obj Object representing value to find in tree.
     * @return  reference to matching node or null.
     */
    public TreeNode<T> find(T obj)
    {
      int temp = val.compareTo(obj) ;
      if (temp == 0)
      {
        return this ;
      }
      if (temp < 0)
      {
        return (right == null) ? null : right.find(obj) ;
      }
      return (left == null) ? null : left.find(obj) ;
    }

    /**
     * Remove the node referencing an object representing the same value as the argument object.
     * This recursive method essentially restructures the tree as necessary and returns a
     * reference to the new root. The algorithm is straightforward apart from the case
     * where the node to be removed has two children. In that case the left-most leaf node
     * of the right child is moved up the tree to replace the removed node. Hand work some
     * examples to see how this works.
     *
     * @param obj Object representing value to remove from tree.
     * @param t Root node of the sub-tree currently being examined (possibly null).
     * @return reference to the (possibly new) root node of the sub-tree being examined or
     * null if no node.
     */
    private TreeNode<T> remove(T obj, TreeNode<T> t)
    {
      if (t == null)
      {
        return t;
      }
      if (obj.compareTo(t.val) < 0)
      {
        t.left = remove(obj,t.left);
      }
      else
      if (obj.compareTo(t.val) > 0 )
      {
        t.right = remove(obj, t.right);
      }
      else
      if (t.left != null && t.right != null)
      {
        t.val = findMin(t.right).val;
        t.right = remove(t.val,t.right);
      }
      else
      {
        t = (t.left != null) ? t.left : t.right;
      }
      return t;
    }

    /**
     * Helper method to find the left most leaf node in a sub-tree.
     *
     * @param t TreeNode to be examined.
     * @return reference to left most leaf node or null.
     */
    private TreeNode<T> findMin(TreeNode<T> t)
    {
      if(t == null)
      {
        return null;
      }
      else
      if(t.left == null)
      {
        return t;
      }
      return findMin(t.left);
    }
  }

  /**
   * Construct an empty tree.
   */
  public BinTree()
  {
    root = null ;
  }

  /**
   * Store an object in the tree. The object must conform to type Comparable
   * in order to be inserted in the correct location. Multiple objects representing the
   * same value can be added.
   *
   * @param obj reference to Comparable object to add.
   */
  public void add(E obj)
  {
    if (root == null)
    {
      root = new TreeNode<E>(obj,null,null) ;
    }
    else
    {
      root.insert(obj) ;
    }
  }
  /**
   * Determine whether the tree contains an object with the same value as the
   * argument.
   *
   * @param obj reference to Comparable object whose value will be searched for.
   * @return true if the value is found.
   */
  public boolean contains(E obj)
  {
    if (root == null)
    {
      return false ;
    }
    else
    {
      return (root.find(obj) != null) ;
    }
  }

  /**
   * Remove an object with a matching value from the tree. If multiple
   * matches are possible, only the first matching object is removed.
   *
   * @param obj Remove an object with a matching value from the tree.
   */
  public void remove(E obj)
  {
    if (root != null)
    {
      root = root.remove(obj,root) ;
    }
  }

  /**
   * Simple pre-order iterator class. An iterator object will sequence through
   * the tree contents in ascending order.
   * A stack is used to keep track of where the iteration has reached in the tree.
   * Note that if new items are added or removed during an iteration, there is no
   * guarantee that the iteration will continue correctly.
   */
  // todo seems some of the nodes at the ends aren't printed...
  
  private class PreOrderIterator implements Iterator<E>
  {
    private Stack<TreeNode<E>> nodes = new Stack<TreeNode<E>>() ;

    public PreOrderIterator()
    {
      pushLeft(root) ;
    }
    /**
     * Get next obnject in sequence.
     *
     * @return next object in sequence or null if the end of the sequence has
     * been reached.
     */
    public E next()
    {
      if (nodes.isEmpty())
      {
        return null ;
      }
      TreeNode<E> node = nodes.pop() ;
      pushLeft(node.right) ;
      return node.val ;
    }

    public boolean hasNext()
    {
      return !nodes.isEmpty() ;
    }

    /**
     * The remove operation is not supported by this iterator. This illustrates
     * that a method required by an implemented interface can be written to not
     * support the operation but should throw an exception if called.
     * UnsupportedOperationException is a subclass of RuntimeException and is
     * not required to be caught at runtime, so the remove method does not
     * have a throws declaration. Calling methods do not have to use a try/catch
     * block pair.
     *
     * @throws UnsupportedOperationException if method is called.
     */
    public void remove()
    {
      throw new UnsupportedOperationException();
    }

    private void pushLeft(TreeNode<E> node)
    {
      while (node != null)
      {
        nodes.push(node) ;
        node = node.left ;
      }
    }
  }

  public Iterator<E> iterator()
  {
    return new PreOrderIterator() ;
  }
}
    
