package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.DrivingSubsytem;

public class AutoRoutine extends SequentialCommandGroup {
 

    public AutoRoutine(DrivingSubsytem drive) {

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
            new DrivingCommand(()->-.4,  ()->-0.4, drive, 4.16, false), //going forward
            new WaitCommand(5.0),
            new DrivingCommand(()->.4,  ()->0.4, drive, 4.16, false) //going forward
            // new WaitCommand(5.0),
            // new DrivingCommand(()->-.4,  ()->-0.4, drive, 3.0, 1.0, false, test), //going forward
            // //     driver.set_speed(()->0.75,  ()->0.75, drive, 0.3, 2.55, false),  //stopping
            // // new DrivingCommand(()->-0.0,  ()->0.0, drive, 2.55, 2.55, false, test),  //pausing
            //         new WaitCommand(5.0),
            //         new DrivingCommand(()->.4,  ()->0.4, drive, 3.0, 2.55, false, test)

    //    // driver.set_speed(()->0.0,  ()->-0.75, drive, 0.25, 2.55, false), 
    
            // new DrivingCommand(()->0,  ()->-0.5, drive, 1.5, 2.55, false, test)  //turning left
    //     // driver.set_speed(()-> 0.75,  ()->0.0, drive, 0.3, 2.55, false),  //stopping
    //     driver.set_speed(()->-0.0,  ()->0.0, drive, 2.55, 2.55, false)  //stopping for 1 sec
    //     // driver.set_speed(()->0.0,  ()->-0.75, drive, 0.25, 2.55, false),

        // driver.set_speed(()->-0.75,  ()->-0.75, drive, 1.0, 2.55, false),  //going forward
        // driver.set_speed(()->0.75,  ()->0.75, drive, 1.0, 2.55, false)  //going forward

        // driver.set_speed(()->0.5,  ()->0.5, drive, 0.1, false)



    //    new DrivingCommand(()->-0.75,  ()->-0.75, drive, 3.66, 2.55, false), //going forward
    //     new DrivingCommand(()->0.75,  ()->0.75, drive, 0.3, 2.55, false),  //stopping
    //     new DrivingCommand(()->-0.0,  ()->0.0, drive, 2.55, 2.55, false),  //pausing
    //     new DrivingCommand(()->0.0,  ()->-0.75, drive, 0.25, 2.55, false),
    
    //     new DrivingCommand(()->-0.75,  ()->-0.0, drive, 1.5, 2.55, false),  //turning left
    //     // new DrivingCommand(()-> 0.75,  ()->0.0, drive, 0.3, 2.55, false),  //stopping
    //     new DrivingCommand(()->-0.0,  ()->0.0, drive, 2.55, 2.55, false),  //stopping for 1 sec
    //     // new DrivingCommand(()->0.0,  ()->-0.75, drive, 0.25, 2.55, false),

    //     new DrivingCommand(()->-0.75,  ()->-0.75, drive, 1.0, 2.55, false),  //going forward
    //     new DrivingCommand(()->0.75,  ()->0.75, drive, 1.0, 2.55, false)  //going forward

        // new DrivingCommand(()->0.5,  ()->0.5, drive, 0.1, false),
       );

    
       

    }
}