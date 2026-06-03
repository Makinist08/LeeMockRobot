package dependencies.motor;


public class Controller {
    private SparkFlex spark;

    public Controller(SparkFlex spark){
        this.spark = spark;
    }


    public void setSetpoint(double value, ControlType type){
        if (type.equals(ControlType.VELOCITY)) {
            double currentRPM = this.spark.getEncoder().getVelocity();
            double differenceInRPM = currentRPM - value;
            spark.set(differenceInRPM / SparkFlex.TOP_SPEED);
        } else if (type.equals(ControlType.POSITION)){
            double currentPosition = this.spark.getEncoder().getPosition();
            double differenceInPosition = currentPosition - value;
            spark.set(differenceInPosition/(currentPosition == 0 ? 1 : currentPosition));
        } else {
            spark.set(value);
        }
    }
}
