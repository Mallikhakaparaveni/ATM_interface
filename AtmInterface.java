import java.util.*;
class BankAccount{

    String name;
    String userName;
    String passWord;
    String accountNum;
    float balance=50000f;
    int transactions=0;
    String transactionsHistory="";

    public void register(){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter your Name: ");
        this.name=input.next();
        System.out.print("Enter username: ");
        this.userName=input.next();
        System.out.print("Enter password: ");
        this.passWord=input.next();
        System.out.print("Enter Account Number: ");
        this.accountNum=input.next();
        System.out.println("Registration Completed! Try Login.");
    }

    public boolean login(){
        Scanner input=new Scanner(System.in);
        boolean isRegistered=false;
        while(!isRegistered){
            System.out.print("Enter username: ");
            String username=input.next();
            if(userName.equals(username)){
                while(!isRegistered){
                    System.out.print("Enter password: ");
                    String password=input.next();
                    if(passWord.equals(password)){
                        System.out.print("Login Successful!");
                        isRegistered=true;
                    }
                    else{
                        System.out.println("Incorrect password");
                    }
                }
            }
            else{
                System.out.println("username not found");
            }
        }
        return isRegistered;
    }

    public void deposit(){
        System.out.print("Enter amount to be deposited: ");
        Scanner input=new Scanner(System.in);
        float amount=input.nextFloat();
        try{
            if(amount<=50000f){
                balance+=amount;
                transactions++;
                String str=amount+" is deposited to "+accountNum+" \n";
                transactionsHistory=transactionsHistory+str;
            }
        }
        catch(Exception e){
        }
    }

    public void withdraw(){
        System.out.print("Enter amount to be Withdrawn: ");
        Scanner input=new Scanner(System.in);
        float amount=input.nextFloat();
        try{
            if(balance>=amount){
                balance-=amount;
                transactions++;
                String str=amount+" is withdrawn from "+accountNum+" \n";
                transactionsHistory=transactionsHistory+str;
            }
            else{
                System.out.print("Insufficient balance");
            }
        }
        catch(Exception e){
        }
    }

    public void totalBalance(){
        System.out.println("Total Balance: "+ balance);
    } 

    public void transfer(){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter Receipent's Name: ");
        String personName=input.next();
        System.out.print("Enter amount to be transfered: ");
        float amount=input.nextFloat();
        try{
            if(balance>=amount){
                if(50000f>=amount){
                    balance-=amount;
                    transactions++;
                    System.out.println("Amount has been Successfully Transferred to "+personName);
                    String str=amount+" transfered to "+personName+" \n";
                    transactionsHistory=transactionsHistory+str;
                }
                else{
                    System.out.print("Limit Excceded! can only transfer amount upto 50000");
                }
            }
            else{
                System.out.print("Insufficient Balance");
            }
        }
        catch(Exception e){
        }
    }

    public void transactionHistory(){
        if(transactions==0){
            System.out.println("No transactions done");
        }
        else{
            System.out.println(transactionsHistory);
        }
    }
}
public class AtmInterface{
    public static int value(int num){
        int val=0;
        boolean flag=false;
        while(!flag){
            try{
                Scanner input=new Scanner(System.in);
                val=input.nextInt();
                flag=true;
                if(flag && val>num || val<1){
                     System.out.println("select a number between 1 to "+val);
                     flag=false;
                }
            }
            catch(Exception e){
                System.out.println("Enter a number");
                flag= false;
            }
        };
        return val;
    }
    public static void main(String args[]){
        System.out.println("\n******WELCOME TO SBI ATM SYSTEM******\n");
        System.out.println(" 1.Register \n 2.Exit");
        System.out.print("Enter your choice: ");
        int choice=value(2);
        if(choice==1){
            BankAccount b=new BankAccount();
            b.register();
            while(true){
                System.out.println(" 1.Login \n 2.Exit");
                System.out.print("Enter your choice: ");
                int c=value(2);
                if(c==1){
                    if(b.login()){
                        System.out.println("\n******WELCOME "+b.name+" ******\n");
                        boolean flag1=false;
                        while(!flag1){
                            System.out.println(" 1.Deposit \n 2.Withdraw \n 3.Balance \n 4.Transfer \n 5.Transaction History \n 6.Exit");
                            System.out.println("Enter your choice: ");
                            int ch=value(6);
                            switch(ch){
                                case 1:
                                    b.deposit();
                                    break;
                                case 2:
                                    b.withdraw();
                                    break;
                                case 3:
                                    b.totalBalance();
                                    break; 
                                case 4:
                                    b.transfer();
                                    break;           
                                case 5:
                                    b.transactionHistory();
                                    break;      
                                case 6:
                                    flag1=true;
                                    break;                    
                            }
                        }
                    }
                }
                else{
                    return;
                }
            }
        }
        else{
            return;
        }
    }
}