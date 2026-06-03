package dependencies.motor;

import dependencies.Spark;

public class SparkFlex extends Spark{

    static double TOP_SPEED = 6784.31;

    private final boolean isBrushed;

    private Encoder encoder;
    private Controller controller;
    private SparkFlexConfig config;

    private double voltage = 0;
    double position = 0;
    double velocity = 0;

    public SparkFlex(int canID, boolean isBrushed) throws Exception{
        super(canID);
        this.isBrushed = isBrushed;
        this.encoder = new Encoder(this);
        this.controller = new Controller(this);
        this.config = new SparkFlexConfig();
    }


    public void set(double percent){
        voltage = 12 * percent;

    }

    public void stopMotor(){
        velocity = 0;
    }

    public String periodic(){
        StringBuilder str = new StringBuilder("");


        if(voltage > 840/config.currentLimit){
            voltage = Math.min(840/config.currentLimit, Math.max(voltage, -840/config.currentLimit));
        }


        velocity += (565 * voltage)/TOP_SPEED;
        position += velocity/60;

        for (int i = 0; i < Math.abs(velocity); i+=200) {
            if(velocity > 1){
                str.append("F");
            } else if (velocity < -1){
                str.append("R");
            }
        }


        return  str.toString();
    }

    public void configure(SparkFlexConfig config, boolean doPersist){
        this.config = config;
    }

    public Controller getController() {
        return this.controller;
    }

    public Encoder getEncoder(){
        return this.encoder;
    }
}
