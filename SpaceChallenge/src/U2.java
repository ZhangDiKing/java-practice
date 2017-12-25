import java.lang.Math;
public class U2 extends Rocket {
    public U2(){
        super((double) (1.2),(long) (18*1000),(long) (29*1000));
        Change_explosion_Rate();
    }
    /**
     * copy construction of u1
     * @param u
     * the other u
     */
    public U2(U2 u){
        super((long) (12*Math.pow(10,7)),(long) (18*Math.pow(10,6)),(long) (29*Math.pow(10,6)));
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

        this.launch_explosion_rate=0.04*(((double) weight)/((double) max_weight));
        this.land_explosion_rate=0.08*(((double) weight)/((double) max_weight));
    }


}