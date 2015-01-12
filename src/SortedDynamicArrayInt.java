/**
 * Klasa array lista za integere
 * 
 * 
 *
 */
public class SortedDynamicArrayInt {
	private int[] array;
	private int size;
	private final int DEFAULT_SIZE = 10;

	public SortedDynamicArrayInt() {
		this.array = new int[DEFAULT_SIZE];
		this.size = 0;
	}

	public int getSize() {
		return this.size;
	}

	/**
	 * Ispisivanje elemenata array liste
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			sb.append(String.valueOf(array[i]));
			if (i != size - 1) {
				sb.append(", ");
			}
		}
		return sb.toString();
	}

	/**
	 * Brisanje elementa iz array liste
	 * 
	 * @param indeks
	 *            Indeks elementa koji se brise
	 */
	public void remove(int indeks) {
		for (int i = indeks; i < size - 1; i++) {
			array[i] = array[i + 1];
		}
		size--;
	}

	/**
	 * Dodavanje elementa u array listu
	 * 
	 * @param value
	 *            Vrijednost koja se dodaje
	 */
	public void add(int value) {
		if (size == array.length) {
			resize();
		}
		array[size++] = value;
		insertionSort();
	}

	/**
	 * Ako je niz pun, udvostruci mu velicinu
	 */
	private void resize() {
		int[] tmp = new int[this.array.length * 2];
		for (int i = 0; i < this.array.length; i++) {
			tmp[i] = this.array[i];
		}
		this.array = tmp;
	}

	/**
	 * Dodaje element na specificni indeks niza
	 * 
	 * @param value
	 *            Vrijednost koja se ubacuje
	 * @param indeks
	 *            Mjesto gdje nastaje izmjena
	 */
	public void add(int value, int indeks) {
		int[] tmp = new int[size + 1];
		int count = 0;
		for (int i = 0; i < tmp.length; i++) {
			if (i == indeks) {
				tmp[i] = value;
			} else {
				tmp[i] = array[count];
				count++;
			}

		}
		array = tmp;
		size++;
		insertionSort();
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
		for (int i = 0; i < size; i++) {
			if (array[i] == value) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Sortira niz od najmanjeg ka najvecem
	 */
	public void insertionSort() {
		int temp;
		for (int i = 0; i < size; i++) {
			for (int j = 1; j < size; j++) {
				while (j > 0 && array[j] < array[j - 1]) {
					temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
					j--;
				}

			}
		}
	}
}
