import java.util.*;

class Atm{
    static int amount[] = {0,0,0,0};
    static int amountnum[] = {100,200,500,2000};
    static int Mukesh = 13000;
    static int Dharun = 15000;
    static void add_amount(){
        System.out.print("\033[H\033[2J");
        for(int i=0;i<4;i++){
            System.out.println("Enter number of "+amountnum[i]+" is ");
            amount[i]+=sc.nextInt();
            System.out.print("\033[H\033[2J");
        }
        System.out.println("Amount added Successfully");
        System.out.println();
        System.out.println("Please press enter for previous menu");
        try{
            System.in.read();
            adminfunc();
        }catch(Exception e){
        }
    }

    static void show_amount(){
        System.out.print("\033[H\033[2J");
        for(int i=0;i<4;i++){
            System.out.println("Number of notes in "+amountnum[i]+" is "+amount[i]);
        }
        System.out.println();
        System.out.println("Please press enter for previous menu");
        try{
            System.in.read();
            adminfunc();
        }catch(Exception e){
        }
    }

    static void withdraw_amount(){
        System.out.print("\033[H\033[2J");
        System.out.println("Enter the amount");
        int amt = sc.nextInt();
        Mukesh-=amt;
        System.out.println("Amount Withdraw Successfully");
        System.out.println();
        System.out.println("Please press enter for previous menu");
        try{
            System.in.read();
            userfunc();
        }catch(Exception e){
        }
    }

    static void show_balance(){
        System.out.print("\033[H\033[2J");
        System.out.println("Your account balance is "+Mukesh);
        System.out.println();
        System.out.println("Please press enter for previous menu");
        try{
            System.in.read();
            userfunc();
        }catch(Exception e){
        }
    }

    static void adminfunc(){
        System.out.print("\033[H\033[2J");
        System.out.println("1. Add Amount");
        System.out.println("2. Show Amount");
        System.out.println("3. Back");
        int ch1=sc.nextInt();
        switch(ch1){
            case 1:
                add_amount();
            break;
            case 2:
                show_amount();
            break;
            case 3:
                mainfunc();
            break;
            default:
                System.out.println("Invalid choice");
            break;
        }
    }

    static void userfunc(){
        System.out.print("\033[H\033[2J");
        System.out.println("1. Withdraw Amount");
        System.out.println("2. Account Balance");
        System.out.println("3. Back");
        int ch1=sc.nextInt();
        switch(ch1){
            case 1:
                withdraw_amount();
            break;
            case 2:
                show_balance();
            break;
            case 3:
                mainfunc();
            break;
            default:
                System.out.println("Invalid choice");
            break;
        }
    }

    static void adminlogin(){
        System.out.print("\033[H\033[2J");
        System.out.println("Enter Admin Id");
        sc.nextLine();
        String adminid = sc.nextLine();
        System.out.print("\033[H\033[2J");
        if(adminid.equals("Admin1")){
            System.out.println("Enter Password");
            String adminpass = sc.nextLine();
            if(adminpass.equals("12345")){
                adminfunc();
            }else{
                System.out.println("Invalid password");
            }
        }
        else{
            System.out.println("Invalid admin id");
        }
    }

    static void userlogin(){
        System.out.print("\033[H\033[2J");
        System.out.println("Enter Username");
        sc.nextLine();
        String username = sc.nextLine();
        System.out.print("\033[H\033[2J");
        if(username.equals("Mukesh")){
            System.out.println("Enter Password");
            String userpass = sc.nextLine();
            if(userpass.equals("12345")){
                userfunc();
            }else{
                System.out.println("Invalid password");
            }
        }
        else{
            System.out.println("Invalid Username");
        }
    }

    static void mainfunc(){
        System.out.print("\033[H\033[2J");
        int ch=0;
        System.out.println("ATM MACHINE");
        System.out.println("1. Admin Login");
        System.out.println("2. User Login");
        System.out.println("3. Exit");
        System.out.println("Enter your choice");
        ch = sc.nextInt();
        switch(ch){
            case 1:
                adminlogin();
            break;
            case 2:
                userlogin();
            break;
            case 3:
                System.exit(0);
            break;
            default:
                System.out.println("Invalid Input");
            break;
        }
    }

    private static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        mainfunc();
    }
}