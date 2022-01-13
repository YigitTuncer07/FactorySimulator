public class Item {

	private int id;
    public static int numberOfItems;

    public Item(int id){
        this.id = id;
        numberOfItems++;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumberOfItems(int numberOfItems) {
        Item.numberOfItems = numberOfItems;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public int getId() {
        return id;
    }
}
