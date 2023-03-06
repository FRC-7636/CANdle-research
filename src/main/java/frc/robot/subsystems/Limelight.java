package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Limelight extends SubsystemBase{
    private static NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    private static NetworkTableEntry AprilID = table.getEntry("tid");
    private static NetworkTableEntry botpose = table.getEntry("botpose");

    public double getID() {
        double ID = AprilID.getDouble(-1);
        return ID;
    }

    public double[] getPose() {
        double[] pose = botpose.getDoubleArray(new double[6]);
        return pose;
    }

    public void putData() {
        SmartDashboard.putNumber("AprilTag ID", getID());
        SmartDashboard.putNumberArray("Bot Pose (from LL)", getPose());
    }
}
