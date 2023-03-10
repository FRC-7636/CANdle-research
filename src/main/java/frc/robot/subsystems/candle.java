package frc.robot.subsystems;

import frc.robot.Constants;

import com.ctre.phoenix.led.CANdle;
import com.ctre.phoenix.led.CANdleConfiguration;
import com.ctre.phoenix.led.RainbowAnimation;
import com.ctre.phoenix.led.StrobeAnimation;
import com.ctre.phoenix.led.CANdle.LEDStripType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class candle extends SubsystemBase {
  private CANdle m_candle = new CANdle(Constants.candleID);
  private final CANdleConfiguration config = new CANdleConfiguration();
  private final StrobeAnimation TurnAnimation = new StrobeAnimation(255, 162, 0, 0, 0.05, 3);


  public candle() {
    m_candle.configFactoryDefault();
    m_candle.clearAnimation(0);
    config.stripType = LEDStripType.BRG;
    config.brightnessScalar = 0.6;
    m_candle.configAllSettings(config);
  }

  public void stopAnimate() {
    m_candle.clearAnimation(0);
  }

  public void YmoveLED(double y) {
    if (y < -0.15) {
      m_candle.setLEDs(0, 255, 0, 0, 18, 4);
      SmartDashboard.putBoolean("Forward/Backward", true);
    }
    else if (y > 0.15) {
      m_candle.setLEDs(255, 0, 0, 0, 18, 4);
      SmartDashboard.putBoolean("Forward/Backward", false);
    }
    else {
      m_candle.setLEDs(0, 0, 0, 0, 18, 4);
    }
  }

  public void ZmoveLED(double z) {
    if (z > 0.05) {
      m_candle.animate(TurnAnimation, 22);
      //  m_candle.setLEDs(255, 162, 0, 0, 22, 3);
    }
    else if (z < -0.05) {
      m_candle.animate(TurnAnimation, 15);
      // m_candle.setLEDs(255, 162, 0, 0, 15, 3);
    }
    else {
      m_candle.setLEDs(0, 0, 0, 0, 22, 3);
      m_candle.setLEDs(0, 0, 0, 0, 15, 3);
    }
  }

  public void rainbow() {
    m_candle.animate(new RainbowAnimation(0.6, 0.5, 60));
  }

  public void colorBlue() {
    m_candle.setLEDs(0, 0, 255);
  }

  public void colorRed() {
    m_candle.setLEDs(255, 0, 0);
  }

  public void colorGreen() {
    m_candle.setLEDs(0, 255, 0);
  }

  public void colorWhite() {
    m_candle.setLEDs(255, 255, 255);
  }

  public void baoshang() {
    int R = (int)(Math.random() * 255);
    int G = (int)(Math.random() * 255);
    int B = (int)(Math.random() * 255);
    StrobeAnimation sa = new StrobeAnimation(R, G, B);
    sa.setSpeed(0.3);
    sa.setLedOffset(0);
    m_candle.animate(sa);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("LED Temp.", m_candle.getTemperature());
  }
}
//小數據yyds
//我愛埃穆亞!!!!!!!!!