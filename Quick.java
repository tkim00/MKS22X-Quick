import java.util.*;

public class Quick {
  public static void main(String[] args) {
    int[] data = {999,999,999,4,1,0,3,2,999,999,999};
    //int[] data = {2, 10, 15, 23, 0,  5};
    System.out.println(partition(data, 1, data.length-1));
    for (int i = 0; i < data.length; i++) {
      System.out.print("" + data[i] + " ");
    }
    System.out.println(" ");
    System.out.println(quickselect(data, 4));
    for (int i = 0; i < data.length; i++) {
      System.out.print("" + data[i] + " ");
    }
  }

  public static int partition(int[] data, int start, int end) {
    Random rand = new Random();
    int k = rand.nextInt(data.length);
    //System.out.println(data[k]);
    int storage = start-1;
    int j = data[storage];
    data[storage] = data[k];
    data[k] = j;
    while (start != end) {
      int n = 0;
      if (data[storage] < data[start]) {
        n = data[start]; //swap the target number with the end
        data[start] = data[end];
        data[end] = n;
        end--;
      } else if (data[storage] == data[start]) {
        if (rand.nextInt(100) < 50) {
          start++;
        } else {
          n = data[start]; //swap the target number with the end
          data[start] = data[end];
          data[end] = n;
          end--;
        }
      } else {
        start++;
      }
    }
    int n = data[storage];
    if (data[storage] <= data[start]) {
      data[storage] = data[start-1];
      data[start-1] = n;
      start--;
    } else {
      data[storage] = data[start];
      data[start] = n;
    }
    return start;
  }

  public static int quickselect(int []data, int k){
    int lo = 1;
    int hi = data.length - 1;
    int pivot = partition(data, lo, hi);
    while (pivot != k) {
      //System.out.println(pivot);
      if (pivot > k) {
        hi = pivot - 1;
      }
      if (pivot < k) {
        lo = pivot + 1;
      }
      pivot = partition(data, lo+1, hi);
    }
    return pivot;
  }
}
