import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<String> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(String item) {
        items.add(item);
    }

    public void clear() {
        items.clear();
    }

    public int getItemCount() {
        return items.size();
    }

    public boolean contains(String item) {
        return items.contains(item);
    }
}