public class InvoiceItem {

    private final int id;
    private final String description;
    private final int quantity;
    private final double unitPrice;
    private boolean paid;

    public InvoiceItem(int id, String description, int quantity, double unitPrice) {
        this.id = id;
        this.description = description;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.paid = false;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public String toString(){
        return "InvoiceItem[id= "+id+", description= "+description+", quantity= "+quantity+", uniPrice= "+unitPrice+", paid= "+paid+"]";
    }
}
