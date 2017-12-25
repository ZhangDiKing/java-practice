public class Rocket implements SpaceShip {

    public double cost;
    public long weight;
    public long rocket_weight;
    public long max_weight;
    public double launch_explosion_rate;
    public double land_explosion_rate;

    /**
     * the construction of the rocket
     * @param cost
     * the cost od the rocket
     * @param rocket_weight
     * the weight of the rocket
     * @param max_weight
     * the max weight of the rocket
     */
    public Rocket(double cost, long rocket_weight, long max_weight){
        this.cost=cost;
        this.rocket_weight=rocket_weight;
        this.weight=rocket_weight;
        this.max_weight=max_weight;

    }

    public boolean launch(){
        return true;
    }
    public boolean land(){
        return true;
    }

    @Override
    public boolean canCarry(Item item){

        if (weight+item.weight<=max_weight){
            return true;
        }else{
            return false;
        }

    }
    /**
     * change the explosion rate if weight changed
     */
    public void Change_explosion_Rate(){

    }
    @Override
    public void carry(Item item){

        if(this.canCarry(item)) {
            weight += item.weight;
            Change_explosion_Rate();
        }

    }
}
