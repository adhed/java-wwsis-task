import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AlgorithmsProvider {
	public static void main(String[] args) throws MyException {
		int[] numbers = readNumbers();
		int[] ascendingNumbers = sortAscending(numbers);
		int[] descendingNumbers = sortDescending(numbers);
		
		System.out.println("Posortowane rosnaco:");
		printNumbers(ascendingNumbers);
		
		System.out.println("\n Posortowane malejaco:");
		printNumbers(descendingNumbers);
	}
	
	public static int[] sortAscending(int[] array) {
		int[] arr = Arrays.copyOf(array, array.length);
		int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
		return arr;
	}
	
	public static int[] sortDescending(int[] array) {
		int[] arr = Arrays.copyOf(array, array.length);
		int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] <= arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
		return arr;
	}
	
	public static int[] readNumbers() throws MyException {
		int[] numbers = new int[5];
		Scanner input = new Scanner(System.in);
		
		System.out.println("Podaj 5 liczb które posortuje...");
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Podaj liczbe nr " + i + ": ");
			Integer number = parseNumber(input.nextLine());
			numbers[i] = number;
		}
		
		return numbers;
	}
	
	public static int parseNumber(String input) throws MyException {
		try {
			return Integer.parseInt(input);
		} catch(NumberFormatException  exc) {
			throw new MyException();
		}
		
	}
	
	public static void printNumbers(int[] numbers) {
		for (int number : numbers) {
			System.out.print(number + " ");
		}
	}
}