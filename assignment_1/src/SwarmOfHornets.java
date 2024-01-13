//TA Wenqi helped with the derivation of methods AddHornet(), removeHornet()
public class SwarmOfHornets {
    private Hornet[] hornets;
    private int swarm_size;

    public SwarmOfHornets() {
        this.swarm_size = 0;
        this.hornets = new Hornet[0];
        //create an empty swarm ->size to 0
    }

    public int sizeOfSwarm() {
        //takes no input, returns the number of hornets
        return this.swarm_size;
    }

    public Hornet[] getHornets() {
        //cannot contain null element
        Hornet[] newHornt = new Hornet[this.swarm_size]; //create a new hornets[] same size of this hornets[]
        int k = 0;
        for (int i = 0; i < this.swarm_size; i++) {
            if (hornets[k] != null) {
                newHornt[i] = hornets[k];
                k++;
            }
        }

        return newHornt;
    }

    public Hornet getFirstHornet() {

        for (int a = 0; a < hornets.length; a++) {
            if (hornets[a] != null) {
                return hornets[a];
            }
        }
        return null;
    }

    public void addHornet(Hornet hornet) {
        if (this.swarm_size == 0) {
            resize();
            this.hornets[0] = hornet;
            this.swarm_size = 1;
        } else {
            if(this.hornets.length == this.swarm_size){
                resize();
            }
            //update fields
            this.hornets[this.swarm_size] = hornet;
            this.swarm_size ++;
        }

    }
    private void resize(){
        Hornet[] bigger = new Hornet[this.swarm_size + 1];
        for(int i =0; i<this.swarm_size;i++){
            bigger[i] = hornets[i];
        }
        hornets = bigger;
    }


    public boolean removeHornet(Hornet hornet){
        //remove the first occurence
        //no hornet , return false
        //after remove the first occurence return true
        if (this.swarm_size == 0) {
            return false;
        }

        for(int j =0; j<this.swarm_size; j++){
            if(hornet.equals(this.hornets[j])){
                for(int c =j; c<this.swarm_size;c++){
                    this.hornets[c] = this.hornets[c+1];
                }
                this.hornets[this.swarm_size] = null;
                break;
            }
            this.swarm_size--;
            return true;
        }
        return false;
    }

}
