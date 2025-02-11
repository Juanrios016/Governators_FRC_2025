package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.DrivingCommand;
import frc.robot.subsystems.DrivingSubsytem;

public class AutoRoutine extends SequentialCommandGroup {
    public AutoRoutine(DrivingSubsytem drive) {
        addCommands(
            new DrivingCommand(()-> 1, ()-> 1, drive, Timer.getFPGATimestamp(), 10.0), // Move forward 3 meters
            new WaitCommand(5), // Pause for stability
            new DrivingCommand(()-> 0.5, ()-> 0.5, drive, Timer.getFPGATimestamp(), 5.0)
        );
    }
}