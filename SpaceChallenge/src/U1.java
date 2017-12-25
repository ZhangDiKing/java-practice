import java.lang.Math;
public class U1 extends Rocket {
    public U1(){
        super((double) (1.0),(long) (10*1000),(long) (18*1000));
        Change_explosion_Rate();
    }

    /**
     * copy construction of u1
     * @param u
     * the other u
     */
    public U1(U1 u){
        super((double) (1.0),(long) (10*1000),(long) (18*1000));
        this.weight=u.weight;
        Change_explosion_Rate();
    }
    @Override
    public boolean launch(){
        double random_result=Math.random();

        if(random_result>this.launch_explosion_rate){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public boolean land(){

        double random_result=Math.random();
        if(random_result>this.land_explosion_rate){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public void Change_explosion_Rate(){
        this.launch_explosion_rate=0.05*(((double) weight)/((double) max_weight));
        this.land_explosion_rate=0.01*(((double) weight)/((double) max_weight));
    }

}
