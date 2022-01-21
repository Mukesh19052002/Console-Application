import java.util.*;
class Train {
    private static Scanner sc;
    static ArrayList<ArrayList<String>> trainname = new ArrayList<>();
    static ArrayList<ArrayList<String>> traintic = new ArrayList<>();
    static ArrayList<ArrayList<String>> userlist = new ArrayList<>();
    static ArrayList<ArrayList<String>> waitlist = new ArrayList<>();
    static ArrayList<ArrayList<String>> trainbooked = new ArrayList<>();
    static ArrayList<ArrayList<ArrayList<String>>> tempo = new ArrayList<>();
    public static String currentuser;
    static int currenttic;
    static int s1;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Main();
    }
    static void addtrain1(){
        ArrayList<ArrayList<String>> train = new ArrayList<>();
        for(int i=0;i<7;i++){
            ArrayList<String> te1 = new ArrayList<>();
            for(int j=0;j<5;j++){
                te1.add("0");
            }
            train.add(te1);
        }
        tempo.add(train);
    }

    static void Main(){
        clear();
        int n;
        do{
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Exit");
            n = sc.nextInt();
            switch(n){
                case 1:
                    sc.nextLine();
                    clear();
                    System.out.println("Enter Name");
                    String s = sc.nextLine();
                    System.out.println("Enter Password");
                    String s1 = sc.nextLine();
                    if(s.equals("a") && s1.equals("1")){
                        admin();
                    }else{
                        System.out.println("Invalid Name and Password");
                    }
                    break;
                case 2:
                    user();
                    break;
            }
        }while(n!=3);
    }

    static void admin(){
        clear();
        System.out.println("1. Add Train");
        System.out.println("2. Remove Train");
        System.out.println("3. Train Overview");
        System.out.println("4. Back");
        int n = sc.nextInt();
        switch(n){
            case 1:
                addtrain();
                break;
            case 2:
                removetrain();
                break;
            case 3:
                overview();
                break;
            case 4:
                Main();
                break;
        }
    }

    static void addtrain(){
        clear();
        sc.nextLine();
        ArrayList<String> temp = new ArrayList<>();
        temp.clear();
        System.out.println("Enter Train name");
        String name = sc.nextLine();
        System.out.println("Enter Starting Point");
        String st = sc.nextLine();
        System.out.println("Enter Station 1");
        String r1 = sc.nextLine();
        System.out.println("Enter Station 2");
        String r2 = sc.nextLine();
        System.out.println("Enter Station 3");
        String r3 = sc.nextLine();
        System.out.println("Enter Ending Point");
        String en = sc.nextLine();
        temp.add(name);
        temp.add(st);
        temp.add(r1);
        temp.add(r2);
        temp.add(r3);
        temp.add(en);
        trainname.add(temp);
        addtrain1();
        try{
            System.in.read();
            admin();
        }catch(Exception e){
        }
    }

    static void removetrain(){
        clear();
        sc.nextLine();
        System.out.println("Enter Train name");
        String s = sc.nextLine();
        for(int i=0;i<trainname.size();i++){
            if(s.equals(trainname.get(i).get(0))){
                trainname.remove(i);
            }
        }
        try{
            System.in.read();
            admin();
        }catch(Exception e){
        }
    }

    static void overview(){
        clear();
        for(int i=0;i<tempo.size();i++){
            for(int j=0;j<7;j++){
                for(int k=0;k<5;k++){
                    System.out.print(tempo.get(i).get(j).get(k)+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
        try{
            System.in.read();
            admin();
        }catch(Exception e){
        }
    }

    static void user(){
        clear();
        System.out.println("1. New User");
        System.out.println("2. Existing User");
        System.out.println("3. Back");
        int n = sc.nextInt();
        switch(n){
            case 1:
                newuser();
                break;
            case 2:
                exeuser();
                break;
            case 3:
                Main();
                break;
        }
    }

    static void newuser(){
        clear();
        ArrayList<String> temp = new ArrayList<>();
        temp.clear();
        sc.nextLine();
        System.out.println("Enter name");
        String s = sc.nextLine();
        System.out.println("Enter password");
        String s1 = sc.nextLine();
        temp.add(s);
        temp.add(s1);
        userlist.add(temp);
        user();
    }

    static void exeuser(){
        clear();
        sc.nextLine();
        System.out.println("Enter name");
        String s = sc.nextLine();
        System.out.println("Enter password");
        String s1 = sc.nextLine();
        for(int i=0;i<userlist.size();i++){
            if(userlist.get(i).get(0).equals(s) && userlist.get(i).get(1).equals(s1)){
                currentuser=userlist.get(i).get(0);
                func();
            }
        }
    }

    static void func(){
        clear();
        System.out.println("1. Book Ticket");
        System.out.println("2. My Ticket");
        System.out.println("3. Cancel Ticket");        
        System.out.println("4. Waiting List");        
        System.out.println("5. Back");
        int n = sc.nextInt();
        switch(n){
            case 1:
                booktic();
                break;
            case 2:
                showtrain();
                break;
            case 3:
                cantic();
                break;
            case 4:
                waitshow();
                break;
            case 5:
                user();
                break;
        }
    }

    static void waitshow(){
        int q=0;
        System.out.printf("%-7s%-10s%-15s%-10s%-10s\n","S.no","Tic ID","Train Name","Depature","Arrival");
        for(int i=0;i<waitlist.size();i++){
            System.out.printf("%-7d%-10s%-15s%-10s%-10s\n",q++,waitlist.get(i).get(0),waitlist.get(i).get(1),waitlist.get(i).get(2),waitlist.get(i).get(3));
        }
        System.out.println();
        System.out.println("Please Enter to continue");
        try{
            System.in.read();
            func();
        }catch(Exception e){
        }
    }

    static void booktic(){
        clear();
        ArrayList<String> temp = new ArrayList<>();
        temp.clear();
        System.out.println("---------------------------------------- Train Availability ----------------------------------------");
        System.out.println();
        System.out.printf("%-6s%-20s%-15s%-15s%-15s%-15s%-15s\n","S.no","Train Name","Depature","Station 1","Station 2","Station 3","Arrival");
        for(int i=0;i<trainname.size();i++){
            System.out.printf("%-6d%-20s%-15s%-15s%-15s%-15s%-15s\n",i+1,trainname.get(i).get(0),trainname.get(i).get(1),trainname.get(i).get(2),trainname.get(i).get(3),trainname.get(i).get(4),trainname.get(i).get(5));
        }
        System.out.println("Select train");
        s1 = sc.nextInt();
        System.out.println("Enter From");
        int st = sc.nextInt();
        System.out.println("Enter To");
        int en = sc.nextInt();
        currenttic++;
        int var = booking(s1-1,st,en);
        if(var!=-1){
            System.out.println();
        }else{
            System.out.println("Seats are fulled");
            System.out.println("You are on waiting list");
            ArrayList<String> temp1 = new ArrayList<>();
            temp1.clear();
            temp1.add(currentuser.substring(0,2)+Integer.toString(currenttic));
            temp1.add(trainname.get(s1-1).get(0));
            temp1.add(Integer.toString(st));
            temp1.add(Integer.toString(en));
            waitlist.add(temp1);
        }
        System.out.println();
        System.out.println("Please Enter to continue");
        try{
            System.in.read();
            func();
        }catch(Exception e){
        }
    }

    static void showtrain(){
        clear();
        int q=1;
        System.out.printf("%-7s%-7s%-15s%-10s%-10s\n","S.no","Tic ID","Train Name","Depature","Arrival");
        for(int i=0;i<trainbooked.size();i++){
            if(trainbooked.get(i).get(0).substring(0,2).equals(currentuser.substring(0,2))){
                System.out.printf("%-7d%-7s%-15s%-10s%-10s\n",q++,trainbooked.get(i).get(0),trainbooked.get(i).get(1),trainbooked.get(i).get(2),trainbooked.get(i).get(3));
            }
        }
        System.out.println();
        System.out.println("Please Enter to continue");
        try{
            System.in.read();
            func();
        }catch(Exception e){
        }
    }

    static int booking(int u,int st,int en){
        ArrayList<String> temp = new ArrayList<>();
        temp.clear();
        int rec = -1;
        for(int i=0;i<tempo.get(u).size();i++){
            int flag=0,flag1=0;
            for(int j=st-1;j<en;j++){
                flag++;
                if(tempo.get(u).get(i).get(j).equals("0")){
                    flag1++;
                }
            }
            if(flag==flag1){
                for(int j=st-1;j<en;j++){
                    tempo.get(u).get(i).set(j,currentuser.substring(0,2)+Integer.toString(currenttic));
                }
                rec=i;
                temp.add(currentuser.substring(0,2)+Integer.toString(currenttic));
                temp.add(trainname.get(u).get(0));
                temp.add(Integer.toString(st));
                temp.add(Integer.toString(en));
                trainbooked.add(temp);
                System.out.println("Ticket Booked");
                return rec;
            }
        }
        return rec;
    }

    static void cantic(){
        clear();
        int q=1;
        System.out.printf("%-7s%-10s%-15s%-10s%-10s\n","S.no","Tic ID","Train Name","Depature","Arrival");
        for(int i=0;i<trainbooked.size();i++){
            if(trainbooked.get(i).get(0).substring(0,2).equals(currentuser.substring(0,2))){
                System.out.printf("%-7d%-10s%-15s%-10s%-10s\n",q++,trainbooked.get(i).get(0),trainbooked.get(i).get(1),trainbooked.get(i).get(2),trainbooked.get(i).get(3));
            }
        }
        int n = sc.nextInt();
        for(int i=0;i<tempo.get(s1-1).size();i++){
            for(int j=0;j<5;j++){
                //System.out.println(tempo.get(s1-1).get(i).get(j)+" "+currentuser.substring(0,2)+Integer.toString(n));
                if(tempo.get(s1-1).get(i).get(j).equals(currentuser.substring(0,2)+Integer.toString(n))){
                    tempo.get(s1-1).get(i).set(j,"0");
                }
            }
        }
        trainbooked.remove(n-1);
        ArrayList<String> temp = new ArrayList<>();
        for(int k=0;k<trainname.size();k++){
            if(waitlist.get(k).get(1).equals(trainname.get(k).get(0))){
                for(int i=0;i<tempo.get(k).size();i++){
                    int flag=0,flag1 = 0;
                    for(int j=Integer.parseInt(waitlist.get(k).get(2))-1;j<Integer.parseInt(waitlist.get(k).get(3));j++){
                        flag++;
                        if(tempo.get(k).get(i).get(j).equals("0")){
                            flag1++;
                        }
                    }
                    if(flag==flag1){
                        for(int j=Integer.parseInt(waitlist.get(k).get(2))-1;j<Integer.parseInt(waitlist.get(k).get(3));j++){
                            tempo.get(k).get(i).set(j,waitlist.get(k).get(0));
                        }
                        temp.add(waitlist.get(k).get(0));
                        temp.add(trainname.get(k).get(0));
                        temp.add(waitlist.get(k).get(2));
                        temp.add(waitlist.get(k).get(3));
                        trainbooked.add(temp);
                        System.out.println("The waiting list will be filled to your cancellation seat");
                        waitlist.remove(k);
                        break;
                    }
                }
            }
        }
        System.out.println();
        System.out.println("Please Enter to continue");
        try{
            System.in.read();
            func();
        }catch(Exception e){
        }
    }

    static void clear(){
        System.out.print("\033[H\033[2J");
    }
}