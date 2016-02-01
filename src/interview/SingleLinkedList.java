package interview;

import java.util.concurrent.ThreadLocalRandom;

/** Single Linked Lists
 * 
 * @author carolsusieo
 *
 */

public class SingleLinkedList {

	public static void main(String[] args) {
          LinkList list = new LinkList();
          // eclipse configuration set up to send parameter
	      int N  = Integer.parseInt(args[0]);

	      // add elements 1, ..., N
 	      System.out.println(N + " random integers between 0 and 99");
	      for (int i = 1; i <= N; i++)
	    	  list.insert(i,ThreadLocalRandom.current().nextInt(0, 99 + 1));

          list.printList();

          while(!list.isEmpty()) {
                  Link deletedLink = list.delete();
                  System.out.print("deleted: ");
                  deletedLink.printLink();
                  System.out.println("");
          }
          list.printList();
	}

}

//Singly Linked
class Link {
	public int data1;
	public double data2;
	public Link nextLink;
	
	//Link constructor
	public Link(int d1, double d2) {
	        data1 = d1;
	        data2 = d2;
	}
	
	//Print Link data
	public void printLink() {
	        System.out.print("{" + data1 + ", " + data2 + "} ");
	}
}
	
class LinkList {
	private Link first;
	
	//LinkList constructor
	public LinkList() {
	        first = null;
	}
	
	//Returns true if list is empty
	public boolean isEmpty() {
	        return first == null;
	}
	
	//Inserts a new Link at the first of the list
	public void insert(int d1, double d2) {
	        Link link = new Link(d1, d2);
	        link.nextLink = first;
	        first = link;
	}
	
	//Deletes the link at the first of the list
	public Link delete() {
	        Link temp = first;
	        first = first.nextLink;
	        return temp;
	}
	
	//Prints list data
	public void printList() {
	        Link currentLink = first;
	        System.out.print("List: ");
	        while(currentLink != null) {
	                currentLink.printLink();
	                currentLink = currentLink.nextLink;
	        }
	        System.out.println("");
	}
}


