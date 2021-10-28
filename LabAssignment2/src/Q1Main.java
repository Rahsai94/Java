public class Q1Main {
    public static void main(String[] args) {

        // 2 new instances of invoice item,
        InvoiceItem invoiceItem1 = new InvoiceItem(1,"Invoice for the Laptop", 3,  2000);

        InvoiceItem invoiceItem2 = new InvoiceItem(2,"Invoice for the Printer", 6,  75);
        
        //Set Invoice 1 Bill is Paid
        invoiceItem1.setPaid(true);

        //Set Invoice 2 Bill is Paid
        invoiceItem2.setPaid(true);

        System.out.println("----------------------- INVOICES ----------------------------");

        System.out.println(invoiceItem1.toString());
        System.out.println(invoiceItem2.toString());


    }
}
