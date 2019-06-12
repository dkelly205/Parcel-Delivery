import java.util.List;

public class Courier {

    private int parcels;
    private int positionX;
    private int positionY;
    private boolean complete;


    public Courier(int parcels, int positionX, int positionY) {
        this.parcels = parcels;
        this.positionX = positionX;
        this.positionY = positionY;
        this.complete = false;
    }


    public int getParcels() {
        return parcels;
    }

    public void setParcels(int parcels) {
        this.parcels = parcels;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public void drop(int noOfParcels){
        this.parcels -= noOfParcels;

        if(parcels <=0 && !complete){
            deliveriesComplete();
        }
    }

    public void move(Point point){
        this.positionX = point.getX();
        this.positionY = point.getY();
    }

    public void deliveriesComplete(){
        this.setComplete(!complete);
    }


    public void deliveries(List<Point> locations){
        for(Point point: locations){
            move(point);
            drop(1);
        }
    }

    @Override
    public String toString() {
        return "Courier{" +
                "parcels=" + parcels +
                ", positionX=" + positionX +
                ", positionY=" + positionY +
                ", complete=" + complete +
                '}';
    }
}
