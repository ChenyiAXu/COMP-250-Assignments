public abstract class Insect {
    private Tile tile;  //position of insect
    private int hp; //health points of the insects

    //constructor --> input(tile, hp)
    public Insect(Tile tile, int hp) {
        this.tile = tile;
        this.hp = hp;
        if(tile.addInsect(this)==false){
            throw new IllegalArgumentException();
        }
    }

    public final Tile getPosition() {
        return this.tile;
    }

    public final int getHealth() {
        return this.hp;
    }

    public void setPosition(Tile tile) {
        this.tile = tile;
    }

    public void takeDamage(int attack_damage){
        if( this instanceof HoneyBee && this.tile.isHive() == true){
            int reduceddamage = (int) (attack_damage * 0.9);
            this.hp = hp - reduceddamage;
            } else{
            this.hp = hp - attack_damage;
        }
        if (this.hp <= 0){
        this.tile.removeInsect(this);
        }
    }
    public abstract boolean takeAction();
    public boolean equals(Object obj){
        //matches type, position, health
        //typecasting
        if(((Insect) obj).getPosition() == this.getPosition()){
            if(((Insect) obj).getHealth() == this.getHealth()){
               if(obj.getClass() == this.getClass()){
                   return true;
               }
            }
        }
        return false;
    }

}

