import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
public class Simulation {
    //Simulation
    /**
     * load item from file
     * @param path
     * path of the txt file
     * @return Item_list
     * the list of items
     * @throws Exception
     * the file does not exist
     */
    public ArrayList<Item> loadItems(String path) throws Exception{
        File file = new File(path);
        Scanner fileScanner = new Scanner(file);
        ArrayList<Item> Item_list = new ArrayList();

        //start scan and add the item
        while (fileScanner.hasNextLine()){
            String line=fileScanner.nextLine();
            String[] line2 = line.split("=");
            Item I=new Item(line2[0],Integer.parseInt(line2[1]));
            Item_list.add(I);
        }
        return Item_list;
    }

    /**
     * load item to U1 as much as possible
     * @param Item_list
     * @return U1_list
     * the list of u1
     */
    public ArrayList<U1> loadU1(ArrayList<Item> Item_list){
        ArrayList<U1> U1_list = new ArrayList();
        U1 u1=new U1();
        //sort the item so that the space ship can carry as much as possible
        Collections.sort(Item_list, Item.ItemComparator);
        int size = Item_list.size();
        for (int j = 0; j < size; j++) {
            Item I=Item_list.get(j);

            if(u1.canCarry(I)){
                u1.carry(I);
            }else {
                U1_list.add(u1);
                u1 = new U1();
            }
        }
        U1_list.add(u1);
        return U1_list;

    }
    /**
     * load item to U2 as much as possible
     * @param Item_list
     * @return U2_list
     * the list of u2
     */
    public ArrayList<U2> loadU2(ArrayList<Item> Item_list){
        ArrayList<U2> U2_list = new ArrayList();
        U2 u2=new U2();
        //sort the item so that the space ship can carry as much as possible
        Collections.sort(Item_list, Item.ItemComparator);
        int size = Item_list.size();
        for (int j = 0; j < size; j++) {
            Item I=Item_list.get(j);
            if(u2.canCarry(I)){
                u2.carry(I);
            }else{
                U2_list.add(u2);
                u2=new U2();
            }

        }
        U2_list.add(u2);
        return U2_list;
    }

    /**
     * simulate the cost for the U1 rocket
     * @param Rocket_list
     * the list od rocket
     * @return cost
     */
    public long runSimulation_U1(ArrayList<U1> Rocket_list){
        long cost=0;
        int size = Rocket_list.size();
        for (int j = 0; j < size; j++) {
            U1 R=Rocket_list.get(j);
            cost+=R.cost;
            while (!R.launch() || !R.land()){
                cost+=R.cost;
            }
        }
        return cost;
    }
    /**
     * simulate the cost for the U2 rocket
     * @param Rocket_list
     * the list od rocket
     * @return cost
     */
    public long runSimulation_U2(ArrayList<U2> Rocket_list){
        long cost=0;
        int size = Rocket_list.size();
        for (int j = 0; j < size; j++) {
            U2 R=Rocket_list.get(j);
            cost+=R.cost;
            while ((!R.launch()) || (!R.land())){
                cost+=R.cost;
            }
        }
        return cost;
    }
}
