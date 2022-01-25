public class Q1Main {

    public static void main(String[] args) {

        InvoiceItem invoiceItem1 = new InvoiceItem(1,"Invoice for the Laptop", 2, 2000);
        InvoiceItem invoiceItem2 = new InvoiceItem(2,"Invoice for the printer",5,70);

        //System.out.println("Invoice 1: "+ invoiceItem1.toString());w

        invoiceItem1.setPaid(true);
        invoiceItem2.setPaid(true);

        System.out.println("Invoice 1: "+ invoiceItem1.toString());
        System.out.println("Invoice 2: "+ invoiceItem2.toString());





    }

}
