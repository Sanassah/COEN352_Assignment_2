package pkg.main;

public class Inventory {
    protected String inventoryID;
    protected String name;
    protected String description;
    protected double unitPrice;
    protected double quantityInStock;
    protected double inventoryValue;
    protected double reorderLevel;
    protected double reorderTime;
    protected double quantityInReorder;
    protected boolean discontinued;

    public Inventory(String inventoryID, String name, String description, double unitPrice, double quantityInStock, double inventoryValue, double reorderLevel, double reorderTime, double quantityInReorder, boolean discontinued){
        this.inventoryID = inventoryID;
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.quantityInStock = quantityInStock;
        this.inventoryValue = inventoryValue;
        this.reorderLevel = reorderLevel;
        this.reorderTime = reorderTime;
        this.quantityInReorder = quantityInReorder;
        this.discontinued = discontinued;
    }

    // Overriding toString() method of String class
    @Override
    public String toString() {
        return (this.inventoryID + ", " + this.name + ", " + this.description + ", " + this.unitPrice + ", " + this.quantityInStock + ", " + this.inventoryValue + ", " + this.reorderLevel + ", " + this.reorderTime + ", " + this.quantityInStock + ", " + this.discontinued);
    }

    public String getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(String inventoryID) {
        this.inventoryID = inventoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(double quantityInReorder) {
        this.quantityInStock = quantityInReorder;
    }

    public double getInventoryValue() {
        return (this.quantityInStock * this.unitPrice);
    }

    public void setInventoryValue(double inventoryValue) {
        this.inventoryValue = inventoryValue;
    }

    public double getReorderLevel(){
        return reorderLevel;
    }

    public void setReorderLevel(int reorderLevel){
        this.reorderLevel = reorderLevel;
    }

    public double getReorderTime(){
        return reorderTime;
    }

    public void setReorderTime(double reorderTime){
        this.reorderTime = reorderTime;
    }

    public double getQuantityInReorder(){
        return quantityInReorder;
    }

    public void setQuantityInReorder(double quantityInReorder){
        this.quantityInReorder = quantityInReorder;
    }

    public boolean getDiscontinued(){
        return discontinued;
    }

    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }
}
