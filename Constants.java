// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
    public static final int kXBoxControllerPort = 1;
  }

  public static final double kAutoRunTime = 5000.0;
  public static final double kDriveEqA = 0.001;
  public static final double kDriveEqC = 0.4;
  public static final double kDriveEqB = -0.0008;
  public static final double kArmTime = 4000.0;
  public static final int kLeftChassisMotorPort = 1;
  public static final int kRightChassisMotorPort = 0;
  public static final boolean kLeftChassisMotorsInverted = true;
  public static final boolean kRightChassisMotorsInverted = false;
  public static final double kChassisMaxOutputLow = 0.5;
  public static final double kChassisMaxOutputHigh = 1.0;

  public static final int kArmAngleChannel = 2;
  public static final int kArmExtensionChannel = 1;
  public static final int kClawChannel = 5;

  public static final boolean kArmExtensionInverted = false;
  public static final double kArmExtensionP = 0.00004;    // Make changes here
  public static final double kArmExtensionI = 0;
  public static final double kArmExtensionD = 0;
  public static final double kArmExtensionIz = 0;
  public static final double kArmExtensionFF = 0.0014;    // and here
  public static final double kArmExtensionMaxOutput = 1; 
  public static final double kArmExtensionMinOutput = -1;

  public static final double kArmAngleSpeed = 0.50;
  public static final boolean kArmAngleInverted = false;
  public static final double kArmAngleP = 0.00004;    // Make changes here
  public static final double kArmAngleI = 0;
  public static final double kArmAngleD = 0;
  public static final double kArmAngleIz = 0;
  public static final double kArmAngleFF = 0.0014;    // and here
  public static final double kArmAngleMaxOutput = 1; 
  public static final double kArmAngleMinOutput = -1;

  public static final double kClawSpeed = 0.5;
  public static final boolean kClawInverted = false;
  public static final double kClawP = 0.00004;    // Make changes here
  public static final double kClawI = 0;
  public static final double kClawD = 0;
  public static final double kClawIz = 0;
  public static final double kClawFF = 0.0014;    // and here
  public static final double kClawMaxOutput = 1; 
  public static final double kClawMinOutput = -1;

  public static final double kArmDownPos = 260;
  public static final double kArmUpPos = 60;
  public static final double kArmBackPos = -130;

  public static SendableChooser<String> sendableChooser = new SendableChooser<>();
  public static final String defaultAuto = "driveCom";
  public static final String balAuto = "balance";


  public final class kXBox {
    public static final int buttonX = 1;
    public static final int buttonY = 4;
    public static final int buttonA = 2;
    public static final int buttonB = 3;
    public static final int buttonLeftBumper = 5;
    public static final int buttonRightBumper = 6;
    public static final int buttonLeftLowerBumper = 7;
    public static final int buttonRightLowerBumper = 8;
    public static final int buttonBack = 9;
    public static final int buttonStart = 10;
    public static final int leftXAxis = 0;
    public static final int leftYAxis = 1;
    public static final int rightXAxis = 2;
    public static final int rightYAxis = 3;
 }
}
