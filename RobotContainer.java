// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.auto;
import frc.robot.commands.autoDrive;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.armLift;
import frc.robot.subsystems.chassis;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem;
  private final chassis m_chassis;
  //private final armExtension m_armExtension; 
  private final armLift m_ArmLift;
  private final autoDrive m_autoDrive;
  private final auto m_auto;
  //private final claw m_Claw;

  private final Joystick m_driverController;
  private final Joystick m_XboxController;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    m_exampleSubsystem = new ExampleSubsystem();
    m_chassis = new chassis();
    //m_armExtension = new armExtension();
    m_ArmLift = new armLift();
    m_driverController = new Joystick(OperatorConstants.kDriverControllerPort);
    m_XboxController = new Joystick(OperatorConstants.kXBoxControllerPort);
    m_autoDrive = new autoDrive(m_chassis);
    m_auto = new auto(m_chassis, m_ArmLift);
    //m_Claw = new claw();

    // Configure the trigger bindings
    //m_chassis.calibrateGyro();
    configureBindings();

    m_chassis.setDefaultCommand(
      new RunCommand(() -> m_chassis.arcadeDrive(
        m_driverController.getY(),
        m_driverController.getX()),
        m_chassis));

    m_ArmLift.setDefaultCommand(
      new RunCommand(() -> m_ArmLift.move(
        m_XboxController.getRawAxis(Constants.kXBox.rightYAxis)*(Constants.kArmAngleSpeed)),
        m_ArmLift));    

    /*m_armExtension.setDefaultCommand(
      new RunCommand(() -> m_armExtension.move(
        m_XboxController.getRawAxis(Constants.kXBox.leftYAxis)),
        m_armExtension));

    

    m_Claw.setDefaultCommand(new RunCommand(() -> m_Claw.move(
        Constants.kXBox.rightXAxis), 
        m_Claw));*/
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    final JoystickButton xBoxX = new JoystickButton(m_XboxController, Constants.kXBox.buttonX);
    final JoystickButton xBoxA = new JoystickButton(m_XboxController, Constants.kXBox.buttonA);
    final JoystickButton xBoxB = new JoystickButton(m_XboxController, Constants.kXBox.buttonB);
    final JoystickButton xBoxY = new JoystickButton(m_XboxController, Constants.kXBox.buttonY);
    final JoystickButton xBoxBack = new JoystickButton(m_XboxController, Constants.kXBox.buttonBack);
    final JoystickButton xBoxStart = new JoystickButton(m_XboxController, Constants.kXBox.buttonStart);
    final JoystickButton trigger = new JoystickButton(m_driverController, 1);

    xBoxA.onTrue(new InstantCommand(m_ArmLift::armUp, m_ArmLift));
    xBoxB.onTrue(new InstantCommand(m_ArmLift::armDown, m_ArmLift));
    trigger.onTrue(new InstantCommand(m_chassis::setMaxOutputLow, m_chassis)).onFalse(new InstantCommand(m_chassis::setMaxOutputHigh, m_chassis));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return m_auto;
  }
}
