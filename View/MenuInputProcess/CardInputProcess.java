package View.MenuInputProcess;

import Model.Card;
import View.MenuInputProcess.Process;

import java.util.Scanner;

public class CardInputProcess implements Process {
    public  Enum getProcess()
    {
        Scanner input = new Scanner(System.in);
        Card.CardType cardType;
        String work = input.nextLine();
        work = work.toUpperCase();
        try {
                cardType = Card.CardType.valueOf(work);
                return cardType;
            } catch (Exception e) {

                System.out.println("Please enter valid process");

                return getProcess();
            }

    }
}
