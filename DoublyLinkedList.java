// The start of the DoublyLinkedList class, discussed
// in the 230 text
// Currently "implements List" is commented out because otherwise,
// this does not compile because most of the List methods
// are not yet implemented
public class DoublyLinkedList<E> /* implements List<E> */{
	
	private Link<E> head;
	private Link<E> tail;
	private Link<E> curr;
	private int listSize; 

	// Initialize an empty list
	public DoublyLinkedList() {
		head = new Link<E>(null, null,null);
		tail = new Link<E>(null, head, null);
		head.setNext(tail);
		curr = tail;
		listSize = 0;
	}
	/**
	 * this method clears the list
	 * it makes the link go from the head to the tail
	 * it basically starts everything over 
	 */
	public void clear(){
	//set the 	
		listSize = 0;	
		head.setNext(tail);
		tail.setPrev(head);
		curr = tail;	

	
	}
	/**
	 * this method inserts a new link by making
	 * curr a new link that makes curr point to new link
	 * and then setting the old curr to point to the new one and the old 
	 * next from curr point back to new curr
	 * @param it the object to insert
	 */
	public boolean insert(E it){
	
		curr = new Link<E>(it, curr.prev(), curr);
		curr.prev().setNext(curr);
		curr.next().setPrev(curr);
		listSize++;
		return true;
	}

	
	/**
	 * This method appends the element it 
	 * to the end of the list. It does so by
	 * making a new link linked to tail's prev and tail
	 * and making that link tail's prev link. To finish the 
	 * last link it sets tail's old prev to point to the appended Link
	 * @param it generic object
	 * @return true for some reason
	 */
	public boolean append(E it){
		//set the tail to point to a new element
		tail.setPrev(new Link<E>(it, tail.prev(), tail));
		tail.prev().prev().setNext(tail.prev());
		listSize++;
		return true;
	}
	/**
	 * This element removes and returns the current element
	 * it holds the element as local variable, links around the 
	 * removed variable and then returns the object at curr
	 * @return rtn the Object at index curr
	 */

	public E remove(){
		//don't want a null pointer
		if(curr == tail)
			return null;
		E rtn = curr.element();
		//make the previous node point two nodes ahead
		curr.prev().setNext(curr.next());
		//make the next node point two nodes behind
		curr.next().setPrev(curr.prev());
		//decrement the list size
		listSize--;
		//return object
		return rtn;
	
	}
	/**
	 * This method moves the curr pointer to the element
	 * right after the head node
	 *
	 */
	public void moveToStart(){
		//it doesn't matter if tail is curr it just reassigns
		curr = head.next();
	}
	/**
	 * This method moves the curr pointer to the tail
	 */
	public void moveToEnd(){
		//the curr is now just the tail, but that's fine because 
		//inserting/appending puts stuff before curr
		curr = tail;
	}
	/**
	 * This method makes curr the previous Link
	 */
	public void prev(){
		curr = curr.prev();
	}
	/**
	 * This method makes curr the next link
	 */
	public void next(){
		curr = curr.next();
	}
	/**
	 * This method returns listSize
	 * @return listSize the size of the list
	 */
	public int length(){
		return listSize;
	}

	/**
	 * This method returns the current position by walking from
	 * the current position down until it reaches the node that points
	 * to the head node
	 * @return rtn the current position
	 */
	public int currPost(){
		//if the curr is first element, while won't increment
		//thus giving the index 0, the first element
		int rtn = 0;
		Link<E> currCopy = curr;
		while(currCopy.prev() != head){
			currCopy = currCopy.prev();
			rtn++;
		}
		return rtn;

	}
	/**
	 * This method moves the curr to whatever index is passed in
	 * It does this by walking up the list pos +1 times
	 * because it starts at head node which isn't a real node
	 * @param pos the index of the List
	 * @return true because why not
	 */

	public boolean moveToPos(int pos){
		//start at beginning, walk to position and call curr that
		Link<E> walker = head;
		//the for loop walks the list "pos" times
		for (int i = 0; i<= pos; i++){
			walker = walker.next();
		}
		//curr now references the posth index of the list
		curr = walker;
		return true;
	}
	/**
	 * This method returns whether it's at the end
	 * If you're reading this, sound off in the comments
	 */
	public boolean isAtEnd() {
		
		return curr == tail;

	}
 	/**
	 * This method returns the Object stored in curr
	 * @return E the object at curr
	 */
	public E getValue(){
		
		return curr.element();
	}
	/**
	 * This method returns the truth value of
	 * whether the list is empty
	 */
	public boolean isEmpty(){
		//unless someone really tinkers with this or I messed up
		//head pointing to tail and tail pointing to head are
		//necessary and sufficient events
		return head.next() == tail;
	}

	// return a String representation of list, starting at head working
	// toward tail
	public String toString() {
		Link<E> temp = head.next();
		String out = "";
		while (temp != tail) {
			out += temp.element() + ((temp.next() != tail) ? ", " : "");
			temp = temp.next();
		}
		return out;
	  }
  
	public static void main(String[] args) {
		
		
		
	}
}
