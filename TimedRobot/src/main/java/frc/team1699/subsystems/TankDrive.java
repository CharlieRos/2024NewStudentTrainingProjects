package frc.team1699.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.XboxController;

public class TankDrive {
    private TalonFX rightMotor, leftMotor;
    
    public TankDrive() {
        rightMotor = new TalonFX(-1);
        leftMotor = new TalonFX(-1);
    }

    public void arcadeDrive(XboxController controller) {
        double xInput = controller.getLeftX();
        double yInput = controller.getRightX();

        double leftOutput, rightOutput;

        double maxInput = Math.copySign(Math.max(Math.abs(yInput), Math.abs(xInput)), yInput);

        if (yInput >= 0.0) {
            if (xInput >= 0.0) {
                leftOutput = maxInput;
                rightOutput = yInput - xInput;
            } else {
                leftOutput = yInput + xInput;
                rightOutput = maxInput;
            }
        } else {
            if (xInput >= 0.0) {
                leftOutput = yInput + xInput;
                rightOutput = maxInput;
            } else {
                leftOutput = maxInput;
                rightOutput = yInput - xInput;
            }
        }

        leftMotor.set(leftOutput);
        rightMotor.set(rightOutput);
    }
}
