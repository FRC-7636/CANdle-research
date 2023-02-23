// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

// import frc.robot.subsystems.Music;
import frc.robot.subsystems.candle;


public class RobotContainer {
  // private Music music;
  private candle Candle = new candle();
  private final CommandXboxController controller = new CommandXboxController(Constants.controller);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    Candle.setDefaultCommand(new RunCommand(() -> Candle.baoshang(), Candle));
    // Configure the trigger bindings
    configureBindings();
  }

  private void configureBindings() {
    // controller.a().onTrue(new RunCommand(() -> music.playMusic(), music));
    // controller.b().onTrue(new RunCommand(() -> music.stopMusic(), music));
    controller.x().whileTrue(new RunCommand(() -> Candle.rainbow(), Candle));
    //controller.y().whileTrue(new RunCommand(() -> Candle.baoshang(), Candle))
    //              .onFalse(new InstantCommand(() -> Candle.stopAnimate(), Candle));
  }

}
