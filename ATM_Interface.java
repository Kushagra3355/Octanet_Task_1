import java.util.*;

public class ATM_Interface {

    public static void main(String[] args) {
        System.out.println("\n\n\tWELCOME TO THE ATM MACHINE\n\n");
        ATM A1 = new ATM();
        A1.Pwd_Check();
    }
}

abstract class User_Details {
    Scanner sc = new Scanner(System.in);
    String Acc_Holder_Name = "Kushagra Omar";
    String Acc_Number = "20229873210";
    String Acc_Pwd = "1234";
    static float Acc_Bal = 6105;
    static int i = 0;
    static float arr[] = new float[100];
}

class ATM extends User_Details {

    void Pwd_Check() {
        System.out.println("Enter your PIN to login your Account");
        String Pwd = sc.next();
        if (Pwd.equals(Acc_Pwd)) {
            System.out.println("\nAccount Holder Name : " + Acc_Holder_Name);
            System.out.println("Account Number : " + Acc_Number);
            Landing_Page();
        } else {
            System.out.println("Invalid, Take out your card.");
        }
    }

    static void Landing_Page() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n1. Withdraw");
        System.out.println("2. Transfer");
        System.out.println("3. Deposit");
        System.out.println("4. Transaction History");
        System.out.println("5. View Balance");
        System.out.println("6. Quit\n");
        Transfer t1 = new Transfer();
        Withdraw w = new Withdraw();
        Deposit d = new Deposit();
        Transaction_History t2 = new Transaction_History();
        View_Balance vb = new View_Balance();
        int n = sc.nextInt();
        switch (n) {
            case 1:
                w.withdraw();
                break;
            case 2:
                t1.transfer();
                break;
            case 3:
                d.deposit();
                break;
            case 4:
                t2.transaction_history();
                break;
            case 5:
                vb.balance();
                break;
            case 6:
                System.out.println("Logged-Out.");
                break;
            default:
                System.out.println("Invalid");
                break;
        }
        sc.close();
    }
}

class Withdraw extends ATM {

    void withdraw() {
        System.out.print("Enter PIN-");
        String PIN = sc.next();
        if (PIN.equals(Acc_Pwd)) {
            System.out.println("Amount you want to withdraw-");
            float Amount_Withdraw = sc.nextFloat();
            if (Amount_Withdraw > 0 && Amount_Withdraw <= Acc_Bal) {
                Acc_Bal = Acc_Bal - Amount_Withdraw;
                arr[i] = Amount_Withdraw * (-1);
                i++;
                System.out.println("\nAmount Withdrawn Successfully.");
                System.out.println("\nPress 1 for Main Menu | Press 2 to Exit");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        Landing_Page();
                        break;
                    case 2:
                        System.out.println("Logged-out.");
                        break;
                }
            } else {
                System.out.println("INVALID!!");
            }
        } else {
            System.out.println("\nWrong PIN");
            System.out.println("\nPress 1 for Main Menu | Press 2 to Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Landing_Page();
                    break;
                case 2:
                    System.out.println("Logged-out.");
                    break;
            }
        }
    }

}

class Transfer extends ATM {

    void transfer() {
        System.out.print("Enter PIN-");
        String PIN = sc.next();
        if (PIN.equals(Acc_Pwd)) {
            System.out.print("Sender 11-digit Account Number -");
            String Ben_1 = sc.next();
            System.out.print("Reciever 11-digit Account Number -");
            String Beni_2 = sc.next();
            System.out.print("Amount-");
            float Amount_Transfer = sc.nextFloat();
            if ((Ben_1.equals(Acc_Number)) && (Beni_2.length() == 11) && Amount_Transfer <= Acc_Bal
                    && Amount_Transfer > 0) {
                Acc_Bal -= Amount_Transfer;
                System.out.println("Amount Transfered Successfully");
                arr[i] = Amount_Transfer * (-1);
                i++;
                System.out.println("\nPress 1 for Main Menu | Press 2 to Exit");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        Landing_Page();
                        break;
                    case 2:
                        System.out.println("Logged-out.");
                        break;
                }
            } else {
                System.out.println("Invalid!!");
            }
        } else {
            System.out.println("\nWrong PIN.");
            System.out.println("\nPress 1 for Main Menu | Press 2 to Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Landing_Page();
                    break;
                case 2:
                    System.out.println("Logged-out.");
                    break;
            }
        }

    }

}

class Deposit extends ATM {

    void deposit() {
        System.out.println("\nEnter amount you want to deposit.");
        float Amount_Deposit = sc.nextFloat();
        Acc_Bal += Amount_Deposit;
        System.out.println("\nAmount Deposited Successfully.");
        arr[i] = Amount_Deposit;
        i++;
        System.out.println("\nPress 1 for Main Menu | Press 2 to Exit");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                Landing_Page();
                break;
            case 2:
                System.out.println("Logged-out.");
                break;
        }
    }
}

class View_Balance extends ATM {
    void balance() {
        System.out.println("\nAvl Bal : " + Acc_Bal);
        System.out.println("\nPress 1 for Main Menu | Press 2 to Exit");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                Landing_Page();
                break;
            case 2:
                System.out.println("Logged-out.");
                break;
        }
    }
}

class Transaction_History extends ATM {

    void transaction_history() {
        System.out.println("\nTransaction History:\n");
        for (int k = 0; k < i; k++) {
            System.out.println("\t" + arr[k]);
        }
        System.out.println("\nPress 1 for Main Menu | Press 2 to Exit");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                Landing_Page();
                break;
            case 2:
                System.out.println("Logged-out.");
                break;
        }
    }

}