import java.util.Scanner;

public class TwoDArray {
    public static void main(String[] args) {
        Scanner input;
        int twoD[][] = new int [4][5];
        int k=0,i,j;

        for(i=0;i<4;i++)
        for(j=0;j<5;j++){
            twoD[i][j]=k;
            k++;
        }
        for(i=0;i<4;i++){
            for(j=0;j<5;j++)
                System.out.println(twoD[i][j]+ "");
            System.out.println();
        }
    }
}
