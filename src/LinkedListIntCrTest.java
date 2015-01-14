// TODO CR: Dodaj slicno organizovan test za DynamicListArray


public class LinkedListIntCrTest {

	public static void main(String[] args) {
		// testing middle value
		testMiddleValue();
		
		// testing remove duplicates
		testRemoveDuplicates();
	}
	
	private static void testRemoveDuplicates() {
		LinkedListInt list = new LinkedListInt();
		for (int i=1; i <= 10; i++) {
			list.add(i);
			list.add(i);
		}
		
		if (10 != list.getSize()) {
			throw new InternalError("Size should be 10 after duplicates are removed!");
		}
		
		// TODO CR: Add check to see if there are any duplicates, by comparing each element in list
		
		System.out.println("Test testRemoveDuplicates() ... OK");
	}
	
	private static void testMiddleValue() {
		LinkedListInt list = new LinkedListInt();
		for (int i=2; i <= 100; i++) {
			list.add(i);
		}
		
		if (51 != list.getMiddleValue()) {
			throw new InternalError("Wrong middle value!");
		}
		
		System.out.println("Test testMiddleValue() ... OK");
	}

}
