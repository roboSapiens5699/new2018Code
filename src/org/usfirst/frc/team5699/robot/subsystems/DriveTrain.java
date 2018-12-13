package org.usfirst.frc.team5699.robot.subsystems;


import org.usfirst.frc.team5699.robot.Robot;
import org.usfirst.frc.team5699.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;


public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private Spark rightDrive;
    private Spark leftDrive;

    private double leftSpeed;
    private double rightSpeed;
    private boolean checkReverse;
    private int reversed;

    public DriveTrain(){
        rightDrive = new Spark(RobotMap.RIGHT_DRIVE);
        leftDrive = new Spark(RobotMap.LEFT_DRIVE);

        reversed = 1;
        checkReverse = false;

    }
    public void initDefaultCommand() {
        // TODO: Set the default command, if any, for a subsystem here. Example:
        //    setDefaultCommand(new MySpecialCommand())
    }

    public void reverse(){
        boolean button = Robot.driver.getRawButton(8);
        boolean buttonRelease = Robot.driver.getRawButtonReleased(8);
        if (button & !checkReverse) {
            reversed *= -1;
            checkReverse = true;
        }
        if (buttonRelease) {
            checkReverse = false;
        }
    }

    public void setSpeed(){

        double rightTrigger = Robot.driver.getRawAxis(3);
        double leftTrigger = Robot.driver.getRawAxis(2);

        leftSpeed = rightTrigger - leftTrigger;
        rightSpeed = rightTrigger - leftTrigger;
    }
    public void turn(){
        double LeftStick = Robot.driver.getRawAxis(0);

        leftSpeed -= LeftStick;
        rightSpeed += LeftStick;
    }
    public  void move(){
        leftDrive.set(leftSpeed * reversed);
        rightDrive.set(-rightSpeed * reversed);
    }
}

