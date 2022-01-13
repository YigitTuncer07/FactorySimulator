import java.util.Arrays;

public class Storage {

    private int capacity;
    private Item[] items;

    public Storage(int capacity){
        this.capacity = capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public int getCapacity() {
        return capacity;
    }

    public Item[] getItems() {
        return items;
    }

    public void addItem(Item newItem){
    	if (this.items == null) {
    		Item[] arr = new Item[1];
    		arr[0] = newItem;
    		this.items = arr;
    	} else {
        	resizeArray(this.items);
        	this.items[items.length - 1] = newItem;
    	}
    }
    public void resizeArray(Item[] items) {
    	this.items = Arrays.copyOf(items, items.length + 1);
    }

}
