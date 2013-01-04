/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

public class Team2945Robot extends SimpleRobot {
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    RobotDrive drive = new RobotDrive(1, 2);

    // madcatz drive is always in port 1
    Joystick madcatz = new Joystick(1);

    
    public void autonomous() {
        getWatchdog().setEnabled(false);
        drive.drive(1, 0);
        Timer.delay(2);
        drive.drive(0, 0);


    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        while(true) {
            getWatchdog().feed();

            drive.tankDrive(madcatz.getRawAxis(2), madcatz.getRawAxis(5));
	    System.out.print(madcatz.getRawAxis(5) + "\n");
	    SmartDashboard.putNumber("Madcatz right", madcatz.getRawAxis(5));
	    SmartDashboard.putNumber("Madcatz left", madcatz.getRawAxis(2));
        }

    }
}
