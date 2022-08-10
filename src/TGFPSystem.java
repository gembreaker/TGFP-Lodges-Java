import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class TGFPSystem {

    // non parametrised contructor
    public TGFPSystem() {
//
    }

    public TGFPSystem(int max){

    }

    private static String Customername;
    private static String address;
    private static String telno;
    private static String cardno;

    private static ArrayList<Integer> customerOrder = new ArrayList<Integer>();
    private static ArrayList<Double> prices = new ArrayList<Double>();

    CustomerList list = new CustomerList();
    LodgeList lodgelist = new LodgeList();

    ArrayList<String> purchased = new ArrayList<>(5);

    public String getName(){
        return Customername;
    }

    public String getIdNum(){
        return address;
    }

    public String getTelno(){
        return telno;
    }

    public String getCardno(){
        return cardno;
    }

    public void setName(String newName){
        Customername = newName;
    }

    public void setIdNum(String newAddress){
        address = newAddress;
    }

    public void setCardno(String newCardno){
        telno = newCardno;
    }

    interface TGFP {
        public void Admin();

        public void Lodges();

        public void Customer();

        public void Bill();

        public void CustomerRecord();
    }

        static class TGFPlodgesSystem extends TGFPSystem implements TGFP {
            public void Lodges() {
                System.out.println("Welcome");
                System.out.println("What would you like to do?");
                System.out.println("\t 1. Order lodge as Customer \n\t 2. View as admin");
                Scanner input = new Scanner(System.in);
                System.out.print("Enter:");
                int option = input.nextInt();
                if (option == 1) {
                    Customer();
                } else if(option == 2){
                    Admin();
                } else {
                    System.out.println("Please enter a number between 1-4!");
                    Lodges();
                }
            }

            public void Admin() {
                System.out.println("Admin");
                System.out.println("Choose option: \n\t 1. View customer \n\t 2. Add a new customer \n\t 3. Update customer details \n\t 4. Delete a customer \n\t 5. View customer order details \n\t 99: Go back");
                Scanner inputAdmin = new Scanner(System.in);
                System.out.print("Enter:");
                int adminInput = inputAdmin.nextInt();
                if (adminInput == 1) {
                    System.out.println("\n" + "Total Customers: " + list.customername.size() + "\n");
                    // display customers
                    for (int i = 0; i < list.customername.size(); i++)
                        System.out.println("Customer No: " + i + "\n" + "Name: " + list.customername.get(i) + "\n" + "Address: " + list.customeraddress.get(i) + "\n" + "Telephone No: " + list.customertelno.get(i) + "\n" + "Card No: " + list.customercardno.get(i) + "\n");
                    System.out.println("Choose option: \n \t 1. Continue\n \t 2. Exit");
                    System.out.println("Enter:");
                    Scanner cr = new Scanner(System.in);
                    int num = cr.nextInt();
                    if (num == 1) {
                        Admin();
                    } else if (num == 2) {
                        return;
                    } else {
                        return;
                    }

                } else if (adminInput == 2) {
                    // add new customer
                    System.out.println("Customer details");
                    Scanner newCus = new Scanner(System.in);
                    // add name
                    System.out.println("Name: ");
                    String newname = newCus.nextLine();
                    list.customername.add(list.customername.size(), newname);
                    // add address
                    System.out.println("Address: ");
                    String newaddress = newCus.nextLine();
                    list.customeraddress.add(list.customeraddress.size(), newaddress);
                    // add telno
                    System.out.println("Telephone No: ");
                    String newtelno = newCus.nextLine();
                    list.customertelno.add(list.customertelno.size(), newtelno);
                    // add card no
                    System.out.println("Card No: ");
                    String newcardno = newCus.nextLine();
                    list.customercardno.add(list.customercardno.size(), newcardno);

                    System.out.println("Add ended successfully");
                    System.out.println("\n");
                    System.out.println("Choose option: \n \t 1. Continue\n \t 2. Exit");
                    System.out.println("Enter:");
                    Scanner cr = new Scanner(System.in);
                    int num = cr.nextInt();
                    if (num == 1) {
                        Admin();
                    } else if (num == 2) {
                        return;
                    } else {
                        return;
                    }

                } else if (adminInput == 3) {
                    // update customer - 5:22
                    Scanner edit = new Scanner(System.in);
                    System.out.println("Enter customer no: ");
                    int index = edit.nextInt();
                    // edit name
                    System.out.println("Name: ");
                    String name = edit.next();
                    // edit address
                    System.out.println("Address: ");
                    String address = edit.next();
                    // edit telephone no
                    System.out.println("Telephone No: ");
                    String telno = edit.next();
                    // edit card no
                    System.out.println("Card No: ");
                    String cardno = edit.next();
                    list.customername.set(index, name);
                    list.customeraddress.set(index, address);
                    list.customertelno.set(index, telno);
                    list.customercardno.set(index, cardno);

                    System.out.println("Customer details updated.\n");
                    System.out.println("Choose option: \n \t 1. Continue\n \t 2. Exit");
                    System.out.println("Enter:");
                    Scanner cr = new Scanner(System.in);
                    int num = cr.nextInt();
                    if (num == 1) {
                        Admin();
                    } else if (num == 2) {
                        return;
                    } else {
                        return;
                    }
                } else if (adminInput == 4) {
                    // remove customer
                    Scanner remove = new Scanner(System.in);
                    System.out.print("Enter customer no");
                    int removeCustomer = remove.nextInt();
                    list.customername.remove(removeCustomer);
                    list.customeraddress.remove(removeCustomer);
                    list.customertelno.remove(removeCustomer);
                    list.customercardno.remove(removeCustomer);
                    System.out.println("Customer removed successfully");
                    System.out.println("\n");
                    System.out.println("Choose option: \n \t 1. Continue\n \t 2. Exit");
                    System.out.println("Enter:");
                    Scanner cr = new Scanner(System.in);
                    int num = cr.nextInt();
                    if (num == 1) {
                        Admin();
                    } else if (num == 2) {
                        return;
                    } else {
                        return;
                    }
                }
                else if (adminInput==5){
                    CustomerRecord();
                    System.out.println("Choose option: \n \t 1. Continue\n \t 2. Exit");
                    System.out.println("Enter:");
                    Scanner cr = new Scanner(System.in);
                    int num = cr.nextInt();
                    if (num == 1) {
                        Admin();
                    } else if (num == 2) {
                        return;
                    } else {
                        return;
                    }
                }
                else if(adminInput==99){
                    main(null);
                }
                else {
                    System.out.println("Please enter a number between 1-4!");
                    System.out.println("\n");
                    Admin();
                }
            }

            public void Customer() {
                System.out.println("Order lodge\n");
                System.out.println("What would you like to order?");
                System.out.println("\n•There are 4 lodge types:");
                for (int i = 0; i < 4; i++)
                {
                    System.out.println(i + ". " + lodgelist.lodge.get(i));
                }
                // start order
                Scanner lodgePurchase = new Scanner(System.in);

                int[] purchasedList = new int[5];

                System.out.println("Which lodge type would you like? (enter number between 0-3): ");
                int lodgetype = lodgePurchase.nextInt();

                System.out.println("\n•There are 3 lodge sizes:");
                for (int i = 4; i < 7; i++)
                {
                    System.out.println(i + ". " + lodgelist.lodge.get(i));
                }
                System.out.println("What size would you like your lodge to be? (enter number between 4-6): ");
                int lodgesize = lodgePurchase.nextInt();

                System.out.println("\n•There are 3 lodge colours:");
                for (int i = 7; i < 10; i++)
                {
                    System.out.println(i + ". " + lodgelist.lodge.get(i));
                }
                System.out.println("What colour would you like your lodge? (enter number between 7-9): ");
                int lodgecolour = lodgePurchase.nextInt();

                System.out.println("Would you like us to fit your lodge? (enter 10 for yes, 11 for DIY): ");
                for (int i = 10; i < 12; i++)
                {
                    System.out.println(i + ". " + lodgelist.lodge.get(i));
                }
                int fittingtype = lodgePurchase.nextInt();

                customerOrder.add(lodgetype);
                customerOrder.add(lodgesize);
                customerOrder.add(lodgecolour);
                customerOrder.add(fittingtype);

                prices.add(lodgelist.price.get(lodgetype));
                prices.add(lodgelist.price.get(lodgesize));
                prices.add(lodgelist.price.get(lodgecolour));
                prices.add(lodgelist.price.get(fittingtype));

                Bill();
                System.out.println("Choose option: \n \t 1. Continue\n \t 2. Exit");
                System.out.println("Enter:");
                Scanner cr = new Scanner(System.in);
                int num = cr.nextInt();
                if (num == 1) {
                    Lodges();
                } else if (num == 2) {
                    return;
                } else {
                    return;
                }
            }

            public void Bill(){
                Scanner csName=new Scanner(System.in);
                System.out.print("Name: ");
                Customername=csName.nextLine();
                System.out.print("Address: ");
                address=csName.nextLine();
                System.out.print("Telephone No: ");
                telno=csName.nextLine();
                System.out.print("Card No: ");
                cardno=csName.nextLine();

                System.out.println("Bill");
                System.out.println("Customer Name: " + Customername);
                System.out.println("Customer Address: " + address);
                System.out.println("Customer Telephone No: " + telno);
                System.out.println("Customer Card No: " + cardno);
                LocalDate date = LocalDate.now();
                System.out.println("Date: " + date);
                LocalTime time = LocalTime.now();
                System.out.println("Time: " + time);
                System.out.println("Items:\t\t Prices:");

                for(int i=0; i<4; i++) {
                    System.out.println(lodgelist.lodge.get(customerOrder.get(i)) + "\t\t +£" + lodgelist.price.get(customerOrder.get(i)) + "0");
                }
                double sum =0;
                for(double j : prices){
                    sum+=j;
                }
                System.out.println("\nTotal price of lodge before VAT: £" + sum + "0");

                // add VAT
                System.out.println("VAT of lodge: £" + sum*0.2);
                System.out.println("VAT of fitting: £" + (lodgelist.price.get(customerOrder.get(3))*0.2));
                double priceofVAT = (sum * 0.2) + (lodgelist.price.get(customerOrder.get(3)) * 0.2);
                System.out.println("Total VAT: +£" + priceofVAT + "0");
                double priceafterVAT = sum + priceofVAT;
                System.out.println("Total price of lodge after VAT: £" + priceafterVAT + "0");
                double insurance = priceafterVAT * 0.001;
                System.out.println("Cost of insurance: £" + Math.round(insurance*100.0)/100.0);

                // keeping record
                File file = new File("newFile.txt");
                String name=Customername;
                String customerAddress=address;
                String customerTelNo=telno;
                String customerCardNo=cardno;
                try{
                    FileWriter output = new FileWriter("newFile.txt");
                    output.write("Customer name: " + name);
                    output.write("\nCustomer address: " + customerAddress);
                    output.write("\nCustomer telephone no: " + customerTelNo);
                    output.write("\nCustomer card no: " + customerCardNo);
                    output.write("\nDate and Time: " + date + "  " + time);
                    output.write("\nItems:\t\t Prices:\n");
                    for(int i=0; i<4; i++) {
                        output.write(lodgelist.lodge.get(customerOrder.get(i)) + "\t\t +£" + lodgelist.price.get(customerOrder.get(i)) + "0\n");
                    }
                    output.write("\nTotal price of lodge before VAT: " + sum + "0\n");
                    output.write("VAT of lodge: £" + sum*0.2 + "\n");
                    output.write("VAT of fitting: £" + (lodgelist.price.get(customerOrder.get(3))*0.2) + "\n");
                    output.write("Total VAT: +£" + priceofVAT + "0" + "\n");
                    output.write("Total price of lodge after VAT: £" + priceafterVAT + "0" + "\n");
                    output.write("Cost of insurance: £" + priceafterVAT * 0.001 + "0" + "\n");
                    output.close();
                }
                catch (Exception e){
                    e.getStackTrace();
                }


            }
            public void CustomerRecord(){
                //reading file
                char[] array = new char[1000];
                try{
                    //creates a reader using FileReader
                    FileReader input = new FileReader("newFile.txt");

                    // reads characters
                    input.read(array);
                    System.out.println("Customer Details: ");
                    if(input!=null){
                        System.out.println(array);
                    }
                }
                catch(Exception e){
                    e.getStackTrace();
                }
            }
    }
    public static void main(String[] args) {
        TGFPlodgesSystem newLoge = new TGFPlodgesSystem();
        newLoge.Lodges();
    }
}