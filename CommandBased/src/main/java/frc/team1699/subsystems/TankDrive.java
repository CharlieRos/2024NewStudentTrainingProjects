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
            double leftOutput = 0.0;
            double rightOutput = 0.0;

            double yInputSquared = Math.copySign(yInput * yInput, yInput);
            double xInputSquared = Math.copySign(xInput * xInput, xInput);

            double maxInput = Math.copySign(Math.max(Math.abs(yInputSquared), Math.abs(xInputSquared)), yInputSquared);

            if (yInputSquared >= 0.0) {
                if (xInputSquared >= 0.0) {
                    leftOutput = maxInput;
                    rightOutput = yInputSquared - xInputSquared;
                } else {
                    leftOutput = yInputSquared + xInputSquared;
                    rightOutput = maxInput;
                }
            } else {
                if (xInputSquared >= 0.0) {
                    leftOutput = yInputSquared + xInputSquared;
                    rightOutput = maxInput;
                } else {
                    leftOutput = maxInput;
                    rightOutput = yInputSquared - xInputSquared;
                }
            }

            leftMotor.set(leftOutput);
            rightMotor.set(rightOutput);
        });
    }
}
