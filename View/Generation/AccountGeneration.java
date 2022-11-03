package View.Generation;

import View.Verification.DataValidation;
import View.Verification.DateVerification;
import View.Verification.Validation;
import View.Verification.VerifyDate;

import java.time.*;
import java.util.*;
public class AccountGeneration implements BankAccountGeneration {
    Scanner input=new Scanner(System.in);
    DataValidation validating=new Validation();
    DateVerification dateVerification=new VerifyDate();
    public Object[] accountGeneration()
    {   System.out.println("Enter Name:");
        String name=input.nextLine();
        long phoneNumber=validating.validation("Phone number");
        LocalDate dateOfBirth=dateVerification.verifyDate();

        System.out.println(dateOfBirth);

        long panNumber=validating.validation("Pan card Number");
        long balance=validating.validation("Balance");

       String newPassword;
       String password;
        do {
            System.out.println("Enter password");
            password = input.nextLine();
            System.out.println("ReEnter password");
           newPassword = input.nextLine();
            if(!password.equals(newPassword))
            {
                System.out.println("Reentered password is not same as password");
            }
        }while(!password.equals(newPassword));
        Object[] detailsList=new Object[6];
        detailsList[0]=name;
        detailsList[1]=panNumber;
        detailsList[2]=dateOfBirth;
        detailsList[3]=phoneNumber;
        detailsList[4]=password;
        detailsList[5]=balance;
      return  detailsList;

    }
}


