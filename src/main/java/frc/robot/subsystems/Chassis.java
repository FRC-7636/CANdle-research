package frc.robot.subsystems;

import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
    SlewRateLimiter limiter1 = new SlewRateLimiter(1, -1, 0);
    SlewRateLimiter limiter2 = new SlewRateLimiter(1, -1, 0);

    public void move(double y, double z) {
        boolean quickTurn = false;
        if (Math.abs(y) < 0.15) {
            quickTurn = true;
        }
        DD.curvatureDrive(y*0.6, z*0.6, quickTurn);
        y = limiter1.calculate(y);
        z = limiter2.calculate(z);
        SmartDashboard.putNumber("Y", y);
        SmartDashboard.putNumber("Z", z);
        if (y < -0.15) {
            SmartDashboard.putBoolean("Forward/Backward", true);
        }
        else if (y > 0.15) {
            SmartDashboard.putBoolean("Forward/Backward", false);
        }
    }
    

}
