// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;


public class ExampleSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  private DigitalInput inputSensor = new DigitalInput(0);
  private final Field2d m_field = new Field2d();
  public ExampleSubsystem() {
    

  }

  public boolean isSensorTrue(){
    return !inputSensor.get();
  }
  
  /**
   * Example command factory method.
   *
   * @return a command
   *
   */
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }


  /* (non-Javadoc)
   * @see edu.wpi.first.wpilibj2.command.Subsystem#periodic()
   */
  @Override
  public void periodic() {   
    m_field.setRobotPose(RobotContainer.limeLight.getBlueFieldX(),
                        RobotContainer.limeLight.getBlueFieldY(),
                        new Rotation2d(RobotContainer.limeLight.getBlueFieldRot()*Math.PI/180)
    );
                      
    //m_field.setRobotPose(1.0,1.0, new Rotation2d(.5));
    SmartDashboard.putBoolean("SensorTrue", isSensorTrue());
    SmartDashboard.putData("Field", m_field);
    SmartDashboard.putNumber("Test LL Value", RobotContainer.limeLight.getBlueFieldX());
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
