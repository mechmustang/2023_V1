// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.chassis;

public class autoDriveStart extends CommandBase {
  /** Creates a new autoDriveStart. */
  private final chassis m_chassis;

  public autoDriveStart(chassis chassis) {
    m_chassis = chassis;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_chassis);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //m_chassis.resetGyro(); 
    //Gyro is now reset in auto.java instead
    m_chassis.arcadeDrive(0, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_chassis.arcadeDrive(-0.8, -0.1);
    SmartDashboard.putNumber("gryoValue", m_chassis.getAngle());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_chassis.arcadeDrive(0, 0);
    System.out.println(("autoDriveStart command ending"));
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_chassis.getAngle() > 20.0;
  }
}
