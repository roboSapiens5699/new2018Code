package org.usfirst.frc.team5699.robot.subsystems;

import org.usfirst.frc.team5699.robot.Robot;
import org.usfirst.frc.team5699.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Conveyor extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// TODO: Set the default command, if any, for a subsystem here. Example:
		// setDefaultCommand(new MySpecialCommand());
	}

	private Spark motor;

	public Conveyor() {
		motor = new Spark(RobotMap.CONVEYOR_SPIN);
	}
	// set DefaultCommand (new MySpecialCommand()):
	// setDefaultCommand(null);

	// Spins the conveyor belt
	public void spinConveyor() {
		if (Robot.driver.getRawButton(4)) {
			motor.set(0.75);
		} else if (Robot.driver.getRawButton(1)) {
			motor.set(-0.75);
		} else {
			motor.set(0);
		}
	}

}
