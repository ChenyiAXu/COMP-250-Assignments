//TA kavosh helped with the derivation of the logic of method takeAction().
public class AngryBee extends HoneyBee{
    private int attack_damage;          //attack damage of bee
    public AngryBee(Tile tile, int attack_damage){
        super(tile,10,1);
        this.attack_damage = attack_damage;
    }

    @Override
    /*
    angybee-> on path from nest to hive / on hive
                attempt to sting an hornet
           -> not positioned on path
               method return false
     sting an hornet -> find 1st non empty swarm
                        sting the first hornet [damage = attack damage]
                        cannot sting hornet on it nest
                        if no hornet -> return false
      bee on the same position
     */
    public boolean takeAction() {
       if(this.getPosition().isOnThePath()){
           //if there os hornet and  hornet not on its nest ->
           if(this.getPosition().getHornet() != null && this.getPosition().isNest() == false){
               this.getPosition().getHornet().takeDamage(this.attack_damage);
               //make sure on the same tile
               this.setPosition(this.getPosition());
               return true;
           }
       }
       //make sure on the same tile
        this.setPosition(this.getPosition());
        return false;
    }

    @Override
    public boolean equals(Object obj) {
         if(!super.equals(obj)){
             return false;
         }
         if(((AngryBee) obj).attack_damage != attack_damage){
             return false;
         }
         return true;
    }
}
