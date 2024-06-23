import java.util.Scanner;
public class number_game{
    public static void start_game(){
        Scanner sc=new Scanner(System.in);
        int no_of_trails=5;
        int number=1+(int)(100*Math.random());
        int i;
        System.out.println("Start the game."+"You have only five Chances");
        for(i=0;i<no_of_trails;i++){
            System.out.println("Guess the number:");
            int guessed_number=sc.nextInt();
            if(number==guessed_number){
                System.out.println("Congratulations."+"You guessed the right number.");
                break;
            }
            else if(guessed_number<number && i!=no_of_trails-1){
                System.out.println("The number is greater than "+guessed_number);
            }
            else if(guessed_number>number && i!=no_of_trails-1){
                System.out.println("The number is less than "+guessed_number);
            }
        }
        if(i==no_of_trails){
            System.out.println("Sorry."+" "+"You have lost the game.");
            System.out.println("The number is "+number);
        }
    }
    public static void main(String[] args){
        start_game();
    }
}
