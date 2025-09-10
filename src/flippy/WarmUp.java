package flippy;

import java.util.Arrays;

public class WarmUp {

	/**
	 * Counts how many cards are hearts
	 * 
	 * @param cards an array of cards
	 * @return the number of cards that are hearts
	 */
	public static int countHearts(Card[] cards) {
		// TODO: fill in the method!
		int count = 0;
		for (int i = 0; i < cards.length; i++) {
			if (cards[i].getSuit().equals("hearts")) {
				count++;
			}
		}
		return count;
	}

	/**
	 * Add the elements of two arrays of the same length. The function assumes that
	 * the arrays are of the same length
	 * 
	 * @param array1
	 * @param array2
	 * @return a new array that is the element-wise sum of the input arrays
	 */
	public static double[] addArraysSameLength(double[] array1, double[] array2) {
		// TODO: fill in the method!
		double[] sums = new double[array1.length];
		for (int i = 0; i < array1.length; i++) {
			sums[i] = array1[i] + array2[i];
		}

		return sums;
	}

	// TODO: write the reverseArray method, including method header and JavaDoc
	// comments
	public static void reverseArray(String[] words) {
		// runs through the first half of the array
		for (int i = 0; i < words.length / 2; i++) {
			// stores the value at index (length - 1 -i) aka. the mirrored index
			// to where the loop is at and swaps the two values
			String temp = words[words.length - i - 1];
			words[words.length - i - 1] = words[i];
			words[i] = temp;
		}
	}

	public static void main(String[] args) {

		String[] words = { "I", "love", "my", "CS", "classes", "!" };

		System.out.println("Before: " + Arrays.toString(words));
		reverseArray(words);
		System.out.println("After: " + Arrays.toString(words));

		double[] array1 = { 1, 2, 3, 4, 5 };
		double[] answer = addArraysSameLength(array1, array1);
		System.out.println(Arrays.toString(answer));

		Card[] cards = new Card[4];
		cards[0] = new Card(1, "clubs");
		cards[1] = new Card(1, "hearts");
		cards[2] = new Card(3, "hearts");
		cards[3] = new Card(2, "hearts");
		System.out.println(countHearts(cards));
	}
}
