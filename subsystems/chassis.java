// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;


public class chassis extends SubsystemBase {
  /** Creates a new chassis. */
  private Spark leftMotors, rightMotors;
  private DifferentialDrive drive;
  private ADXRS450_Gyro gyro;
  

  public chassis() {
    // This is the constructor for the class
    leftMotors = new Spark(Constants.kLeftChassisMotorPort);
    rightMotors = new Spark(Constants.kRightChassisMotorPort);
    rightMotors.setInverted(Constants.kRightChassisMotorsInverted);
    leftMotors.setInverted(Constants.kLeftChassisMotorsInverted);
    
    drive = new DifferentialDrive(leftMotors, rightMotors);
    gyro = new ADXRS450_Gyro();

  }

  public void setMaxOutputLow() {
    drive.setMaxOutput(Constants.kChassisMaxOutputLow);
  }

  public void setMaxOutputHigh() {
    drive.setMaxOutput(Constants.kChassisMaxOutputHigh);

  }

  public void arcadeDrive(double speed, double rotation) {
    drive.arcadeDrive(speed, rotation);
  }

  public double getAngle() {
    return gyro.getAngle();
  } 

  public void resetGyro() {
    gyro.reset();
  }

   
  public void calibrateGyro() {
    gyro.calibrate();
  }

  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("gryoValue", this.getAngle());
  }
}
