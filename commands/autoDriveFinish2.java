// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.chassis;

public class autoDriveFinish2 extends CommandBase {
  /** Creates a new autoDriveStart. */
  private final chassis m_chassis;

  public autoDriveFinish2(chassis chassis) {
    m_chassis = chassis;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_chassis);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_chassis.arcadeDrive(0, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double x = m_chassis.getAngle();
    m_chassis.arcadeDrive(-Math.signum(x)*(Constants.kDriveEqA*Math.pow(x,2)+Constants.kDriveEqB*x+Constants.kDriveEqC), -0.1);
    SmartDashboard.putNumber("gryoValue", m_chassis.getAngle());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_chassis.arcadeDrive(0, 0);
    System.out.println(("autoDriveFinish2 command ending"));
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_chassis.getAngle() < 2.0;
  }
}
