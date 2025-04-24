import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;
class BullsAndCows
{
    public static void main(String args[])
    {
        int i,j,bull=0,cow=0;
        int[] secretDigit,arr;
        Scanner scan=new Scanner(System.in);
        String msg, ans, playNextGame;
        secretDigit=new int[4];
        arr=new int[4];
        Random rand=new Random();
        Pattern regex=Pattern.compile("^\\d{4}$|^quit$");
        do
        {
                String secret="";
                playNextGame="";
                for(i=0;i<4;i++){
                secretDigit[i]=rand.nextInt(10);
                secret+=secretDigit[i];
        }
        System.out.println("A secret number of 4-digit has been draw!");
        do
        {
            do
            {
                System.out.print("Please enter a 4-digit number (or type 'quit' to exit):");
                ans=scan.nextLine().trim();
                System.out.println(ans);
            }
            while(!regex.matcher(ans).find());
            if(ans.equals("quit"))
            {
                System.out.println("The secret number is: " + secret);
            }
            else
            {
                cow=0;
                bull=0;
                for(i=0;i<4;i++)
                try
                {
                    arr[i]=Integer.parseInt(ans.substring(i,i+1));
                    if(arr[i]==secretDigit[i]) bull++;
                }
                catch(NumberFormatException nfe)
                {} 
                for(i=0;i<4;i++)
                for(j=0;j<4;j++)
                if(arr[j]==secretDigit[i])
                {
                    cow++;
                    arr[j]=-1;
                    break;
                }
                cow-=bull;
                msg="";
                if(cow==0 && bull==0)
                {
                    msg="Neither a bull nor a cow!";
                }
                else
                {
                    if(bull==4)
                    msg="4 bulls! You are a genius!";
                    else
                    {
                        if(cow==0)
                        {
                            if(bull==1)
                            msg="1 bull only.";
                            else
                            msg=bull + " bulls only.";
                        }
                        else if(bull==0)
                        {
                            if(cow==1)
                            msg="1 cow only.";
                            else
                            msg=cow + " cows only.";
                        }
                        else
                        {
                            if(bull==1)
                            msg="1 bull and ";
                            else
                            msg=bull + " bulls and ";
                            if(cow==1)
                            msg+="1 cow.";
                            else
                            msg+=cow + " cows.";
                        }
                    }
                }
                System.out.println(msg);
            }
        }
        while(bull!=4 && !ans.equals("quit"));
        if(!ans.equals("quit")){
            do
            {
                System.out.print("Do you want to play a new game (Y/N)?");
                playNextGame=scan.nextLine().trim();
                System.out.println(playNextGame);
            }
            while(!playNextGame.toUpperCase().equals("Y") && !playNextGame.toUpperCase().equals("N"));
        }
    }
    while (playNextGame.toUpperCase().equals("Y") && !ans.equals("quit"));
    System.out.println("Thank you for playing Bulls and Cows!");
}
}