package dependencies.motor;

public class Encoder {
    private SparkFlex spark;

    public Encoder(SparkFlex spark){
        this.spark = spark;
    }


    public double getVelocity() {
        return this.spark.velocity;
    }

    public double getPosition() {
        return this.spark.position;
    }
}
