// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.chassis;

public class autoDrive extends CommandBase {
  /** Creates a new autoDrive. */
  private final chassis m_chassis;
  private double m_startTime;

  public autoDrive(chassis chassis) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_chassis = chassis;
    addRequirements(m_chassis);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_chassis.arcadeDrive(0,0);
    m_startTime = System.currentTimeMillis();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_chassis.arcadeDrive(-0.6, -0.1);
    SmartDashboard.putNumber("gryoValue", m_chassis.getAngle());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_chassis.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (Constants.kAutoRunTime <= System.currentTimeMillis() - m_startTime);
  }
}
