import java.util.*;

import Library.Admin;

class Amazon {
    private static Scanner sc;
    static ArrayList<String> meruse = new ArrayList<>(Arrays.asList("m","1"));
    static ArrayList<String> meruse1 = new ArrayList<>(Arrays.asList("n","1"));
    static ArrayList<String> user1 = new ArrayList<>(Arrays.asList("u","1"));
    static ArrayList<String> pro1 = new ArrayList<>(Arrays.asList("m","Phone","Samsung","10","20000"));
    static ArrayList<String> pro2 = new ArrayList<>(Arrays.asList("m","Phone","Nokia","10","20000"));
    static ArrayList<String> pro3 = new ArrayList<>(Arrays.asList("n","Shoe","Puma","10","1500"));
    static ArrayList<String> pro4 = new ArrayList<>(Arrays.asList("n","Shoe","Adidas","10","1500"));
    static int y;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        mainfunc();
    }

    static void mainfunc(){
        int n;
        do{
            System.out.println("1. Admin");
            System.out.println("2. Merchant");
            System.out.println("3. User");
            System.out.println("4. Exit");
            n = sc.nextInt();
            for(int g=y;g<1;g++){
                Admin.mer.add(meruse);
                Admin.mer.add(meruse1);
                Admin.user.add(user1);
                Admin.prod.add(pro1);
                Admin.prod.add(pro2);
                Admin.prod.add(pro3);
                Admin.prod.add(pro4);
                y++;
            }
            sc.nextLine();
            switch(n){
                case 1:
                    System.out.println("Enter name");
                    String name = sc.nextLine();
                    System.out.println("Enter pass");
                    String pass = sc.nextLine();
                    if(Admin.admin.get(0).equals(name) && Admin.admin.get(1).equals(pass)){
                        Admin.output();
                    }
                    break;
                case 2:
                    Merchant.output();
                    break;
                case 3:
                    User.output();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }while(n!=4);
    }
}

class Admin{

    private static Scanner sc;
    static ArrayList<ArrayList<String>> appr = new ArrayList<>();
    static ArrayList<ArrayList<String>> mer = new ArrayList<>();
    static ArrayList<ArrayList<String>> prod = new ArrayList<>();
    static ArrayList<ArrayList<String>> user = new ArrayList<>();
    static ArrayList<ArrayList<String>> myorder = new ArrayList<>();
    static ArrayList<String> admin = new ArrayList<>(Arrays.asList("a","1"));
    static ArrayList<ArrayList<String>> cart = new ArrayList<>();
    static int wallet = 12000;
    static void output(){
        sc = new Scanner(System.in);
        System.out.println("1. Add Merchant");
        System.out.println("2. Approve Merchant");
        System.out.println("3. Remove Merchant");
        System.out.println("4. Back");
        int n = sc.nextInt();
        switch(n){
            case 1:
                addmerch();
                break;
            case 2:
                apprmerch();
                break;
            case 3:
                remomerch();
                break;
            case 4:
                Amazon.mainfunc();
                break;
        }
    }

    static void addmerch(){
        sc.nextLine();
        ArrayList<String> temp = new ArrayList<>();
        temp.clear();
        System.out.println("Enter name");
        String name = sc.nextLine();
        System.out.println("Enter pass");
        String pass = sc.nextLine();
        temp.add(name);
        temp.add(pass);
        appr.add(temp);
        // System.out.println(appr);
        System.out.println();
        System.out.println("Enter to continue");
        try{
            System.in.read();
            output();
        }catch (Exception e){
        }
    }

    static void apprmerch(){
        for(int i=0;i<appr.size();i++){
            System.out.println(appr.get(i).get(0));
            System.out.println("Do you want to approve?");
            sc.nextLine();
            String s = sc.nextLine();
            if(s.equals("y")){
                mer.add(appr.get(i));
            }
            appr.remove(i);
        }
        try{
            System.in.read();
            output();
        }catch (Exception e){
        }
    }

    static void remomerch(){
        sc.nextLine();
        System.out.println("Enter Merchant name");
        String s = sc.nextLine();
        for(int i=0;i<Admin.mer.size();i++){
            if(Admin.mer.get(i).get(0).equals(s)){
                Admin.mer.remove(i);
            }
        }
        try{
            System.in.read();
            output();
        }catch (Exception e){
        }
    }
}

class Merchant{
    private static Scanner sc;
    static void output(){
        sc = new Scanner(System.in);
        System.out.println("1. New Merchant");
        System.out.println("2. Existing Merchant");
        System.out.println("3. Back");
        int n = sc.nextInt();
        switch(n){
            case 1:
                newmer();
                break;
            case 2:
                exemer();
                break;
            case 3:
                Amazon.mainfunc();
                break;
        }
    }

    static void newmer(){
        ArrayList<String> temp = new ArrayList<>();
        temp.clear();
        sc.nextLine();
        System.out.println("Enter name");
        String name = sc.nextLine();
        System.out.println("Enter password");
        String pass = sc.nextLine();
        temp.add(name);
        temp.add(pass);
        Admin.appr.add(temp);
    }

    static void exemer(){
        sc.nextLine();
        System.out.println("Enter name");
        String name = sc.nextLine();
        System.out.println("Enter password");
        String pass = sc.nextLine();
        for(int i=0;i<Admin.mer.size();i++){
            if(Admin.mer.get(i).get(0).equals(name) && Admin.mer.get(i).get(1).equals(pass)){
                merview(name);
            }
        }
    }

    static void merview(String u){
        System.out.println("1. Add Product");
        System.out.println("2. Remove Product");
        System.out.println("3. Update Product");
        System.out.println("4. Product Preview");
        System.out.println("5. Product Compare");
        System.out.println("6. Back");
        int n = sc.nextInt();
        switch(n){
            case 1:
                addprod(u);
                break;
            case 2:
                remprod(u);
                break;
            case 3:
                updprod();
                break;
            case 4:
                proview(u);
                break;
            case 5:
                comp(u);
                break;
            case 6:
                output();
                break;
        }
    }

    static void addprod(String u){
        ArrayList<String> temp = new ArrayList<>();
        temp.clear();
        sc.nextLine();
        System.out.println("Enter Type");
        String n1 = sc.nextLine();
        System.out.println("Enter Brand");
        String n2 = sc.nextLine();
        System.out.println("Enter Quantity");
        String n3 = sc.nextLine();
        System.out.println("Enter Price");
        String n4 = sc.nextLine();
        temp.add(u);
        temp.add(n1);
        temp.add(n2);
        temp.add(n3);
        temp.add(n4);
        Admin.prod.add(temp);
    }

    static void remprod(String u){
        sc.nextLine();
        System.out.println("Enter Type");
        String n1 = sc.nextLine();
        System.out.println("Enter Brand");
        String n2 = sc.nextLine();
        for(int i=0;i<Admin.prod.size();i++){
            if(Admin.prod.get(i).get(1).equals(n1) && Admin.prod.get(i).get(2).equals(n2)){
                Admin.prod.remove(i); 
            }
        }
        try{
            System.in.read();
            merview(u);
        }catch (Exception e){
        }
    }

    static void updprod(){
        sc.nextLine();
        System.out.println("Enter Type");
        String n1 = sc.nextLine();
        System.out.println("Enter Brand");
        String n2 = sc.nextLine();
        System.out.println("Enter Quantity");
        String n3 = sc.nextLine();
        System.out.println("Enter Price");
        String n4 = sc.nextLine();
        for(int i=0;i<Admin.prod.size();i++){
            if(Admin.prod.get(i).get(1).equals(n1) && Admin.prod.get(i).get(2).equals(n2)){
                Admin.prod.get(i).set(3,n3);
                Admin.prod.get(i).set(4,n4);
            }
        }
    }

    static void proview(String u){
        System.out.printf("%-10s%-10s%-10s%-10s%-10s\n","User","Type","Brand","Quantity","Price");
        for(int i=0;i<Admin.prod.size();i++){
            if(Admin.prod.get(i).get(0).equals(u)){
                System.out.printf("%-10s%-10s%-10s%-10s%-10s\n",Admin.prod.get(i).get(0),Admin.prod.get(i).get(1),Admin.prod.get(i).get(2),Admin.prod.get(i).get(3),Admin.prod.get(i).get(4));
            }
        }
        try{
            System.in.read();
            merview(u);
        }catch (Exception e){
        }
    }

    static void comp(String u){
        sc.nextLine();
        System.out.println("Enter Product type");
        String s = sc.nextLine();
        for(int i=0;i<Admin.prod.size();i++){
            if(Admin.prod.get(i).get(1).equals(s)){
                System.out.println("Model : "+Admin.prod.get(i).get(2)+" Price : "+Admin.prod.get(i).get(4));
            }
        }
        try{
            System.in.read();
            merview(u);
        }catch (Exception e){
        }
    }
}

class User{
    private static Scanner sc;
    static void output(){
        sc = new Scanner(System.in);
        int n;
            System.out.println("1. New User");
            System.out.println("2. Existing User");
            System.out.println("3. Back");
            n = sc.nextInt();
            switch(n){
                case 1:
                    newuse();
                    break;
                case 2:
                    exeuse();
                    break;
                case 3:
                    Amazon.mainfunc();
                    break;
            }
    }

    static void newuse(){
        ArrayList<String> temp = new ArrayList<>();
        temp.clear();
        sc.nextLine();
        System.out.println("Enter name");
        String name = sc.nextLine();
        System.out.println("Enter pass");
        String pass = sc.nextLine();
        temp.add(name);
        temp.add(pass);
        Admin.user.add(temp);
    }

    static void exeuse(){
        sc.nextLine();
        System.out.println("Enter name");
        String name = sc.nextLine();
        System.out.println("Enter pass");
        String pass = sc.nextLine();
        for(int i=0;i<Admin.user.size();i++){
            if(Admin.user.get(i).get(0).equals(name) && Admin.user.get(i).get(1).equals(pass)){
                uselist(Admin.user.get(i).get(0));
            }
        }
    }

    static void uselist(String u){
        int n;
        System.out.println("1. Buy Product");
        System.out.println("2. Cart");
        System.out.println("3. My Orders");
        System.out.println("4. Back");
        n = sc.nextInt();
        switch(n){
            case 1:
                int k;
                sc.nextLine();
                System.out.println("1. Shoe");
                System.out.println("2. Phone");
                System.out.println("3. Back");
                k = sc.nextInt();
                switch(k){
                    case 1:
                        buyprod("Shoe",u);
                        break;
                    case 2:
                        buyprod("Phone",u);
                        break;
                    case 3:
                        uselist(u);
                        break;
                }
                break;
            case 2:
                cartlist(u);
                break;
            case 3:
                myorder(u);
                break;
            case 4:
                output();
                break;
        }
    }
    
    static void buyprod(String n,String u){;
        ArrayList<ArrayList<String>> temp = new ArrayList<>();
        temp.clear();
        for(int i=0;i<Admin.prod.size();i++){
            if(Admin.prod.get(i).get(1).equals(n) && Integer.parseInt(Admin.prod.get(i).get(3))>0){
                System.out.println("Model : "+Admin.prod.get(i).get(2)+" Price : "+Admin.prod.get(i).get(4));
                temp.add(Admin.prod.get(i));
                temp.get(temp.size()-1).add(u);
            }
        }
        int k = sc.nextInt();
        Admin.cart.add(temp.get(k-1));
        System.out.println("Product Added in cart");
        temp.clear();
    }

    static void cartlist(String u){
        int rent=0;
        if(Admin.cart.size()>0){
            for(int i=0;i<Admin.cart.size();i++){
                if(Admin.cart.get(i).get(5).equals(u)){
                    System.out.println("Model : "+Admin.cart.get(i).get(2)+" Price : "+Admin.cart.get(i).get(4));
                    rent += Integer.parseInt(Admin.cart.get(i).get(4));
                }
            }
            sc.nextLine();
            System.out.println("Do you want to checkout ?");
            String s = sc.nextLine();
            if(s.equals("y")){
                System.out.println("Payment Method");
                System.out.println("1. Cash on Delivery");
                System.out.println("2. Wallet Paymet");
                int q = sc.nextInt();
                if(q==1){
                    for(int i=0;i<Admin.cart.size();i++){
                        if(Admin.cart.get(i).get(5).equals(u)){
                            Admin.myorder.add(Admin.cart.get(i));
                        }
                    }
                    System.out.println("Order placed Successfully");
                    Admin.cart.clear();
                    }else if(q==2){
                        if(rent<=Admin.wallet){
                            for(int i=0;i<Admin.cart.size();i++){
                                if(Admin.cart.get(i).get(5).equals(u)){
                                    Admin.myorder.add(Admin.cart.get(i));
                                }
                            }
                            System.out.println("Order placed Successfully");
                            Admin.cart.clear();
                        }else{
                            System.out.println("Insufficient ammount in wallent");
                        }
                    }
                }
        }else{
            System.out.println("No item in the cart");
        }
        try{
            System.in.read();
            uselist(u);
        }catch (Exception e){
        }
    }

    static void myorder(String u){
        for(int i=0;i<Admin.myorder.size();i++){
            if(Admin.myorder.get(i).get(5).equals(u)){
                System.out.println("Model : "+Admin.myorder.get(i).get(2)+" Price : "+Admin.myorder.get(i).get(4));
            }
        }
        try{
            System.in.read();
            uselist(u);
        }catch (Exception e){
        }
    }
}