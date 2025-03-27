package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.DrivingSubsytem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.PneumaticsSubsystem;

public class AutoRoutine extends SequentialCommandGroup {
 

    public AutoRoutine(DrivingSubsytem drive, ElevatorSubsystem elevator, PneumaticsSubsystem pneumaticsSubsystem) {

        /**
         * Motor Power | Speed
         * 0.5 -> 1.7
         * 1.0 -> 3.4
         * 0.75 -> 2.55
         * 
         */

        // final DrivingCommand driver; //going forward
        // driver =  new DrivingCommand(()->-0.0,  ()->-0.0, drive, 0.0, 0.0, false);
       addCommands(

            // autonomous starting from bottom wall being blue team
            // new DrivingCommand(()->-0.5, ()->-0.5, drive, 4.26, false) , 
            // new WaitCommand(2),
            // new DrivingCommand(()->0, ()->-0.5, drive, 0.98, false),  //turning right
            // new WaitCommand(2),
            // new DrivingCommand(()->-0.5, ()->-0.5, drive, 2.24, false) ,
            // new MoveToLevel(elevator, 3),
            // new WaitCommand(1),
            // new PneumaticsCommand(pneumaticsSubsystem)

            // autonomous starting from top wall being blue team
            new DrivingCommand(()->-0.5, ()->-0.5, drive, 1.78, false) ,
            new WaitCommand(2),
            new DrivingCommand(()->-0.5, ()->0, drive, 0.98, false),  //turning left
            new WaitCommand(2),
            new DrivingCommand(()->-0.5, ()->-0.5, drive, 2.24, false) , 
            new MoveToLevel(elevator, 3),
            new WaitCommand(1),
            new PneumaticsCommand(pneumaticsSubsystem)


            // -----------------------------------------------------------------------------

            // autonomous starting from bottom wall being red team
            // new DrivingCommand(()->-0.5, ()->-0.5, drive, 1.78, false) ,
            // new WaitCommand(2),
            // new DrivingCommand(()->-0.5, ()->0, drive, 0.98, false),  //turning left
            // new WaitCommand(2),
            // new DrivingCommand(()->-0.5, ()->-0.5, drive, 2.24, false) , 
            // new MoveToLevel(elevator, 3),
            // new WaitCommand(1),
            // new PneumaticsCommand(pneumaticsSubsystem)

            // autonomous starting from top wall being red team
            // new DrivingCommand(()->-0.5, ()->-0.5, drive, 4.26, false) , 
            // new WaitCommand(2),
            // new DrivingCommand(()->0, ()->-0.5, drive, 0.98, false),  //turning right
            // new WaitCommand(2),
            // new DrivingCommand(()->-0.5, ()->-0.5, drive, 2.24, false) ,
            // new MoveToLevel(elevator, 3),
            // new WaitCommand(1),
            // new PneumaticsCommand(pneumaticsSubsystem)


            // new DrivingCommand(()->-0.5, ()->0, drive, 0.98, false)  //turning left
       );
    }
}