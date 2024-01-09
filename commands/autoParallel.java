// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.chassis;
import frc.robot.subsystems.armLift;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class autoParallel extends ParallelCommandGroup {
  private final chassis m_chassis;
  private final armLift m_ArmLift;
  /** Creates a new autoParallel. */
  public autoParallel(chassis chassis, armLift armLift) {
    m_chassis = chassis;
    m_ArmLift = armLift;
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new autoArmForward(m_ArmLift), new autoDriveStart(m_chassis));
  }
}
