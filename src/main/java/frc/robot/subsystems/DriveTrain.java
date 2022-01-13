// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  public WPI_TalonSRX frontLeft;
  public WPI_TalonSRX backLeft;

  public WPI_TalonSRX frontRight;
  public WPI_TalonSRX backRight;

  DifferentialDrive drive;

  public DriveTrain() {
    frontLeft = new WPI_TalonSRX(0);
    backLeft = new WPI_TalonSRX(1);

    frontRight = new WPI_TalonSRX(2);
    backRight = new WPI_TalonSRX(3);

    MotorControllerGroup leftMotors = new MotorControllerGroup(frontLeft, backLeft);
    MotorControllerGroup rightMotors = new MotorControllerGroup(frontLeft, backLeft);
  
    drive = new DifferentialDrive(leftMotors, rightMotors);

    drive.setExpiration(2.0);
    drive.setSafetyEnabled(false);
  }

  public void CurveDrive(double speed, double turn) {
    drive.curvatureDrive(speed, turn, false);
  }

  public void rotate(double rotate) {
    frontLeft.set(rotate*0.8);
    backLeft.set(rotate*0.8);
    frontRight.set(rotate*0.8);
    backRight.set(rotate*0.8);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    CommandScheduler.getInstance().setDefaultCommand(RobotContainer.m_driveTrain, RobotContainer.m_curveDrive);
  }
}
