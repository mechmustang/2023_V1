// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.armLift;
import frc.robot.subsystems.chassis;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class auto extends SequentialCommandGroup {
  private final chassis m_chassis;
  private final armLift m_ArmLift;
  /** Creates a new auto. */
  public auto(chassis chassis, armLift armLift) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    m_chassis = chassis;
    m_ArmLift = armLift;
  
    m_chassis.resetGyro();

    String autoSelected = Constants.sendableChooser.getSelected();

    System.out.println("BEGIN AUTO SELECTED");
    System.out.println(autoSelected);
    System.out.println(autoSelected == null);
    System.out.println("END AUTO SELECTED");

    if(autoSelected == Constants.defaultAuto) {
      addCommands(new autoArmBack(m_ArmLift));
      addCommands(new autoDrive(m_chassis));

    } else if (autoSelected == Constants.balAuto) {
      addCommands(new autoArmBack(m_ArmLift));
      addCommands(new autoArmForward(m_ArmLift));
      addCommands(new autoDriveStart(m_chassis));
      addCommands(new autoDriveFinish2(m_chassis));
      
    } else {
      addCommands(new ResetGryoCommand(m_chassis));

      //Place and Balance
      //addCommands(new autoParallel(m_chassis, m_ArmLift));

      /*addCommands(new autoArmBack(m_ArmLift));
      addCommands(new autoArmForward(m_ArmLift));
      addCommands(new autoDriveStart(m_chassis));
      addCommands(new autoDriveFinish2(m_chassis));*/

      //Place and Back out
      //addCommands(new autoParallel(m_chassis, m_ArmLift));

      addCommands(new autoArmBack(armLift));
      addCommands(new autoArmForward(m_ArmLift));
      addCommands(new autoDrive(m_chassis));
    }

  }

}