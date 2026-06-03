package main.java.frc.robot;

public final class Main {
    public static void main(String[] args) throws InterruptedException{
        Thread main = Thread.currentThread();
        Robot robot = new Robot();

        robot.robotInit();
        System.out.println("-Init Robot-");


        robot.autonomousInit();
        System.out.println("-Init Auto-");

        for (int i = 0; i < 16; i++) {
            robot.autonomousPeriodic();
            robot.robotPeriodic();
            Thread.sleep(250);
            System.out.println("Seconds Elapsed in Auto: " + i);
        }

        robot.autonomousExit();
        System.out.println("-Exit Auto-");

        robot.teleopInit();
        System.out.println("-Init Tele-");

        for (int i = 0; i < 61; i++) {
            robot.teleopPeriodic();
            robot.robotPeriodic();
            Thread.sleep(250);
            System.out.println("Seconds Elapsed in Tele: " + i);
        }

        robot.teleopExit();
        System.out.println("-Exit Tele-");

        robot.robotExit();
        System.out.println("-Exit Robot-");
    }
}
