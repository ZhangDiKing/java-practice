import java.util.Comparator;
public class Item {
    String name;
    int weight;

    /**
     * the construction of the Item
     * @param name
     * the name of the Item
     * @param weight
     * the weight of the Item
     */
    Item(String name,int weight){
        this.name=name;
        this.weight=weight;
    }
    public static Comparator<Item> ItemComparator = new Comparator<Item>() {
        public int compare(Item I1, Item I2) {
            return I1.weight>I2.weight?1:-1;
        }
    };
}
