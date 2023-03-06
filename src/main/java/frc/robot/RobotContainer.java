// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Chassis;
// import frc.robot.subsystems.Music;
import frc.robot.subsystems.candle;


public class RobotContainer {
  // private Music music;
  private Chassis chassis = new Chassis();
  private candle Candle = new candle();
  private final CommandXboxController controller = new CommandXboxController(Constants.controller);

  private void chassis_v() {
    chassis.setDefaultCommand(Commands.run(() -> chassis.move(controller.getLeftY(), controller.getRightX()), chassis));
  }

  private void candle_v() {
    Candle.setDefaultCommand(Commands.run(() -> Candle.moveLED(controller.getLeftY()), Candle));
  }

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    chassis_v();
    candle_v();
    configureBindings();
  }

  private void configureBindings() {
    // controller.a().onTrue(new RunCommand(() -> music.playMusic(), music));
    // controller.b().onTrue(new RunCommand(() -> music.stopMusic(), music));
    controller.x().whileTrue(Commands.run(Candle::rainbow, Candle));
    controller.y().whileTrue(Commands.run(Candle::baoshang, Candle));
    //controller.y().whileTrue(new RunCommand(() -> Candle.baoshang(), Candle))
    //              .onFalse(new InstantCommand(() -> Candle.stopAnimate(), Candle));
  }

}
