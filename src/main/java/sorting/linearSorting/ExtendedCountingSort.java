package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		if (array != null && leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length
				&& array.length != 0) {

			int max = array[leftIndex];
			int min = array[leftIndex];

			Integer[] arrayCopia = Arrays.copyOf(array, array.length);

			for (int i = leftIndex; i <= rightIndex; i++) {

				if (array[i] >= max) {
					max = array[i];
				} else if (array[i] <= min) {
					min = array[i];
				}
			}
			
			int tamanho = max - min + 1;

		
			Integer[] arrayC = new Integer[tamanho];

			for (int i = 0; i < tamanho; i++) {
				arrayC[i] = 0;
			}

			for (int j = leftIndex; j <= rightIndex; j++) {
				arrayC[array[j] - min] = arrayC[array[j] - min] + 1;
			}

			for (int i = 1; i < tamanho; i++) {
				arrayC[i] = arrayC[i] + arrayC[i - 1];
			}

			for (int j = rightIndex; j >= leftIndex; j--) {
				
				array[arrayC[arrayCopia[j] - min] - 1 + leftIndex] = arrayCopia[j];
				arrayC[arrayCopia[j] - min] = arrayC[arrayCopia[j] - min] - 1;
			}

		}
	}
}
