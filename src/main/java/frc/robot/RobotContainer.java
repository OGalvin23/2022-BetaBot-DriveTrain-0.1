// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import frc.robot.subsystems.DriveTrain;
import frc.robot.commands.CurveDrive;
import frc.robot.subsystems.GearShift;
import frc.robot.commands.ShiftUp;
import frc.robot.commands.ShiftDown;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  //put here
  public final static DriveTrain m_driveTrain = new DriveTrain();
  public final static GearShift m_gearShift = new GearShift();

  public final static CurveDrive m_curveDrive = new CurveDrive(m_driveTrain);
  public final static ShiftUp m_shiftUp = new ShiftUp(m_gearShift);
  public final static ShiftDown m_shiftDown = new ShiftDown(m_gearShift);

  public static XboxController xbox = new XboxController(0); //Our controllers: xbox controller and driverstation
  public static Joystick driveStation = new Joystick(1);
  
  private JoystickButton x = new JoystickButton(xbox, 3); //these are the buttons

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() { //says what the buttons will do
    x.whileHeld(m_shiftUp);
    x.whenReleased(m_shiftDown);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_curveDrive;
  }
}