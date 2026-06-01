package main.java.frc.robot;

public class Main {
    public static void main(String[] args) {
        Robot robot = new Robot();

        robot.robotInit();
        robot.autonomousInit();

        for (int i = 0; i < 15; i++) {
            robot.autonomousPeriodic();
            robot.robotPeriodic();
        }

        robot.autonomousExit();

        robot.teleopInit();

        for (int i = 0; i < 60; i++) {
            robot.teleopPeriodic();
            robot.robotPeriodic();
        }
        robot.robotExit();
    }
}
