//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;
public class Main {
    public static void main(String[] args) {
        int n;
        int m;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of elements in first array \n");
        n=in.nextInt();
        System.out.print(n+ "\n");
        int[] a = new int[n];
        System.out.println("Enter the element of first unsorted array \n");
        for(int i = 0;i<n;i++){
            a[i] = in.nextInt();
        }
        System.out.print(Arrays.toString(a));
        System.out.println("\n Enter the number of elements in second array \n");
        m=in.nextInt();
        System.out.print(m);
        int[] b =new int[m];
        System.out.println("\n Enter the element of first unsorted array \n");
        for(int i = 0;i<m;i++){
            b[i] = in.nextInt();
        }
        System.out.println(Arrays.toString(b) +"\n");
        int c = n+m;
        int[] d =new int[c];
        System.arraycopy(a, 0, d, 0, n);
        System.arraycopy(b, 0, d, n, m);
        System.out.print(Arrays.toString(d));

        for(int i=0;i<c;i++){
            for(int j=i+1;j<c;j++){
                if(d[i]>d[j]){
                    int temp = d[i];
                    d[i]=d[j];
                    d[j]=temp;
                }
            }
        }
        System.out.print("\n" +Arrays.toString(d));
    }
}
