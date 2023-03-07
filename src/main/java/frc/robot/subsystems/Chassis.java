package frc.robot.subsystems;

import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Chassis extends SubsystemBase {
    private WPI_TalonSRX LF = new WPI_TalonSRX(Constants.LF);
    private WPI_TalonSRX LR = new WPI_TalonSRX(Constants.LR);
    private WPI_TalonSRX RF = new WPI_TalonSRX(Constants.RF);
    private WPI_TalonSRX RR = new WPI_TalonSRX(Constants.RR);
    private DifferentialDrive DD = new DifferentialDrive(LF, RF);

    public Chassis() {
        LF.configFactoryDefault();
        LR.configFactoryDefault();
        RF.configFactoryDefault();
        RR.configFactoryDefault();
        LF.setInverted(true);
        LR.setInverted(true);
        LR.follow(LF);
        RR.follow(RF);
    }

    public void move(double y, double z, boolean quickTurn) {
        DD.curvatureDrive(y*0.4, z*0.4, quickTurn);
    }

}
