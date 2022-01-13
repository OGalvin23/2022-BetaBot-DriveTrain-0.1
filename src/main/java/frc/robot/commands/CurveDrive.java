// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

public class CurveDrive extends CommandBase {
  /** Creates a new CurveDrive. */
  public CurveDrive(DriveTrain driveTrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrain); //RobotContainer.m_driveTrain ???
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    final double speed = (RobotContainer.xbox.getRightTriggerAxis() 
    - RobotContainer.xbox.getLeftTriggerAxis());

    final double turn = RobotContainer.xbox.getLeftX();

    RobotContainer.m_driveTrain.CurveDrive(speed, turn*1.5);

    double rotate = RobotContainer.xbox.getRightX();
    if (RobotContainer.xbox.getRightX() > 0.1) {
      rotate = RobotContainer.xbox.getRightX();
      RobotContainer.m_driveTrain.rotate(rotate);
    }
    if (RobotContainer.xbox.getRightX() < -0.1) {
      rotate = RobotContainer.xbox.getRightX();
      RobotContainer.m_driveTrain.rotate(rotate);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}