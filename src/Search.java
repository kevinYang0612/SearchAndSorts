public class Search
{
   public static void main(String[] theArgs)
   {
      int[] a = {-4, 2, 7, 10, 15, 20, 22, 25, 30, 36, 
                 42, 50, 56, 68, 85, 92, 103};
      
      System.out.println(binarySearch1(a, 42));
      int index = binarySearchRec(a, 42);
      int index2 = binarySearchRec(a, 66);
      System.out.println(index);
      System.out.println(index2);
   }
   public static int binarySearch1(int[] a, int target)
   {
      int min = 0;            // setting position
      int max = a.length - 1;
      while (min <= max)       // boundary condition
      {
         int mid = (min + max) / 2; // mid point index
         if (a[mid] < target)       // if mid point still small
         {
            min = mid + 1;   // reset min point index to previous mid point + 1
         }
         else if (a[mid] > target)  // if mid point too big
         {
            max = mid - 1;   // reset max point index to previous mid point - 1
         }
         else 
         {
            return mid;    // return the index of target
         }
      }
      return -(min + 1);            // target not found
   }
   public static int binarySearchRec(int[] a, int target)
   {
      return binarySearch(a, target, 0, a.length - 1);
                 // recursive passing in the array, number we look for
                 // the min index position, the max index position
   }
   private static int binarySearch(final int[] a, final int target, 
                                   final int min, final int max)
   {
      int result = -1;
      if (min > max)
      {
         result = -(min + 1);
      }
      else
      {
         int mid = (min + max) / 2;
         if (a[mid] < target)
         {
            result = binarySearch(a, target, mid + 1, max);
         }
         else if (a[mid] > target)
         {
            result = binarySearch(a, target, min, mid - 1);
         }
         else
         {
            result = mid;
         }
      }
      return result;
   }
   
}