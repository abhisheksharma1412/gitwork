import java.util.Scanner;
public class AtmInterface
{
    float balance;
    int PIN=1412
    public void checkPin(){
        System.out.println("----Welcome To My ATM------");
        System.out.print("Enter the pin:-");
        Scanner sc=new Scanner(System.in);
        int enterpin=sc.nextInt();
        if(enterpin==PIN){
            menu();
        }
        else{
            System.out.println("Enter a valid pin");
           checkPin();
        }
    }

    public void menu(){
        System.out.println("Enter your choice:-");
        System.out.println("1- Check A/C Balance");
        System.out.println("2- Withdraw Money");
        System.out.println("3- Deposite Money");
        System.out.println("4- Exit");

        Scanner sc=new Scanner(System.in);
        int opt=sc.nextInt();

        if(opt==1){
            checkBalance();
        }
        else if(opt==2){
            withDrawlMoney();
        }
        else if(opt==3){
            depositeMoney();
        }
        else if(opt==4){
            System.out.println("-----Have a Nice Day-----");
            return;
        }
        else{
            System.out.println("Enter a valid choice");
            menu();
        }

    }

    public void checkBalance(){
        System.out.println("Your current balance:-"+ balance);
        menu();
    }

    public void withDrawlMoney(){
        System.out.print("Enter amount to be withdraw:-");
        Scanner sc=new Scanner(System.in);
        double amt=sc.nextDouble();

        if(amt>balance){
            System.out.println("XXXX--Insufficient Balance--XXXX");
        }
        else{
            balance-=amt;
            System.out.println("-----Money Withdrawl Successfully-----");
        }
        menu();
    }

    public void depositeMoney(){
        System.out.println("Enter a amount");
        Scanner sc=new Scanner(System.in);
        double amt=sc.nextDouble();
        balance+=amt;
        System.out.println("-----Money Is Deposited Successfully-----");
    menu();
    }
    public static void main(String[] args) {
        AtmInterface atm=new AtmInterface();
        atm.checkPin();
    }
}