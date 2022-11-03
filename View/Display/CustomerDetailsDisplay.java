package View.Display;
import Controller.Verification.AccountFinding;

import Model.Customer;
import View.Verification.DataValidation;
import View.Verification.Validation;


import java.util.Scanner;
public class CustomerDetailsDisplay {
    DataValidation validating=new Validation();
    public void getDetails()
    {Scanner input=new Scanner(System.in);
        System.out.println("Enter customer Name");
        String name=input.nextLine();
        long phoneNumber=validating.validation("Phone number");
        System.out.println("Enter password");
        String password=input.nextLine();
        AccountFinding customerFinding=new AccountFinding();
        Customer customer=customerFinding.customerFinding(name,phoneNumber,password);
        if(customer!=null) {
            System.out.println("Name:" + customer.getName());
            System.out.println("Phone Number" + customer.getPhoneNumber());
            System.out.println("Pannumber:" + customer.getPanNumber());
            System.out.println("Date of birth:" + customer.getDateOfBirth());
        }
        else{
            System.out.println("Enter valid details");
        }
    }
}
