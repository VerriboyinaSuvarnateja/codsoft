import java.util.Scanner;

public class task2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter number of subjects:");
        int n=sc.nextInt();
        int total=0;
        float average;
        int[] marks=new int[n];
        System.out.println("enter marks of subjects:");
        for(int i=0;i<n;i++){
            marks[i]=sc.nextInt();
            total=total+marks[i];
        }
        average=total/n;

        System.out.println("The total marks obtained are:"+total);
        System.out.println("The average percentage is:"+average);
        if(average>80){
            System.out.println("GRADE:A");
        }
        else if(average<=80 && average>70){
            System.out.println("GRADE:B");
        }
        else if(average<=70 && average>60){
            System.out.println("GRADE:C");
        }
        else if(average<=60 && average>50){
            System.out.println("GRADE:D");

        }
        else{
            System.out.println("GRADE:F");
        }
    }
}
