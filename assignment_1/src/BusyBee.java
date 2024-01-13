public class BusyBee extends HoneyBee{
    public BusyBee(Tile tile){
        super(tile,5,2);

    }

    @Override
    /*
    bee-> collect pollen, food being added to the tile
     */
    public boolean takeAction() {
       this.getPosition().storeFood(2);
       return true;
    }
}
