import java.util.*;
public class Main {
    public static void main(String [] args) throws Exception {
        String path="/Users/zhangdi/java_practice/SpaceChallenge/src/item.txt";
        Simulation simulation=new Simulation();
        ArrayList<Item> Item_list=simulation.loadItems(path);

        //simulate U1
        ArrayList<U1> U1_list=simulation.loadU1(Item_list);
        double cost_U1=simulation.runSimulation_U1(U1_list);
        System.out.println("The simulated cost for U1 is "+cost_U1);

        //simulate U2
        ArrayList<U2> U2_list=simulation.loadU2(Item_list);
        double cost_U2=simulation.runSimulation_U2(U2_list);
        System.out.println("The simulated cost for U2 is "+cost_U2);
    }
}
