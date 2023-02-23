// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot.subsystems;

// import frc.robot.Constants;

// import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
// import com.ctre.phoenix.music.Orchestra;

// import edu.wpi.first.wpilibj2.command.SubsystemBase;

// public class Music extends SubsystemBase {
//   private WPI_TalonFX FX = new WPI_TalonFX(Constants.musicFX);
//   private Orchestra musicFX = new Orchestra();

//   public Music() {
//     FX.configFactoryDefault();
//     musicFX.addInstrument(FX);
//     musicFX.loadMusic("Never gonna give you up.chrp");
//   }

//   public void playMusic() {
//     musicFX.play();
//   }

//   public void stopMusic() {
//     musicFX.stop();
//   }
// }
