// Lista integera
public class LinkedListInt {
	Node head;
	private int size;

	public int getSize() {
		return size;
	}

	public LinkedListInt() {
		this.head = null;
		this.size = 0;
	}

	/**
	 * Izbacivanje duplikata iz liste
	 */
	public void removeDuplicate() {

		Node current = head;
		Node test = head.next;
		int counter1 = 0;
		int counter2 = 1;
		while (current.next != null) {
			while (test != null) {
				if (current.value == test.value) {
					removeAt(counter2);
					removeAt(counter1);
					return;
				}
				test = test.next;
				counter2++;
			}

			current = current.next;
			counter1++;
		}
	}

	/**
	 * Izbacivanje duplikata uz pomoc nizova
	 * 
	 * @param array
	 *            Niz u kojem se trazi duplikat
	 */
	public void removeDuplicateArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] == array[j]) {
					removeAt(i);
					removeAt(j - 1);
				}

			}
		}
	}

	/**
	 * Metoda koja dodaje prvi node.
	 * 
	 * @param value
	 */
	public void add(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
			size++;
			return;
		}
		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = newNode;
		size++;
	}

	/**
	 * Ispisuje listu
	 */
	public void printList() {
		Node current = head;
		while (current != null) {
			System.out.println(current.value);
			current = current.next;
		}

	}

	/**
	 * Izbacuje vrijednost iz liste
	 * 
	 * @param index
	 *            Mjesto vrijednosti koja se brise
	 */
	public void removeAt(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index nije ispravan!");
		}

		if (head.next == null) {
			head = null;
			size--;
			return;
		}

		if (index == 0) {
			head = head.next;
			size--;
			return;
		}

		Node current = head.next;
		Node previous = head;
		int counter = 1;
		while (counter < index) {
			current = current.next;
			previous = previous.next;
			counter++;
		}
		previous.next = current.next;
		current.next = null;

	}

	/**
	 * Dodavanje vrijednosti na listu
	 * 
	 * @param value
	 *            vrijednost koja s dodaje
	 * @param index
	 *            Mjesto gdje se dodaje vrijednost
	 */
	public void add(int value, int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index nije ispravan!");
		}
		Node newNode = new Node(value);
		if (index == 0) {
			newNode.next = head;
			head = newNode;
			size--;
			return;
		}

		if (index == size) {
			add(value);
			return;
		}

		Node current = head.next;
		Node pevious = head;
		int counter = 1;
		while (counter < index) {
			current = current.next;
			counter++;
		}

		newNode.next = current.next;
		current.next = newNode;
		size++;
	}

	/**
	 * Pretvaranje liste u niz
	 * 
	 * @return Niz sa vrijednostima clanova liste
	 */
	public int[] toArray() {
		int[] array = new int[size];
		Node current = head;
		for (int i = 0; i < size; i++) {
			array[i] = current.value;
			current = current.next;
		}
		return array;

	}

	/**
	 * Dodavanje iste na listu
	 * 
	 * @param other
	 *            Lista koja se dodaje
	 */
	public void add(LinkedListInt other) {
		if (head == null) {
			this.head = other.head;
			return;
		}
		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = other.head;
		this.size += other.size;
	}

	/**
	 * Pretrazuje niz i trazi proslijedjenu vrijednost
	 * 
	 * @param value
	 *            Proslijedjena vrijednost
	 * @return Vraca true/false u zavisnosti da li proslijedjena vrijednost se
	 *         nalazi u nizu
	 */

	public boolean contains(int value) {
		Node find = head;
		while (find != null) {
			if (find.value == value) {
				return true;
			}
			find = find.next;
		}
		return false;
	}

	/**
	 * Ispisuje vrijednost srednjeg clana liste
	 */
	public void getMiddleValue() {
		Node first = head;
		Node second = head;
		while (second.next != null) {

			second = second.next;
			if (second.next == null) {
				System.out.println(first.value);
				return;
			}

			second = second.next;
			first = first.next;
		}
		System.out.println(first.value);
	}

	class Node {
		public int value;
		public Node next;

		public Node(int value) {
			this.value = value;

		}

		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}

	}
}
