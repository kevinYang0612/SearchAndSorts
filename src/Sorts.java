
import java.util.Arrays;


public class Sorts {
  public static void main(String[] theArgs) {
    int[] a = {56, 12, 43, 3, 98, 14, -17, 35};
      selectionSort(a);
//    bubbleSort(a);
//    insertionSort(a);
//    mergeSort(a);
//    quickIntSort(a, 0, a.length - 1);
// swap(a, 0, 6);
//xorSwap(a, 0, 6);
    System.out.println(Arrays.toString(a));
  }


  public static void swap(int[] theA, int theI1, int theI2) {
     int temp = theA[theI1];
     theA[theI1] = theA[theI2];
     theA[theI2] = temp;
  }
  


  public static void selectionSort(int [] theA) {
    for (int start = 0; start < theA.length; start++) {
      int min = start;
      for (int next = start + 1; next < theA.length; next++) {
        if (theA[next] < theA[min]) {
          min = next;
        }
      }
    swap(theA, start, min);
    }
  }


  public static void bubbleSort(int[] theA) { 
  	boolean swapped = true; 
  	int j = 0; 
  	int tmp; 
  	while (swapped) { 
  		swapped = false; 
  		for (int i = theA.length - 1; i > j; i--) { 
  			if (theA[i] < theA[i - 1]) { 
  				tmp = theA[i]; 
  				theA[i] = theA[i - 1]; 
  				theA[i - 1] = tmp; 
  				swapped = true; 
  			} 
  		}
  		j++; 
  	} 
  }


  public static void insertionSort(int[] theA) { 
  	int i, j, newValue; 
  	for (i = 1; i < theA.length; i++) { 
  		newValue = theA[i]; 
  		j = i; 
  		while (j > 0 && theA[j - 1] > newValue) { 
  			theA[j] = theA[j - 1];   //  or swap(theA, j, j - 1);
  			j--; 
  		} 
  		theA[j] = newValue; 
  	} 
  }


  public static void mergeSort(int[] theA)
  {
    if (theA.length >= 2)
    {
      // split array into two halves
      int[] theLeft  = Arrays.copyOfRange(theA, 0, theA.length / 2);
      int[] theRight = Arrays.copyOfRange(theA, theA.length / 2, theA.length);

      // sort the two halves
      mergeSort(theLeft);
      mergeSort(theRight);

      // merge the sorted halves into a sorted whole
      merge(theA, theLeft, theRight);
    }
  }


  public static void merge(int[] theResult, int[] theLeft, 
                           int[] theRight)
  {
    int i1 = 0;   // index into left array
    int i2 = 0;   // index into right array

    for (int i = 0; i < theResult.length; i++)
    {
      if (i2 >= theRight.length ||
          (i1 < theLeft.length && theLeft[i1] <= theRight[i2]))
      {
        theResult[i] = theLeft[i1];    // take from left
        i1++;
      } else {
         theResult[i] = theRight[i2];   // take from right
         i2++;
      }
    }
  }
  

	private final static void quickIntSort(int[] theA, int theLeft, int theRight){
		int i = theLeft;
		int j = theRight;
		int swap = 0;
		int test = theA[(theLeft + theRight) / 2];
		do {
			while (theA[i] < test) i++;
			while (theA[j] > test) j--;
			if (i <= j){
				swap = theA[i];
				theA[i] = theA[j];
				theA[j] = swap;
				i++;
				j--;
			}
		} while (i <= j);
		if (theLeft < j)
			quickIntSort(theA, theLeft, j);
		if (i < theRight)
			quickIntSort(theA, i, theRight);
	}
}
    