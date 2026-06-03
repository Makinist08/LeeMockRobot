package main.java.frc.robot;

import dependencies.motor.SparkFlex;
import dependencies.motor.SparkFlexConfig;
import dependencies.Spark;
import dependencies.motor.ControlType;
import dependencies.motor.Controller;
import dependencies.motor.Encoder;


import main.java.frc.robot.constants.NeoMotorConstants;

public class Robot{

    private SparkFlex motor;
    private Controller controller;
    private Encoder encoder;
    
    public Robot() throws Exception{
        motor =  new SparkFlex(0, false);

        SparkFlexConfig baseConfig = new SparkFlexConfig();
        baseConfig.idleMode(true); 
        baseConfig.currentLimit(NeoMotorConstants.MAX_VORTEX_CURRENT);
        motor.configure(baseConfig, true);

        controller = motor.getController();
        encoder = motor.getEncoder();
    }

    public void robotInit() {

    }

    public void robotPeriodic() {
        for (Spark spark : Spark.sparks) {
            spark.periodic();
        }

    }

    public void robotExit() {
        motor.stopMotor();
    }

    public void autonomousInit() {
        controller.setSetpoint(90,ControlType.POSITION);
    }

    public void autonomousPeriodic() {
        System.out.println("Encoder reading at rpm = " + encoder.getVelocity() + " position = " + encoder.getPosition());

    }


    public void autonomousExit() {

    }

    public void teleopInit() {
        controller.setSetpoint(2000,ControlType.VELOCITY);

    }

    public void teleopPeriodic() {
        System.out.println("Encoder reading at rpm = " + encoder.getVelocity() + " position = " + encoder.getPosition());

    }

    public void teleopExit() {

    }

}