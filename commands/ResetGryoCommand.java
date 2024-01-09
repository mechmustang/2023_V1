package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.chassis;

public class ResetGryoCommand extends CommandBase {
    private final chassis m_chassis;

    public ResetGryoCommand(chassis chassis) {
      // Use addRequirements() here to declare subsystem dependencies.
      m_chassis = chassis;
      addRequirements(m_chassis);
    }

    @Override
    public void initialize() {
      m_chassis.resetGyro();
    }

    @Override
    public boolean isFinished() {
      return true;
    }
}
