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
    System.out.println(quickselect(data, 3));
    for (int i = 0; i < data.length; i++) {
      System.out.print("" + data[i] + " ");
    }
  }

  public static int partition(int[] data, int start, int end) {
    Random rand = new Random();
    int k = rand.nextInt(end - start + 1) + start;
    //System.out.println(data[k]);
    int st = start + 1;
    int e = end;
    int j = data[start];
    data[start] = data[k];
    data[k] = j;
    while (st != e) {
      int n = 0;
      if (data[start] < data[st]) {
        n = data[st]; //swap the target number with the end
        data[st] = data[e];
        data[e] = n;
        e--;
      } else if (data[start] == data[st]) {
        if (rand.nextInt(100) < 50) {
          st++;
        } else {
          n = data[st]; //swap the target number with the end
          data[st] = data[e];
          data[e] = n;
          e--;
        }
      } else {
        st++;
      }
    }
    int n = data[start];
    if (data[start] <= data[st]) {
      data[start] = data[st-1];
      data[st-1] = n;
      st--;
    } else {
      data[start] = data[st];
      data[st] = n;
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
      pivot = partition(data, lo+1, hi);
    }
    return pivot;
  }
}
