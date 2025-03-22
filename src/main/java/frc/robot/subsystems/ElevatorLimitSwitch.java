package frc.robot.subsystems;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class ElevatorLimitSwitch extends SubsystemBase {
    private final SparkMax motor = new SparkMax(6, MotorType.kBrushed);
    private final DigitalInput topSwitch = new DigitalInput(0);
    private boolean checkpoint = true;
    private double powerUp = -0.4;
    private double powerDown = 0.4;
    private Boolean checkStatus = true;

    private Map<String, Boolean> checkpointStates = new HashMap<>();
    
    public ElevatorLimitSwitch() {
        checkpointStates.put("L1", false);
        checkpointStates.put("L2", false);
        checkpointStates.put("L3", false);
    }

    public void moveElevator() {


        


    }


    public void moveToL1() {
        motor.set(powerUp);
        if (!checkpointStates.get("L1") && !topSwitch.get() && checkStatus) {
                changeKeyVal("L1", true);
                motor.set(0);
                checkStatus = false;
            }
    }

    public void moveToL2() {
        motor.set(powerUp);

        new WaitCommand(1.5);
        checkStatus = true;

        if (!checkpointStates.get("L2") && !topSwitch.get() && checkStatus) {
                changeKeyVal("L2", true);
                motor.set(0);
        }
    }

    public void moveToL3() {
        motor.set(powerUp);

        new WaitCommand(1.5);
        checkStatus = true;

        if (!checkpointStates.get("L3") && !topSwitch.get() && checkStatus) {
                changeKeyVal("L3", true);
                motor.set(0);
        }
    }

    // public void moveToL2() {
    //     if (!checkpointStates.get("L1") && checkpointStates.get("L2") && checkpointStates.get("L3")) {
    //         motor.set(powerUp);
    //         checkStatus = false;
            
    //         new WaitCommand(2000);

    //         checkStatus = true;

    //         if (!topSwitch.get()) {
    //             changeKeyVal("L2", false);
    //             motor.set(0);

    //         }
    //     }
    // }

    // public void moveToL3() {
    //     if (!checkpointStates.get("L1") && !checkpointStates.get("L2") && checkpointStates.get("L3")) {
    //         if (!topSwitch.get()) {
    //             changeKeyVal("L3", false);
    //         }
    //     }
    // }

    private void changeKeyVal(String key, Boolean val) {
        checkpointStates.put(key, val);
    }

    public void moveDown() {
        motor.set(0.4);
    }

    @Override
    public void periodic() {
        System.out.println("Top: " + checkpoint);

        if (!topSwitch.get() && checkStatus){
            motor.set(0);
            checkpoint = false;
        }
    }
}
