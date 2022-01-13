// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;

public class GearShift extends SubsystemBase {
  /** Creates a new GearShift. */
  public Solenoid shifter;

  public GearShift() {
    shifter = new Solenoid(PneumaticsModuleType.CTREPCM, 1);
  }

  public void shift(boolean state) {
    shifter.set(state);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
