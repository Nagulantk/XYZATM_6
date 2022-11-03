package View.MenuInputProcess;

import Controller.Banking.NetBanking;
import View.Menu.BankDisplayMenu;
import View.Menu.DisplayMenu;
import View.MenuInputProcess.Process;

import java.util.Scanner;

public class BankInputProcess implements Process {
    public  Enum getProcess() {
        DisplayMenu displayMenu=new BankDisplayMenu();
        Scanner input = new Scanner(System.in);
        NetBanking.BankAction bankAction;
        String work = input.nextLine();
        work = work.toUpperCase();

        try {
            bankAction = NetBanking.BankAction.valueOf(work);
            return bankAction;
        }
        catch (Exception e) {
            System.out.println("Please enter valid process");
            displayMenu.displayMenu();
            return getProcess();
        }
    }
}
