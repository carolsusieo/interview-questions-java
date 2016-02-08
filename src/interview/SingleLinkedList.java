package interview;

import java.util.concurrent.ThreadLocalRandom;


/** Single Linked Lists
 * 
 * @author carolsusieo
 *
 */

public class SingleLinkedList {

	private int lsize;
	public LinkList<Integer> list;
	public void main(String[] args) {
          list = new LinkList<Integer>();
          // eclipse configuration set up to send parameter
	      int N  = Integer.parseInt(args[0]);
	      lsize = N;
	      // add elements 1, ..., N
 	      System.out.println(N + " random integers between 0 and 99");
	      for (int i = 1; i <= N; i++)
	    	  list.insert(ThreadLocalRandom.current().nextInt(0, 99 + 1));

          list.printList();

          while(!list.isEmpty()) {
        	  	int deleteValue = list.getFirstItem();
                list.delete();
                lsize--;
                System.out.print("deleted: " + deleteValue);
                  System.out.println("");
          }
          list.printList();
	}
	SingleLinkedList(int num)
	{
          list = new LinkList<Integer>();
	      lsize = num;
	      // add elements 1, ... lsize
	      for (int i = 0; i < lsize; i++)
	    	  list.insert(ThreadLocalRandom.current().nextInt(0, 99 + 1));
	}
	public void show(){
		list.printList();
	}
	public int size()
	{
		return lsize;
	}
	public int get(int i){
		return list.getItem(i);
	}

}

	
class LinkList <Item> {
	private Node first;
	
	//LinkList constructor
	public LinkList() {
	        first = null;
	}
	  // linked list node helper data type
	  private class Node {

	      private Item item;
	      public Node nextLink;
	  }
	  
	public boolean isEmpty()    { return first == null; }

	//Inserts a new Link at the first of the list
	public void insert(Item item) {
	        Node link = new Node();
	        link.item = item;
	        link.nextLink = first;
	        first = link;
	}
	
	//Deletes the link at the first of the list
	public Node delete() {
	        Node temp = first;
	        first = first.nextLink;
	        return temp;
	}
	public Item getFirstItem() {
		return first.item;
	}
	public Item getItem(int i) {
		
		Node currentLink = first;
		for (int j = 0; j < i && currentLink != null;j++)
			currentLink = currentLink.nextLink;
		if(currentLink == null)
			return null;
		return currentLink.item;
	}
	
	//Prints list data
	public void printList() {
	        Node currentLink = first;
	        System.out.print("List: ");
	        while(currentLink != null) {
	        	System.out.print(currentLink.item + " ");
	                currentLink = currentLink.nextLink;
	        }
	        System.out.println("");
	}
	
}

