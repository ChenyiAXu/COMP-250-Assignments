public class Hornet extends Insect{
    private int attack_damage;
    public Hornet (Tile tile, int hp, int attack_damage){
        super(tile, hp);
        this.attack_damage = attack_damage;
    }


    public boolean takeAction() {
        //when its dead
        if(this.getHealth()<=0){
            return false;
        }
        //if there is a bee on the same tile, -> inflict a damage
        if(this.getPosition().getBee()!= null){
            this.getPosition().getBee().takeDamage(this.attack_damage);
            return true;
        }else {
            if(!this.getPosition().isHive()){
                //if not on bee hive -> move toward bee hive
                Tile next_position = this.getPosition().towardTheHive();
                //remove insect from this position
                this.getPosition().removeInsect(this);
                //set position to next position
                this.setPosition(next_position);
                //add the insect in
                next_position.addInsect(this);
                return true;
            } else if(this.getPosition().isHive()){
                //if already pn hive
                return false;
            }
        }
        return false;
    }


    public boolean equals(Object obj) {
        if(!super.equals(obj)){
            return false;
        }
        if(((Hornet) obj).attack_damage != this.attack_damage) {
            return false;
        }
        return true;
    }
}
