package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.PneumaticsSubsystem;


public class PneumaticsCommand extends Command {
    private final PneumaticsSubsystem pneumaticsSystem;


    public PneumaticsCommand(PneumaticsSubsystem pneumaticsSystem) {
        this.pneumaticsSystem = pneumaticsSystem;
        addRequirements(pneumaticsSystem);
    }


    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        // elevator.moveToLevel(targetLevel);

        // System.out.println(myDictionary);
        // System.out.println(leftSwitch.get());
        pneumaticsSystem.releaseCoral();
    }


    @Override
    public boolean isFinished() {
        return true;
    }


    @Override
    public void end(boolean interrupted) {

    }

    
}


