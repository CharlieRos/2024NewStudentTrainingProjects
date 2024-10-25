package frc.team1699.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TankDrive extends SubsystemBase {
    private TalonFX leftMotor, rightMotor;
    public TankDrive() {
        leftMotor = new TalonFX(-1);
        rightMotor = new TalonFX(-1);
        
    }
    
    public Command arcadeDrive(double yInput, double xInput) {
        return run(() -> {
            
        });
    }
}
