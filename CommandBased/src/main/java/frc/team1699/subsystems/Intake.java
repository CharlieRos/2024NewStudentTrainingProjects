package frc.team1699.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    /* 2 motors: top motor and bottom motor
    */
    private TalonFX topMotor, bottomMotor;

    public Intake() {
        topMotor = new TalonFX(-1);
        topMotor.setNeutralMode(NeutralModeValue.Coast);
        bottomMotor = new TalonFX(-1);
        bottomMotor.setNeutralMode(NeutralModeValue.Coast);
        bottomMotor.setInverted(true);
    }

    /*
     * intake
     * outtake
     * stop/idle/neutral
     */

    public Command intake() {
        return runOnce(() -> {
            topMotor.set(.5);
            bottomMotor.set(.5);
        });
    }

    public Command outtake() {
        return runOnce(() -> {
            topMotor.set(-.5);
            bottomMotor.set(-.5);
        });
    }

    public Command stop() {
        return runOnce(() -> {
            topMotor.set(0);
            bottomMotor.set(0);
        });
    }
}
