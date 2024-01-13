public abstract class HoneyBee extends Insect{
    private int bee_cost; //how much the bee cost in food
    public HoneyBee(Tile tile, int hp, int bee_cost){
    //create a honeybee
        super(tile, hp);
        this.bee_cost = bee_cost;
    }
    public int getCost(){
        return this.bee_cost;
    }

    public boolean equals(Object obj){

        if(!super.equals(obj)){
            return false;
        }
        if(((HoneyBee) obj).bee_cost != this.bee_cost){
            return false;
        }
        return true;
    }

}
