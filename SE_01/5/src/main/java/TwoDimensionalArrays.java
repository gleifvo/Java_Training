import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoDimensionalArrays {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int matrixSize = Integer.parseInt(br.readLine());

		int[][] matrix = new int[matrixSize][matrixSize];

		fillingMatrix(matrix);

		printMatrix(matrix);
	}

	public static void printMatrix(int[][] matrix) {
		for (int[] array : matrix) {
			for (int element : array) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
	}

	public static void fillingMatrix(int[][] matrix) {

		int numberFirstUnit = 0;

		int numberSecondUnit = matrix.length - 1;

		for (int[] array : matrix) {

			array[numberFirstUnit] = 1;

			array[numberSecondUnit] = 1;

			numberFirstUnit++;

			numberSecondUnit--;
		}
	}

}
