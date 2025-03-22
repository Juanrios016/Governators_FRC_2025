package frc.robot.subsystems;


import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


import java.util.Stack;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;


public class ElevatorSubsystem extends SubsystemBase {
    private final SparkMax motor;
    private final DigitalInput limitSwitch;
    private final Stack<Integer> heightStack;


    private final double powerUp = -0.5;
    private final double powerDown = 0.5;


    private boolean previousState;
    private boolean switchLimit;
    private boolean newState;


    private int currLevel;
    private boolean checkpointReached;


    public ElevatorSubsystem() {
        motor = new SparkMax(6, MotorType.kBrushed);
        limitSwitch = new DigitalInput(0);
        heightStack = new Stack<>();


        switchLimit = limitSwitch.get();
        previousState = true;
        newState = false;
        currLevel = 0;
        checkpointReached = false;
    }


    public void setSwitchLimitVal(boolean val) {
        switchLimit = val;
    }


    public void setLevel(int level) {
        currLevel = level;
    }


    public void moveUp() {
        motor.set(powerUp);
    }

    public void moveDown() {
        motor.set(powerDown);
    }


    public void stop() {
        motor.set(0);
    }


    public boolean isAtCheckpoint() {
        return checkpointReached;
    }


    public void resetCheckpointFlag() {
        checkpointReached = false;
    }


    public void checkpoint() {
        switchLimit = !limitSwitch.get();  // Update to current state


        if (heightStack.isEmpty() || heightStack.peek() != currLevel) {
            moveUp(); // start moving


            if (switchLimit == previousState) {
                previousState = !previousState;
            } else if (switchLimit == newState) {
                System.out.println("SIUUUUUUU");
            } else if (switchLimit == previousState == newState) {
                heightStack.push(currLevel);
                previousState = !previousState;
                checkpointReached = true;
                stop();
            }
        }
    }
    public void moveToLevel(int level) {
        setSwitchLimitVal(!limitSwitch.get());
        setLevel(level);
        checkpointReached = false;
    }


    @Override
    public void periodic() {
        checkpoint();
    }
}

