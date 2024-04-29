import java.util.*;
class ATM{
    int balance ;
    int pin = 7568; // lets assume retrieved from database
    int transactions=0;
    String transactionsHistory="";
    Scanner input=new Scanner(System.in);
    public void pinNumber(){
        System.out.print("Enter your pin: ");
        int pinNum=input.nextInt();
        if(pin == pinNum){
            System.out.println("Hello Customer");
            menu();
        }
        else{
            System.out.print("Enter valid PIN Number");
        }
    }

    public void deposit(){
        System.out.print("Enter amount to be deposited: ");
        float amount=input.nextFloat();
        balance+=amount;
        transactions++;
        System.out.println("Amount Deposited Successfully");
        String str=amount+" Deposited \n";
        transactionsHistory=transactionsHistory+str;
        menu();
    }

    public void withdraw(){
        System.out.print("Enter amount to be Withdrawn: ");
        float amount=input.nextFloat();
        if(balance>=amount){
            balance-=amount;
            transactions++;
            System.out.println("Amount withdrawn Successfully");
            String str=amount+" Withdrawn \n";
            transactionsHistory=transactionsHistory+str;
        }
        else{
            System.out.print("Insufficient Balance");
        }
        menu();
    }

    public void totalBalance(){
        System.out.println("Total Balance: "+ balance);
        menu();
    } 

    public void transfer(){
        System.out.print("Enter Receipent's Name: ");
        String personName=input.next();
        System.out.print("Enter amount to be transfered: ");
        float amount=input.nextFloat();
        if(balance>=amount){
            if(100000f>=amount){
                balance-=amount;
                transactions++;
                System.out.println("Amount has been Successfully Transferred to "+personName);
                String str=amount+" transfered to "+personName+" \n";
                transactionsHistory=transactionsHistory+str;
            }
            else{
                System.out.print("Limit Excceded! can only transfer amount upto 100000");
            }
        }
        else{
            System.out.print("Insufficient Balance");
        }
        menu();
    }

    public void transactionHistory(){
        if(transactions==0){
            System.out.println("No transactions done");
        }
        else{
            System.out.println(transactionsHistory);
        }
        menu();
    }

    public void menu(){
        System.out.println(" 1.Deposit \n 2.Withdraw \n 3.Balance \n 4.Transfer \n 5.Transaction History \n 6.Exit");
        System.out.print("Enter your choice: ");
        int c=input.nextInt();
            switch(c){
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    totalBalance();
                    break; 
                case 4:
                    transfer();
                    break;           
                case 5:
                    transactionHistory();
                    break;      
                case 6:
                    return;
                default:
                    System.out.print("Enter valid choice");
                    break;                    
            }
        }
    }
public class AtmInterface{

    public static void main(String args[]){
        System.out.println("\n******WELCOME TO SBI ATM SYSTEM******\n");
        ATM obj = new ATM();
        obj.pinNumber();
    }
}
