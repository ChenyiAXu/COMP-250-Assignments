//TA Wenqi and Kavosh helped with de derivation of method AddInsect() and removeInsect()
public class Tile {
    private int food_present;
    private boolean bee_hive;
    private boolean hornet_nest;
    private boolean path;
    private Tile nest_hive;
    private Tile hive_nest;
    private HoneyBee honeybee;
    private SwarmOfHornets swarmofhornets;


    public Tile(int food_present, boolean bee_hive, boolean hornet_nest, boolean path, Tile nest_hive,
                Tile hive_nest, HoneyBee honeybee, SwarmOfHornets swarmofhornets) {
        this.food_present = food_present;
        this.bee_hive = bee_hive;
        this.hornet_nest = hornet_nest;
        this.path = path;
        this.nest_hive = nest_hive;
        this.hive_nest = hive_nest;
        this.honeybee = honeybee;
        this.swarmofhornets = swarmofhornets;

    }

    public Tile() {

        this.food_present = 0;
        this.bee_hive = false;
        this.hornet_nest = false;
        this.path = false;
        this.nest_hive = null;
        this.hive_nest = null;
        this.honeybee = null;
        this.swarmofhornets = new SwarmOfHornets();

    }

    public boolean isHive() {
        return this.bee_hive;
    }

    public boolean isNest() {
        return this.hornet_nest;
    }

    public void buildHive() {
        this.bee_hive = true;
        // update the field indicate whether bee hive

    }

    public void buildNest() {
        this.hornet_nest = true;
    }

    public boolean isOnThePath() {
        return this.path;
    }

    public Tile towardTheHive() {
        //if not on path, return null
        if (this.path == false) {
            return null;
        }
        return nest_hive;
    }

    public Tile towardTheNest() {
        if (this.path == false) {
            return null;
        }
        return hive_nest;
    }

    public void createPath(Tile nest_hive, Tile hive_nest) {
        this.hive_nest = hive_nest;
        this.nest_hive = nest_hive;
        this.path = true;

    }

    public int collectFood() {
        int collectedfood = this.food_present;
        this.food_present = 0;
        return collectedfood;
    }

    public void storeFood(int food_received) {
        this.food_present = food_received + food_present;
    }

    public HoneyBee getBee() {
        return this.honeybee;
    }

    public Hornet getHornet() {
        return this.swarmofhornets.getFirstHornet();
    }

    public int getNumOfHornets() {
        return this.swarmofhornets.sizeOfSwarm();
    }

    /*
    bee-> bee added if no other bee on tile
        -> no bee on the hornet nest
     hornet -> no limit to number
               -> only where there's hornet nest, bee hive or tile on psth
     */
    public boolean addInsect(Insect insect) {
        if (insect instanceof HoneyBee) {
            if (this.honeybee != null || this.hornet_nest == true)
                return false;
            else {
                insect.setPosition(this);
                this.honeybee = (HoneyBee) insect;
                return true;
            }
        }
        if (insect instanceof Hornet) {
            {
                if (this.bee_hive == true || this.hornet_nest==true || this.path==true ) {
                    insect.setPosition(this);
                    this.swarmofhornets.addHornet((Hornet) insect);
                    return true;
                }
            }

        }
        return false;

    }


   public boolean removeInsect(Insect insect){
        //if bee-> directly set it to null
    if(insect instanceof HoneyBee){
        insect.setPosition(null);
        this.honeybee = null;
        return true;
    }
    if(insect instanceof Hornet){
        this.swarmofhornets.removeHornet((Hornet) insect);
         insect.setPosition(null);
            return true;

    }
        return false;
   }




}
