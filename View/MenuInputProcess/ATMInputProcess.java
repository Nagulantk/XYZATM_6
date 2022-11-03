package View.MenuInputProcess;

import Controller.ATM.XyzAtm;
import View.Menu.ATMDisplayMenu;
import View.Menu.DisplayMenu;
import View.MenuInputProcess.Process;

import java.util.Scanner;

public class ATMInputProcess implements Process {
    public Enum getProcess() {
        Scanner input=new Scanner(System.in);
        XyzAtm.AtmActions atmAction;
        String work = input.nextLine();
        work = work.toUpperCase();
        DisplayMenu displayMenu = new ATMDisplayMenu();
        try {
            atmAction = XyzAtm.AtmActions.valueOf(work);
            return atmAction;
        } catch (Exception e) {
            System.out.println("Please enter valid process");
            displayMenu.displayMenu();
            return getProcess();
        }
    }
}
