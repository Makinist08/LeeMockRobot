package dependencies.motor;

public class SparkFlexConfig {
    boolean isBrake;
    double currentLimit;


    public SparkFlexConfig idleMode(boolean isBrake){
        this.isBrake = isBrake;
        return this;
    }

    public SparkFlexConfig currentLimit(double currentLimit){
        this.currentLimit = currentLimit;
        return this;
    }
}
