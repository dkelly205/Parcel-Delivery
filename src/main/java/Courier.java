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

    public String drop(int noOfParcels){
        this.parcels -= noOfParcels;

        if(parcels <=0 && !complete){
            deliveriesComplete();
        }

        return "D";
    }

    public String move(Point point){

         int eastOrWest = positionX - point.getX();
         int northOrSouth = positionY - point.getY();

         String result = "";
         if(eastOrWest > 0){
             //moving west
             for(int i = 0; i < eastOrWest; i++){
                 result = result.concat("W");
             }
         }else if(eastOrWest < 0){
             //moving east
             eastOrWest *= -1;
             for(int i = 0; i < eastOrWest; i++){
                 result = result.concat("E");
             }
         }

         if(northOrSouth > 0){
             //moving south
             for(int i = 0; i < northOrSouth; i++){
                 result = result.concat("S");
             }
         }else if(northOrSouth < 0){
             //moving north
             northOrSouth *= -1;
             for(int i = 0; i < northOrSouth; i++){
                 result = result.concat("N");
             }
         }

         //set the new points
         setPositionX(point.getX());
         setPositionY(point.getY());

         return result;
    }

    public void deliveriesComplete(){
        this.setComplete(!complete);
    }


    public String deliveries(List<Point> locations){
        String result ="";
        for(Point point: locations){
            String m = move(point);
            String d = drop(1);
            result.concat(m);
            result.concat(d);
        }
        return result;
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
