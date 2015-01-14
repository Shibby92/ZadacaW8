public class SortedTest {
	// TODO CR: Harise, ako budes imao vremena probaj malo bolje organizovati ove test klase
	public static void main(String[] args) {
		
		SortedLinkedListInt list =new SortedLinkedListInt();
		list.add(1);
		list.add(2);
		list.add(4);
		list.add(5);
		list.printList();
		System.out.println("--------------------------------");
		list.add(3);
		list.printList();
		System.out.println("--------------------------------");
	}
}
