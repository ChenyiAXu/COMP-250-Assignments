public class TankyBee extends HoneyBee{
    private int attack_damage;
    private int armor;

    public TankyBee(Tile tile, int attack_damage , int armor){
        super(tile, 30, 3);
        this.attack_damage = attack_damage;
        this.armor = armor;

    }

    @Override
    /*
        can only sting hornets that are positioned on the same tile as them
        sting the first hornet (non empty)
                damage = attackdamage
     */
    //how to implement on the same hornet
    public boolean takeAction() {
        if(this.getPosition().getHornet() != null){
            this.getPosition().getHornet().takeDamage(this.attack_damage);
            return true;
        }
        return false;
    }

    public void takeDamage(int damage_received){
        int reduceddamage = (int) ((100.0/(100.0 + this.armor))*damage_received);
        super.takeDamage(reduceddamage);
    }

    @Override
    public boolean equals(Object obj) {
        if(!super.equals(obj)){
            return false;
        }
        if(((TankyBee) obj).attack_damage != this.attack_damage){
            return false;
        }
        if(((TankyBee) obj).armor != this.armor){
            return false;
        }
        return true;
    }


    }
