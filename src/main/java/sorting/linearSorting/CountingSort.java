package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		if (array != null && leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length
				&& array.length != 0) {

			int max = array[leftIndex];
			int min = array[leftIndex];
			int m = 1;
			Integer[] arrayCopia = Arrays.copyOf(array, array.length);

			for (int i = leftIndex; i <= rightIndex; i++) {
				if (array[i] >= max) {
					max = array[i];
				} else if (array[i] <= min) {
					min = array[i];
				}
			}
			if (min <= 0) {
				m = 0;
				max++;

			}

			Integer[] arrayC = new Integer[max];
			for (int i = 0; i < max; i++) {
				arrayC[i] = 0;
			}

			for (int j = leftIndex; j <= rightIndex; j++) {
				arrayC[array[j] - m] = arrayC[array[j] - m] + 1;
			}

			for (int i = 1; i < max; i++) {
				arrayC[i] = arrayC[i] + arrayC[i - 1];
			}

			for (int j = rightIndex; j >= leftIndex; j--) {
				array[arrayC[arrayCopia[j] - m] - 1 + leftIndex] = arrayCopia[j];
				arrayC[arrayCopia[j] - m] = arrayC[arrayCopia[j] - m] - 1;
			}

		}
	}
}
