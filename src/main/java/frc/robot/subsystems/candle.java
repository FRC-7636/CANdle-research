package frc.robot.subsystems;

import frc.robot.Constants;

import com.ctre.phoenix.led.CANdle;
import com.ctre.phoenix.led.CANdleConfiguration;
import com.ctre.phoenix.led.RainbowAnimation;
import com.ctre.phoenix.led.StrobeAnimation;
import com.ctre.phoenix.led.CANdle.LEDStripType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class candle extends SubsystemBase {
  private CANdle m_candle = new CANdle(Constants.candleID);
  private final CANdleConfiguration config = new CANdleConfiguration();

  public candle() {
    m_candle.configFactoryDefault();
    m_candle.clearAnimation(0);
    config.stripType = LEDStripType.BRG;
    config.brightnessScalar = 0.6;
    m_candle.configAllSettings(config);
  }

  public void stopAnimate() {
    m_candle.setLEDs(0, 0, 0);
    m_candle.clearAnimation(0);
  }

  public void moveLED(double y) {
    if (y < -0.15) {
      m_candle.setLEDs(0, 255, 0);
    }
    else if (y > 0.15) {
      m_candle.setLEDs(255, 0, 0);
    }
    else {
      stopAnimate();
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
}
