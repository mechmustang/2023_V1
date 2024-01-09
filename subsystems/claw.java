// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class claw extends SubsystemBase {
  private SparkMaxPIDController m_clawPidController;
  private CANSparkMax m_clawMotor;
  private final RelativeEncoder m_clawEncoder;

  /** Creates a new claw. */
  public claw() {
    m_clawMotor = new CANSparkMax(Constants.kClawChannel, MotorType.kBrushless);
    m_clawMotor.setInverted(Constants.kClawInverted);
    m_clawPidController = m_clawMotor.getPIDController();
    m_clawEncoder = m_clawMotor.getEncoder();
    m_clawMotor.setSmartCurrentLimit(30, 20, 0);

    m_clawPidController.setP(Constants.kClawP);
    m_clawPidController.setI(Constants.kClawI);
    m_clawPidController.setD(Constants.kClawD);
    m_clawPidController.setIZone(Constants.kClawIz);
    m_clawPidController.setFF(Constants.kClawFF);
    m_clawPidController.setOutputRange(Constants.kClawMinOutput, Constants.kClawMaxOutput);

    m_clawMotor.burnFlash();
  }

  public double getPosition() {
    return m_clawEncoder.getPosition();
  }

  public void move(double speed) {
    m_clawMotor.set(speed);
    SmartDashboard.putNumber("Claw Position", m_clawEncoder.getPosition());
  }

  public void resetEncoder() {
    m_clawEncoder.setPosition(0);
  }

  public void halt() {
    m_clawMotor.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}