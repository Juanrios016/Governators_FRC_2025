// RobotBuilder Version: 6.1
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Command.

package frc.robot.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;

import java.util.HashMap;
import java.util.function.DoubleSupplier;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import frc.robot.subsystems.DrivingSubsytem;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class DrivingCommand extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private final DrivingSubsytem m_drivingSubsytem;
    private DoubleSupplier m_right;
    private DoubleSupplier m_left;
    private Double m_time;
    private Boolean enableAuto;
    private Boolean m_teleop;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS


    public DrivingCommand(DoubleSupplier right, DoubleSupplier left, DrivingSubsytem subsystem, Double driveDistance, Double my_speed, Boolean teleop) {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        m_right = right;
        m_left = left;
        enableAuto = true;
        m_teleop = teleop;

        if (m_right.getAsDouble() == m_left.getAsDouble()){
            m_time = driveDistance  /  my_speed;
        }
         else if (m_right.getAsDouble() > m_left.getAsDouble()) {
            m_time = driveDistance  /  my_speed;
        }
        else{
            m_time = driveDistance  /  my_speed;
        }
        
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

        m_drivingSubsytem = subsystem;
        addRequirements(m_drivingSubsytem); 

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    public DrivingCommand set_speed(DoubleSupplier right, DoubleSupplier left, DrivingSubsytem subsystem, Double driveDistance, Double my_speed, Boolean teleop) {
        // new DrivingCommand(()->-0.75,  ()->-0.75, drive, 3.66, 2.55, false) //going forward
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        DrivingCommand driver = new DrivingCommand(right, left, subsystem, driveDistance, my_speed, teleop);
        return driver;
    }
    

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {

        m_drivingSubsytem.drive(m_left.getAsDouble(), m_right.getAsDouble()*-1);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_drivingSubsytem.drive(0, 0);

    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        // we want this to return false in order to keep doing autonomous

        if (enableAuto) {
            // code has been set up to only work one time as we do not
            // want m_time to reset everytime the function is called
            m_time = m_time + Timer.getFPGATimestamp();
            enableAuto = false;
        }
        else if (m_teleop) {
            return false;
        }

        m_drivingSubsytem.printAmp();
        return Timer.getFPGATimestamp() >= m_time;
    }

    @Override
    public boolean runsWhenDisabled() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
        return false;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
    }

    public void resetAutonomousMode(){
        enableAuto = true;
    }
}
