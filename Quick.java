import java.util.*;

public class Quick {
  public static void main(String[] args) {
    int[] data = {999,999,999,4,1,0,3,2,999,999,999};
    System.out.println(partition(data, 1, data.length-1));
    for (int i = 0; i < data.length; i++) {
      System.out.print("" + data[i] + " ");
    }
  }

  public static int partition(int[] data, int start, int end) {
    Random rand = new Random();
    int k = rand.nextInt(data.length);
    //System.out.println(data[k]);
    int j = data[0];
    data[0] = data[k];
    data[k] = j;
    while (start != end) {
      int n = 0;
      if (data[0] < data[start]) {
        n = data[start]; //swap the target number with the end
        data[start] = data[end];
        data[end] = n;
        end--;
      } else if (data[0] == data[start]) {
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
    int n = data[0];
    if (data[0] <= data[start]) {
      data[0] = data[start-1];
      data[start-1] = n;
      start--;
    } else {
      data[0] = data[start];
      data[start] = n;
    }
    return start;
  }

  public static int quickselect(int []data, int k){
    while (partition(data, 1, data.length-1) != k) {
      
    }
  }
}
