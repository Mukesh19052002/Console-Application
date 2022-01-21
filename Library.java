package Library;

import java.util.*;
import java.text.*;
import java.time.*;
class Library{
    public static void main(String[] args) {
        Admin.aDetails.add(new Admin("a",1));
        Admin.uDetails.add(new Admin("m",1,1000));
        Book.bookDetails.add(new Book(1,"HalfWay",5,350,0));
        Book.bookDetails.add(new Book(2,"Believe",3,500,0));
        Admin.mainfunc();
    }
    static void clear(){
        System.out.print("\033[H\033[2J");
    }
}
class Admin{
    private static Scanner sc;
    String aName;
    String uName;
    int aPass;
    int uPass;
    int uWall;
    static ArrayList<Admin> aDetails = new ArrayList<>();
    static ArrayList<Admin> uDetails = new ArrayList<>();
    Admin(String aName, int aPass) {
        this.aName = aName;
        this.aPass = aPass;
    }
    Admin(String uName, int uPass,int uWall) {
        this.uName = uName;
        this.uPass = uPass;
        this.uWall = uWall;
    }
    static void mainfunc(){
        sc = new Scanner(System.in);
        System.out.println("1. Admin");
        System.out.println("2. User");
        System.out.println("3. Exit");
        int n = sc.nextInt();
        switch(n){
            case 1:
                output();
                break;
            case 2:
                User.output();
                break;
            case 3:
                System.exit(0);
                break;
        }
    }
    static void output(){
        sc.nextLine();
        System.out.println("Enter Email Address");
        String aName = sc.nextLine();
        System.out.println("Enter Password");
        int aPass = sc.nextInt();
        for(int i=0;i<aDetails.size();i++){
            if(aName.equals(aDetails.get(i).aName) && aPass==aDetails.get(i).aPass){
                adminlogin();
            }
        }
    }
    static void adminlogin(){
        sc.nextLine();
        System.out.println("1. Admin Menu");
        System.out.println("2. User Menu");
        System.out.println("3. Book Menu");
        System.out.println("4. Book Reports");
        System.out.println("5. Fine Details");
        System.out.println("6. Back");
        int n = sc.nextInt();
        switch(n){
            case 1:
                Library.clear();
                System.out.println("1. Add Admin");
                System.out.println("2. Remove Admin");
                System.out.println("3. Back");
                int m = sc.nextInt();
                switch(m){
                    case 1:
                        addadmin();
                        break;
                    case 2:
                        removeadmin();
                        break;
                    case 3:
                        adminlogin();
                        break;
                }
                break;
            case 2:
            Library.clear();
            System.out.println("1. Add User");
            System.out.println("2. Remove User");
            System.out.println("3. Back");
            int o = sc.nextInt();
            switch(o){
                case 1:
                    adduser();
                    break;
                case 2:
                    removeuser();
                    break;
                case 3:
                    adminlogin();
                    break;
                }
                break;
            case 3:
                Library.clear();
                System.out.println("1. Add Book");
                System.out.println("2. Remove Book");
                System.out.println("3. Update Book");
                System.out.println("4. View Book");
                System.out.println("5. Search Book");
                System.out.println("6. Back");
                int p = sc.nextInt();
                switch(p){
                    case 1:
                        Book.addbook();
                        break;
                    case 2:
                        Book.removebook();
                        break;
                    case 3:
                        Book.updatebook();
                        break;
                    case 4:
                        Book.viewbook();
                        break;
                    case 5:
                        Book.searchbook();
                        break;
                    case 6:
                        adminlogin();
                        break;
                }
                break;
            case 6:
                mainfunc();
                break;
            case 5:
                User.finedetails();
                break;
            case 4:
                System.out.println("1. Less Borrowed Book");
                System.out.println("2. Most Borrowed Book");
                System.out.println("3. Not Borrowed Book");
                int c = sc.nextInt();
                switch(c){
                    case 3:
                        Book.bookReport(0);
                        break;
                    case 2:
                        Book.moreBorrow();
                        break;
                    case 1:
                        Book.lessBorrow(2);
                        break;
                }
                break;
        }
        try{
            System.in.read();
            adminlogin();
        }catch(Exception e){
        }
    }
    static void addadmin(){
        Library.clear();
        sc.nextLine();
        System.out.println("Enter Email Address");
        String aName = sc.nextLine();
        System.out.println("Enter Password");
        int aPass = sc.nextInt();
        aDetails.add(new Admin(aName, aPass));
        System.out.println("New Admin Added Successfully");
        try{
            System.in.read();
            adminlogin();
        }catch(Exception e){
        }
    }
    static void removeadmin(){
        Library.clear();
        sc.nextLine();
        System.out.println("Enter Email Address");
        String aName = sc.nextLine();
        System.out.println("Enter Password");
        int aPass = sc.nextInt();
        for(int i=0;i<aDetails.size();i++){
            if(aName.equals(aDetails.get(i).aName) && aPass==aDetails.get(i).aPass){
                aDetails.remove(i);
            }
        }
        System.out.println("Admin Removed Successfully");
        try{
            System.in.read();
            adminlogin();
        }catch(Exception e){
        }
    }
    static void adduser(){
        Library.clear();
        sc.nextLine();
        System.out.println("Enter User Name");
        String uName = sc.nextLine();
        System.out.println("Enter Password");
        int uPass = sc.nextInt();
        System.out.println("Enter Initial Amount");
        int uWall = sc.nextInt();
        uDetails.add(new Admin(uName, uPass,uWall));
        System.out.println("New User Added Successfully");
        try{
            System.in.read();
            adminlogin();
        }catch(Exception e){
        }
    }
    static void removeuser(){
        Library.clear();
        sc.nextLine();
        System.out.println("Enter User Name");
        String uName = sc.nextLine();
        System.out.println("Enter Password");
        int uPass = sc.nextInt();
        for(int i=0;i<aDetails.size();i++){
            if(uName.equals(aDetails.get(i).aName) && uPass==aDetails.get(i).aPass){
                uDetails.remove(i);
            }
        }
        System.out.println("Admin Removed Successfully");
        try{
            System.in.read();
            adminlogin();
        }catch(Exception e){
        }
    }
}
class Book{
    static ArrayList<Book> bookDetails = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    int isbn;
    String bookName;
    int bookQuantity;
    int bookPrice;
    int borrow;
    Book(int isbn,String bookName,int bookQuantity,int bookPrice,int borrow){
        this.isbn = isbn;
        this.bookName = bookName;
        this.bookQuantity = bookQuantity;
        this.bookPrice = bookPrice;
        this.borrow = borrow;
    }
    public static void lessBorrow(int k) {
        for(int i=0;i<bookDetails.size();i++){
            if(bookDetails.get(i).borrow>0 && bookDetails.get(i).borrow<=k){
                System.out.println(bookDetails.get(i).isbn+"    "+bookDetails.get(i).bookName);
            }
        }
        try{
            System.in.read();
            Admin.adminlogin();
        }catch(Exception e){
        }
    }
    public static void moreBorrow() {
        int fin = bookDetails.size()-1;
        int ind = bookDetails.get(fin).borrow;
        for(int i=0;i<bookDetails.size();i++){
            if(ind==bookDetails.get(i).borrow && bookDetails.get(i).borrow>2){
                System.out.println(bookDetails.get(i).isbn+"    "+bookDetails.get(i).bookName);
            }
        }

    }
    static void addbook(){
        Library.clear();
        System.out.println("Enter ISBN Number");
        int isbn = sc.nextInt();
        sc.nextLine();
        boolean flag=true;
        for(int i=0;i<bookDetails.size();i++){
            if(isbn==bookDetails.get(i).isbn){
                flag=false;
            }
        }
        if(flag){
                Library.clear();
                System.out.println("Enter Book Name");
                String bookName = sc.nextLine();
                System.out.println("Enter Book Quantity");
                int bookQuantity = sc.nextInt();
                System.out.println("Enter Book Price");
                int bookPrice = sc.nextInt();
                bookDetails.add(new Book(isbn,bookName,bookQuantity,bookPrice,0));
                System.out.println("Book Added Successfully");
        }else{
                Library.clear();
                System.out.println("ISBN Number is already used\nPlease Enter Valid ISBN Number");
                addbook();
        }
        try{
            System.in.read();
            Admin.adminlogin();
        }catch(Exception e){
        }
    }
    static void bookReport(int k){
        for(int i=0;i<bookDetails.size();i++){
            if(bookDetails.get(i).borrow==k){
                System.out.println(bookDetails.get(i).isbn+"    "+bookDetails.get(i).bookName);
            }
        }
        try{
            System.in.read();
            Admin.adminlogin();
        }catch(Exception e){
        }
    }
    static void removebook(){
        Library.clear();
        System.out.println("Enter ISBN Number");
        int isbn = sc.nextInt();
        for(int i=0;i<bookDetails.size();i++){
            if(isbn==bookDetails.get(i).isbn){
                bookDetails.remove(i);
            }
        }
        System.out.println("Book Removed Successfully");
        try{
            System.in.read();
            Admin.adminlogin();
        }catch(Exception e){
        }
    }
    static void updatebook(){
        Library.clear();
        System.out.println("Enter ISBN Number");
        int isbn = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<bookDetails.size();i++){
            if(isbn==bookDetails.get(i).isbn){
                System.out.println("Enter the Name to Change");
                String bookName = sc.nextLine();
                System.out.println("Enter the Quantity you have");
                int bookQuantity = sc.nextInt();
                System.out.println("Enter the price to change");
                int bookPrice = sc.nextInt();
                bookDetails.get(i).bookName=bookName;
                bookDetails.get(i).bookQuantity=bookQuantity;
                bookDetails.get(i).bookPrice=bookPrice;
            }
        }
        System.out.println("Book Updated Successfully");
        try{
            System.in.read();
            Admin.adminlogin();
        }catch(Exception e){
        }
    }
    static void viewbook(){
        Library.clear();
        System.out.println("1. Name Wise Sort\n2. Quantity Wise Sort\n3. Back");
        int n = sc.nextInt();
        System.out.printf("%-7s%-20s%-10s%-7s\n","ISBN","Book Name","Quantity","Price");
        if(n==1){
            Library.clear();
            Collections.sort(bookDetails,bookNameComparator);
            for(int i=0;i<bookDetails.size();i++){
                System.out.printf("%-7d%-20s%-10d%-7d\n",bookDetails.get(i).isbn,bookDetails.get(i).bookName,bookDetails.get(i).bookQuantity,bookDetails.get(i).bookPrice);
            }
        }else if(n==2){
            Library.clear();
            Collections.sort(bookDetails,bookQuantityComparator);
            for(int i=0;i<bookDetails.size();i++){
                System.out.printf("%-7d%-20s%-10d%-7d\n",bookDetails.get(i).isbn,bookDetails.get(i).bookName,bookDetails.get(i).bookQuantity,bookDetails.get(i).bookPrice);
            }
        }else{
            try{
                System.in.read();
                Admin.adminlogin();
            }catch(Exception e){
            }
        }
    }
    static Comparator<Book> bookNameComparator = new Comparator<Book>() {	
        public int compare(Book s1, Book s2)
                {
                    String BookName1 = s1.getBookName().toUpperCase();
                    String BookName2 = s2.getBookName().toUpperCase();
                    return BookName1.compareTo(BookName2);
                }
    };
    String getBookName(){
        return this.bookName;
    }
    static Comparator<Book> bookQuantityComparator = new Comparator<Book>() {	
        public int compare(Book s1, Book s2)
                {
                    int BookQuantity1 = s1.getBookQuantity();
                    int BookQuantity2 = s2.getBookQuantity();
                    return BookQuantity1-BookQuantity2;
                }
    };
    int getBookQuantity(){
        return this.bookQuantity;
    }
    static Comparator<Book> bookBorrowComparator = new Comparator<Book>() {	
        public int compare(Book s1, Book s2)
                {
                    int BookBorrow1 = s1.getBookBorrow();
                    int BookBorrow2 = s2.getBookBorrow();
                    return BookBorrow1-BookBorrow2;
                }
    };
    int getBookBorrow(){
        return this.borrow;
    }
    static void searchbook(){
        Library.clear();
        System.out.println("1. ISBN Wise Search Option\n2. Book Name Wise Search Option\n3. Back");
        int n = sc.nextInt();
        boolean flag=false;int index = 0;
        if(n==1){
            Library.clear();
            System.out.println("Enter ISBN Number");
            int isbn = sc.nextInt();
            for(int i=0;i<bookDetails.size();i++){
                if(bookDetails.get(i).isbn==isbn){
                    flag=true;
                    index=i;
                }
            }
            if(flag){
                Library.clear();
                System.out.printf("%-7s%-20s%-10s%-7s\n","ISBN","Book Name","Quantity","Price");
                System.out.printf("%-7d%-20s%-10d%-7d\n",bookDetails.get(index).isbn,bookDetails.get(index).bookName,bookDetails.get(index).bookQuantity,bookDetails.get(index).bookPrice);
                try{
                    System.in.read();
                    searchbook();
                }catch(Exception e){
                }
            }else{
                System.out.println("Please Enter Valid ISBN Number");
                try{
                    System.in.read();
                    searchbook();
                }catch(Exception e){
                }
            }
        }else if(n==2){
            Library.clear();
            sc.nextLine();
            System.out.println("Enter Book Name");
            String bookName= sc.nextLine();
            for(int i=0;i<bookDetails.size();i++){
                if(bookDetails.get(i).bookName.equals(bookName)){
                    flag=true;
                    index=i;
                }else{
                    flag=false;
                }
            }
            if(flag){
                Library.clear();
                System.out.printf("%-7s%-20s%-10s%-7s\n","ISBN","Book Name","Quantity","Price");
                System.out.printf("%-7d%-20s%-10d%-7d\n",bookDetails.get(index).isbn,bookDetails.get(index).bookName,bookDetails.get(index).bookQuantity,bookDetails.get(index).bookPrice);
                try{
                    System.in.read();
                    searchbook();
                }catch(Exception e){
                }
            }else{
                Library.clear();
                System.out.println("Please Enter Valid Book Name");
                try{
                    System.in.read();
                    searchbook();
                }catch(Exception e){
                }
            }
        }else{
            try{
                System.in.read();
                Admin.adminlogin();
            }catch(Exception e){
            }
        }
    }
}
class User{
    String uName;
    String reason;
    int isbn;
    int fineAmount;
    String bookName;
    String currentDate;
    String returnDate;
    int bookQuantity;
    static String currentUser;
    static String currentdate;
    static ArrayList<User> cart = new ArrayList<>();
    static ArrayList<User> checkOut = new ArrayList<>();
    static ArrayList<User> pasthistory = new ArrayList<>();
    User(String uName,int isbn,String bookName,int bookQuantity){
        this.uName = uName;
        this.isbn = isbn;
        this.bookName = bookName;
        this.bookQuantity = bookQuantity;
    }
    User(String uName,int isbn,String bookName,String currentDate,String returnDate){
        this.uName = uName;
        this.isbn = isbn;
        this.bookName = bookName;
        this.currentDate = currentDate;
        this.returnDate = returnDate;
    }
    private static Scanner sc = new Scanner(System.in);
    static void output(){
        Library.clear();
        System.out.println("Enter Name");
        String uName = sc.next();
        System.out.println("Enter Password");
        int uPass = sc.nextInt();
        for(int i=0;i<Admin.uDetails.size();i++){
            if(Admin.uDetails.get(i).uName.equals(uName) && Admin.uDetails.get(i).uPass==uPass){
                currentUser = uName;
                cDate();
                userlogin();
            }
        }
    }
    static void userlogin(){
        Library.clear();
        System.out.println("1. Book");
        System.out.println("2. Fine Details");
        System.out.println("3. Cart");
        System.out.println("4. Back");
        int n = sc.nextInt();
        switch(n){
            case 1:
                bookMenu();
                break;
            case 2:
                finedetails();
                break;
            case 3:
                checkout();
                break;
            case 4:
                Admin.mainfunc();
                break;
        }
    }
    static void bookMenu(){
        Library.clear();
        System.out.println("1. View All Books");
        System.out.println("2. Borrow Book");
        System.out.println("3. Past Borrowed Book");
        System.out.println("4. Return Book");
        System.out.println("5. Change Date");
        System.out.println("6. Books Not Returned");
        System.out.println("7. Fine Details");
        System.out.println("8. Lost Book");
        System.out.println("9. Back");
        int n = sc.nextInt();
        switch(n){
            case 1:
                viewallbook();
                break;
            case 2:
                cart();
                break;
            case 3:
                pastborrow();
                break;
            case 4:
                try {
                    returnbook();
                    } catch (Exception e) {
                }
                break;
            case 9:
                userlogin();
                break;
            case 5:
                changedate();
                break;
            case 6:
                notreturn();
                break;
            case 7:
                finedetailsUser();
                break;
            case 8:
                lostbook();
                break;
        }
    }
    static void finedetailsUser(){
        Library.clear();
        System.out.printf("%-10s%-7s%-15s%-15s%-50s\n","User","ISBN","Book Name","Fine Amount","Fine Reason");
        for(int i=0;i<FineDe.fineDetails.size();i++){
            if(currentUser.equals(FineDe.fineDetails.get(i).uName)){
                System.out.printf("%-10s%-7d%-15s%-15d%-50s\n",FineDe.fineDetails.get(i).uName,FineDe.fineDetails.get(i).isbn,FineDe.fineDetails.get(i).bookName,FineDe.fineDetails.get(i).fineAmount,FineDe.fineDetails.get(i).reason);
            }
        }
        try{
            System.in.read();
            bookMenu();
        }catch(Exception e){
        }
    }
    static void finedetails(){
        Library.clear();
        System.out.printf("%-10s%-7s%-15s%-15s%-50s\n","User","ISBN","Book Name","Fine Amount","Fine Reason");
        for(int i=0;i<FineDe.fineDetails.size();i++){
            System.out.printf("%-10s%-7d%-15s%-15d%-50s\n",FineDe.fineDetails.get(i).uName,FineDe.fineDetails.get(i).isbn,FineDe.fineDetails.get(i).bookName,FineDe.fineDetails.get(i).fineAmount,FineDe.fineDetails.get(i).reason);
        }
        try{
            System.in.read();
            Admin.mainfunc();
        }catch(Exception e){
        }
    }
    static void changedate(){
        Library.clear();
        System.out.println("Enter Days");
        int q = sc.nextInt();
        DateChanger(q);
    }
    static void DateChanger(int q){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, q);
        currentdate = dateFormat.format(c.getTime());
        System.out.println(currentdate);
        try{
            System.in.read();
            bookMenu();
        }catch(Exception e){
        }
    }
    static void cart(){
        Library.clear();
        System.out.printf("%-7s%-20s%-10s%-7s\n","ISBN","Book Name","Quantity","Price");
        for(int i=0;i<Book.bookDetails.size();i++){
            System.out.printf("%-7d%-20s%-10d%-7d\n",Book.bookDetails.get(i).isbn,Book.bookDetails.get(i).bookName,Book.bookDetails.get(i).bookQuantity,Book.bookDetails.get(i).bookPrice);
        }
        System.out.println("Enter ISBN Number to Add Cart");
        int n = sc.nextInt();
        boolean flag=true;
        for(int i=0;i<cart.size();i++){
            if(cart.get(i).isbn==n){
                flag=false;
            }
        }
        if(flag){
            for(int i=0;i<Book.bookDetails.size();i++){
                if(Book.bookDetails.get(i).isbn==n){
                    cart.add(new User(User.currentUser,Book.bookDetails.get(i).isbn, Book.bookDetails.get(i).bookName,Book.bookDetails.get(i).bookQuantity));
                }
            }
        }else{
            Library.clear();
            System.out.println("This Book is Already Added in Your Cart");
        }
        try{
            System.in.read();
            bookMenu();
        }catch(Exception e){
        }
    }
    static void viewallbook(){
        Library.clear();
        System.out.printf("%-7s%-20s%-10s%-7s\n","ISBN","Book Name","Quantity","Price");
        for(int i=0;i<Book.bookDetails.size();i++){
            System.out.printf("%-7d%-20s%-10d%-7d\n",Book.bookDetails.get(i).isbn,Book.bookDetails.get(i).bookName,Book.bookDetails.get(i).bookQuantity,Book.bookDetails.get(i).bookPrice);
        }
        try{
            System.in.read();
            bookMenu();
        }catch(Exception e){
        }
    }
    static void checkout(){
        Library.clear();
        System.out.printf("%-7s%-20s\n","ISBN","Book Name");
        for(int i=0;i<cart.size();i++){
            if(User.currentUser.equals(cart.get(i).uName)){
                System.out.printf("%-7d%-20s\n",cart.get(i).isbn,cart.get(i).bookName);
            }
        }
        if(cart.size()>3){
            Library.clear();
            System.out.println("You cannot borrow more than 3 books at an time");
        }else{
            int ind=0;
            boolean fg=true;
            for(int j=0;j<cart.size();j++){
                for(int q=0;q<checkOut.size();q++){
                    if(cart.get(j).isbn==checkOut.get(q).isbn){
                        fg=false;
                        ind = j;
                        break;
                    }
                }
            }
            if(fg){
                sc.nextLine();
                System.out.println("Do you want to checkout (y/n)");
                String s = sc.nextLine();
                if(s.equals("y")){
                    System.out.println("Enter return date (dd-mm-yyyy)");
                    String returndate = sc.nextLine();
                    boolean flag=false;
                    for(int i=0;i<cart.size();i++){
                        if(cart.get(i).bookQuantity>0){
                            flag=true;
                        }else{
                            flag=false;
                            Library.clear();
                            System.out.println(cart.get(i).bookName+"  is Out of Stock");
                        }
                    }
                    if(flag){
                        for(int i=0;i<cart.size();i++){
                            if(currentUser.equals(cart.get(i).uName)){
                                checkOut.add(new User(User.currentUser,cart.get(i).isbn,cart.get(i).bookName,currentdate,returndate));
                                for(int k=0;k<Book.bookDetails.size();k++){
                                    if(Book.bookDetails.get(k).bookName.equals(cart.get(i).bookName)){
                                        Book.bookDetails.get(k).bookQuantity-=1;
                                        Book.bookDetails.get(k).borrow+=1;
                                    }
                                }
                            }
                        }
                        cart.clear();
                    }
                }
            }else{
                Library.clear();
                System.out.println("You Already borrowed this book\n\nYou cannot borrow this book");
                cart.remove(ind);
            }
        }
        try{
            System.in.read();
            bookMenu();
        }catch(Exception e){
        }
    }
    static void pastborrow(){
        Library.clear();
        System.out.printf("%-7s%-20s%-20s%-20s\n","ISBN","Book Name","Borrow Date","Return Date");
        for(int i=0;i<pasthistory.size();i++){
            if(User.currentUser.equals(pasthistory.get(i).uName)){
                System.out.printf("%-7d%-20s%-20s%-20s\n",pasthistory.get(i).isbn,pasthistory.get(i).bookName,pasthistory.get(i).currentDate,pasthistory.get(i).returnDate);
            }
        }
        try{
            System.in.read();
            bookMenu();
        }catch(Exception e){
        }
    }
    static void notreturn(){
        Library.clear();
        System.out.printf("%-7s%-20s%-20s%-20s\n","ISBN","Book Name","Borrow Date","Return Date");
        for(int i=0;i<checkOut.size();i++){
            if(User.currentUser.equals(checkOut.get(i).uName)){
                System.out.printf("%-7d%-20s%-20s%-20s\n",checkOut.get(i).isbn,checkOut.get(i).bookName,checkOut.get(i).currentDate,checkOut.get(i).returnDate);
            }
        }
        try{
            System.in.read();
            bookMenu();
        }catch(Exception e){
        }
    }
    static void returnbook() throws Exception{
        Library.clear();
        System.out.println("Enter ISBN Number");
        int isbn = sc.nextInt();
        for(int i=0;i<checkOut.size();i++){
            if(isbn==checkOut.get(i).isbn){
                String d1 = currentdate;
                String d2 = checkOut.get(i).currentDate;
                int t_days=0;
                while(!d1.equals(d2)){
                    d2=addOneDay(d2,1);
                    t_days+=1;
                }
                if(t_days<=15){
                    System.out.println("Book Returned");
                    checkOut.remove(i);
                }else{
                    int fine=0,c=0;
                    t_days=t_days-15;
                    double a=1;
                    double b=2;
                    while(t_days!=0){
                        double d=a;
                        while(c<10){
                            if(t_days!=0){
                                fine+=(int)Math.pow(b,d);
                                c+=1;
                                t_days-=1;
                            }else{
                                break;
                            }
                        }
                        a+=1;
                        c=0;
                    }
                    fineDetail(fine,isbn);
                }
            }
        }
        try{
            System.in.read();
            bookMenu();
        }catch(Exception e){
        }
    }
    static void fineDetail(int i,int isbn){
        Library.clear();
        int ind=0;
        for(int k=0;k<Book.bookDetails.size();k++){
            if(isbn==Book.bookDetails.get(k).isbn){
                ind=k;
            }
        }
        System.out.println("You returned the Book after 15 days\nSo, Fine will be debited");
        System.out.println("1. Fine taken from Wallent");
        System.out.println("2. Cash Pay");
        int n = sc.nextInt();
        if(n==1){
            Library.clear();
            for(int j=0;j<Admin.uDetails.size();j++){
                if(Admin.uDetails.get(j).uName.equals(currentUser)){
                    Admin.uDetails.get(j).uWall-=(i);
                    System.out.println("Fine debited successfully from wallet");
                    FineDe.fineDetails.add(new FineDe(isbn,currentUser,Book.bookDetails.get(ind).bookName,i,"Fine will be debited for not returning the book within 15 days"));
                    for(int k=0;k<checkOut.size();k++){
                        if(checkOut.get(k).isbn==isbn){
                            checkOut.get(k).returnDate=currentdate;
                            pasthistory.add(checkOut.get(k));
                            checkOut.remove(k);
                        }
                    }
                }
            }
        }else if(n==2){
            Library.clear();
            System.out.println("Pay Fine of Amount : "+i);
            System.out.println("Fine debited successfully");
            FineDe.fineDetails.add(new FineDe(isbn,currentUser,Book.bookDetails.get(ind).bookName,i,"Fine will be debited for not returning the book within 15 days"));
            for(int k=0;k<checkOut.size();k++){
                if(checkOut.get(k).isbn==isbn){
                    checkOut.get(k).returnDate=currentdate;
                    pasthistory.add(checkOut.get(k));
                    checkOut.remove(k);
                }
            }
        }
        
    }
    static void returned(int isbn){
        Library.clear();
        System.out.println("Book Returned Successfully");
        for(int i=0;i<Book.bookDetails.size();i++){
            if(Book.bookDetails.get(i).isbn==isbn){
                Book.bookDetails.get(i).bookQuantity+=1;
            }
        }
        for(int i=0;i<checkOut.size();i++){
            if(checkOut.get(i).isbn==isbn){
                checkOut.get(i).returnDate=currentdate;
                pasthistory.add(checkOut.get(i));
                checkOut.remove(i);
            }
        }
        try{
            System.in.read();
            bookMenu();
        }catch(Exception e){
        }
    }
    static String addOneDay(String d2,int n)throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(d2));
        c.add(Calendar.DATE, n);  // number of days to add
        return sdf.format(c.getTime()).toString();
    }
    static void cDate(){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        currentdate=dateFormat.format(c.getTime());
    }
    static void lostbook(){
        String bname="";
        for(int i=0;i<checkOut.size();i++){
            if(checkOut.get(i).uName.equals(currentUser)){
                System.out.printf("%-7d%-15s\n",checkOut.get(i).isbn,checkOut.get(i).bookName);
            }
        }
        System.out.println("Enter ISBN Number");
        int n = sc.nextInt();
        System.out.println("Fine will be Debit for Lost of Book");
        System.out.println("1. Fine taken from Wallent");
        System.out.println("2. Cash Pay");
        int k = sc.nextInt();
        if(k==1){
            System.out.println("Fine debited from your Wallet");
            for(int i=0;i<checkOut.size();i++){
                if(checkOut.get(i).isbn==n){
                    bname = checkOut.get(i).bookName;
                }
            }
            FineDe.fineDetails.add(new FineDe(n,currentUser, bname,50,"Fine paid for lost the book"));
            for(int i=0;i<Admin.uDetails.size();i++){
                if(currentUser.equals(Admin.uDetails.get(i).uName)){
                    Admin.uDetails.get(i).uWall-=50;
                }
            }
        }else if(k==2){
            System.out.println("Fine debited from paying cash");
        }
        for(int i=0;i<checkOut.size();i++){
            if(checkOut.get(i).isbn==n){
                checkOut.remove(i);
            }
        }
        try{
            System.in.read();
            bookMenu();
        }catch(Exception e){
        }
    }
}
class FineDe{
    static ArrayList<FineDe> fineDetails = new ArrayList<>();
    String reason;
    int fineAmount;
    int isbn;
    String uName;
    String bookName;
    FineDe(int isbn,String uName,String bookName,int fineAmount,String reason){
        this.isbn = isbn;
        this.uName = uName;
        this.bookName = bookName;
        this.fineAmount = fineAmount;
        this.reason = reason;
    }
}