import java.util.*;

public class Quick {
  public static void main(String[] args) {
    int[] data = {999,999,999,4,1,0,3,2,999,999,999};
    //int[] data = {9, 5, 4, 2, 8, 7, 0, 1, 6, 3};
    int k = partition(data, 0, data.length-1);
    System.out.println(k);
    for (int i = 0; i < data.length; i++) {
      System.out.print("" + data[i] + " ");
    }
    // k = partition(data, 1, k-1);
    // System.out.println(k);
    // for (int i = 0; i < data.length; i++) {
    //   System.out.print("" + data[i] + " ");
    // }
    System.out.println(" ");
    System.out.println(quickselect(data, 4));
    for (int i = 0; i < data.length; i++) {
      System.out.print("" + data[i] + " ");
    }
  }

  private static void swap(int[] data, int a, int b) {
      int t = data[a];
      data[a] = data[b];
      data[b] = t;
  }

  public static int partition(int[] data, int start, int end) {
    Random rand = new Random();
    int k = rand.nextInt(end - start + 1) + start;
    int pivot = data[k];
    swap(data, k, start);
    int st = start + 1;
    int e = end;
    while (st < e) {
      if (pivot < data[st]) {
        swap(data, st, e);
        e--;
      } else if (pivot == data[st]) {
        if (rand.nextInt(100) < 50) {
          st++;
        } else {
          swap(data, st, e);
          e--;
        }
      } else {
        st++;
      }
    }
    //System.out.println(st);
    if (pivot > data[st]) {
      swap(data, start, st);
    } else {
      swap(data, start, st-1);
      st--;
    }
    return st;
  }

  public static int quickselect(int []data, int k){
    int lo = 0;
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
      pivot = partition(data, lo, hi);
    }
    return pivot;
  }

  public static void quicksort(int[] data) {

  }
}
