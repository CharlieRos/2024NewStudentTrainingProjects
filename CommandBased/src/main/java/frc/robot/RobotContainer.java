// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.team1699.subsystems.Intake;
import frc.team1699.subsystems.TankDrive;

public class RobotContainer {
  private CommandXboxController driverController;
  private TankDrive drive;
  private Intake intake;

  public RobotContainer() {
    driverController = new CommandXboxController(-1);
    drive = new TankDrive();
    intake = new Intake();
    configureBindings();
  }

  private void configureBindings() {
    driverController.rightTrigger().onTrue(intake.intake()).onFalse(intake.stop());
    driverController.leftTrigger().onTrue(intake.outtake()).onFalse(intake.stop());

    drive.setDefaultCommand(drive.arcadeDrive(driverController.getLeftY(), driverController.getLeftX()));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
