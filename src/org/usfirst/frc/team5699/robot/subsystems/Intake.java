package org.usfirst.frc.team5699.robot.subsystems;
import java.util.Calendar;

import org.usfirst.frc.team5699.robot.Robot;
import org.usfirst.frc.team5699.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Intake extends Subsystem {
    private boolean first;
    private long saved;
    private double speed;
    private Spark rMotor, lMotor;
    // Setting motor controlers
    public Intake(){
        speed = 0;
        saved = 0;
        first = true;
        lMotor = new Spark(RobotMap.INTAKE_LEFT_WHEEL);
        rMotor = new Spark(RobotMap.INTAKE_RIGHT_WHEEL);
    }

    public void initDefaultCommand() {
        setDefaultCommand(null);
    }

    // Spins intake

    public void spinArm(){
        //check if it is the first cycle
        if (Robot.driver.getRawButton(6)){
            if (first) {
                //sets starting time
                saved = Calendar.getInstance().getTimeInMillis();
                //sets first cycle flag to false
                first = false;

            }
            if (speed < 0.75) {
                //Gets the time and checks it against the original time and then reduces the number.
                speed = (Calendar.getInstance().getTimeInMillis() - saved) * 0.01;
            }
            lMotor.set(speed);
            rMotor.set(-speed);
        }else if (Robot.driver.getRawButton(7)){
            lMotor.set(-0.75);
            rMotor.set(0.75);
        }else{
            lMotor.set(0);
            rMotor.set(0);
            first = false;
            speed = 0;
        }
    }

}

