package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.DrivingSubsytem;

public class AutoRoutine extends SequentialCommandGroup {
    public AutoRoutine(DrivingSubsytem drive) {

        addCommands(
            new DrivingCommand(()-> 1, ()-> 1, drive, 5.0, false, 0.0), // Move forward 3 meters
            new WaitCommand(5), // Pause for stability
            new DrivingCommand(()-> 0.5, ()-> 0.5, drive, 5.0, false, 0.0)
        );

    }
}