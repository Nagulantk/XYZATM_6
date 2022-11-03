package Controller;

import Controller.ATM.XyzAtm;
import Controller.Banking.NetBanking;
import Controller.Swiping.SwipeMachine;
import View.Menu.DisplayMenu;
import View.Menu.MainDisplayMenu;
import View.MenuInputProcess.MainInputProcess;
import View.MenuInputProcess.Process;

public class MainMenu {
    public  enum Action {
        BANKING,
        ATM,
        SWIPE,
        EXIT
    }
    public void mainWorking() {
        boolean condition = true;
        SwipeMachine machine = new SwipeMachine();
        Action action;
        while (condition) {
            DisplayMenu displayMenu=new MainDisplayMenu();
            displayMenu.displayMenu();
           Process process=new MainInputProcess();
            action= (Action) process.getProcess();

            switch (action) {

                case ATM:
                    XyzAtm atm = new XyzAtm();
                    atm.AtmWorking();
                    break;
                case BANKING:
                    NetBanking bank = NetBanking.getBank();
                    bank.bankWorking();
                    break;
                case SWIPE:
                    machine.swipeMachineWork();
                    break;
                case EXIT:
                    condition = false;
                    System.out.println("Thank you");
                    break;
            }
        }
    }
}
