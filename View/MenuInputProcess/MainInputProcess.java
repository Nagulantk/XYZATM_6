package View.MenuInputProcess;
import Controller.MainMenu;
import View.Menu.DisplayMenu;
import View.Menu.MainDisplayMenu;
import View.MenuInputProcess.Process;

import java.util.Scanner;
public class MainInputProcess implements Process {

    public  Enum getProcess() {
        Scanner input = new Scanner(System.in);
        MainMenu.Action action;
        String work = input.nextLine();
        work = work.toUpperCase();
        DisplayMenu displayMenu=new MainDisplayMenu();
        try {
                action = MainMenu.Action.valueOf(work);
                return action;
            } catch (Exception e) {

                System.out.println("Please enter valid process");
                displayMenu.displayMenu();
                return getProcess();

            }
    }
}
