// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.Chassis;
// import frc.robot.subsystems.Music;
import frc.robot.subsystems.candle;


public class RobotContainer {
  // private Music music;
  private Chassis chassis = new Chassis();
  private candle Candle = new candle();
  private final CommandXboxController c_controller = new CommandXboxController(Constants.controller);
  // private final XboxController controller = new XboxController(Constants.controller);


  private void chassis_v() {
    chassis.setDefaultCommand(Commands.run(() -> chassis.move(c_controller.getLeftY(), c_controller.getRightX()), chassis));
  }

  private void candle_v() {
    Candle.setDefaultCommand(Commands.run(() -> Candle.moveLED(c_controller.getLeftY()), Candle));
  }

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    chassis_v();
    candle_v();
    configureBindings();
  }

  private void configureBindings() {
    // c_controller.a().onTrue(new RunCommand(() -> music.playMusic(), music));
    // c_controller.b().onTrue(new RunCommand(() -> music.stopMusic(), music));
    c_controller.x().whileTrue(Commands.run(Candle::rainbow, Candle));
    c_controller.y().whileTrue(Commands.run(Candle::baoshang, Candle));
    //c_controller.y().whileTrue(new RunCommand(() -> Candle.baoshang(), Candle))
    //              .onFalse(new InstantCommand(() -> Candle.stopAnimate(), Candle));
  }

}
