package frc.team1699.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
    /*
     * two talonfx's (top and bottom)
     * command to set speed which sets the speeds of the shooter to a parameter, which is a double from -1 to 1
     * command to stop which sets the speeds to 0
     */
    private TalonFX topMotor, bottomMotor;

    public Shooter() {
        topMotor = new TalonFX(-1);
        bottomMotor = new TalonFX(-1);
    }

    public Command shoot(double speed) {
        return run(() -> {
            topMotor.set(speed);
            bottomMotor.set(speed);
        });
    }

    public Command stop() {
        return run(() -> {
            topMotor.set(0);
            bottomMotor.set(0);
        });
    }
}
