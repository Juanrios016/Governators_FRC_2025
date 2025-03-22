package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.HashMap;
import java.util.Stack;


public class ElevatorSubsystemCopy extends SubsystemBase {
    private final SparkMax motor = new SparkMax(6, MotorType.kBrushed); // CAN ID 1
    private final DigitalInput limitSwitch = new DigitalInput(0); // Limit switch on DIO 0
    private final Stack<Integer> heightStack = new Stack<>(); // Stores height checkpoints
    private final double powerUp = -0.5;
    private final double powerDown = 0.5;

    private boolean previousState = true;
    private boolean switchLimit = limitSwitch.get();
    private boolean newState = false;

    private int currLevel = 0;


    public ElevatorSubsystemCopy() {
    }

    private void checkpoint() {
        if (heightStack.peek() != currLevel) {
            motor.set(powerUp);

            if (switchLimit == previousState){
                previousState = !previousState;
            }
            else if (switchLimit == newState) {
                System.out.println("SIUUUUUUU");;
            }
            else if (switchLimit == previousState == newState) {
                heightStack.push(currLevel);
                previousState = !previousState;
                motor.set(0);
                // return true;
            }
        }
        // return false;
    }

    private void setSwitchLimitVal(Boolean val){
        switchLimit = val;
    }

    private void setLevel(int level) {
        currLevel = level;
    }

    public void moveL1() {
       setSwitchLimitVal(!limitSwitch.get());
       setLevel(1);
    }

    // public void moveL2() {
    //     boolean Lswitch = !limitSwitch.get();
        
    //     if (heightStack.empty()){
    //         moveL1();
    //     }

    //     while (heightStack.peek() != 2) {
    //         motor.set(powerUp);

    //         if (Lswitch == previousState){
    //             previousState = !previousState;
    //         }
    //         else if (Lswitch == newState) {
    //             continue;
    //         }
    //         else if (Lswitch == previousState == newState) {
    //             heightStack.push(2);
    //             previousState = !previousState;
    //         }
    //     }
    // }

    // public void moveL3() {
    //     boolean Lswitch = !limitSwitch.get();
        
    //     if (heightStack.empty()){
    //         moveL1();
    //         moveL2();
    //     }

    //     while (heightStack.peek() != 2) {
    //         motor.set(powerUp);

    //         if (Lswitch == previousState){
    //             previousState = !previousState;
    //         }
    //         else if (Lswitch == newState) {
    //             continue;
    //         }
    //         if (Lswitch == previousState == newState) {
    //             heightStack.push(2);
    //             previousState = !previousState;
    //         }
    //     }
    // }

    
    // height to be use are level 1, 2, 3, 4



    // true if not pressed
    //flase if pressed

    @Override
    public void periodic() {
        checkpoint();

    }


}

