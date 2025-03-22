package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ElevatorSubsystem;


public class MoveToLevel extends Command {
    private final ElevatorSubsystem elevator;
    private final int targetLevel;


    public MoveToLevel(ElevatorSubsystem elevator, int targetLevel) {
        this.elevator = elevator;
        this.targetLevel = targetLevel;
        addRequirements(elevator);
    }


    @Override
    public void initialize() {
        elevator.moveToLevel(targetLevel);
    }

    @Override
    public void execute() {
        elevator.moveToLevel(targetLevel);

        // System.out.println(myDictionary);
        // System.out.println(leftSwitch.get());
    }


    @Override
    public boolean isFinished() {
        return false;
    }


    @Override
    public void end(boolean interrupted) {
        elevator.stop();

    }
}


