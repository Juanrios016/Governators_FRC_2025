package frc.robot.subsystems;


import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;


public class ElevatorSubsystem extends SubsystemBase {
    private final SparkMax motor;
    // private final DigitalInput limitSwitch;
    private final Stack<Integer> heightStack;


    private final double powerUp = -0.5;
    private final double powerDown = 0.5;


    private boolean previousState;
    private boolean switchLimit;
    private boolean newState;


    private int currLevel;
    private boolean checkpointReached;
    Map<String, Boolean> myDictionary;

    private final DigitalInput leftSwitch = new DigitalInput(0);
    private final DigitalInput rightSwitch = new DigitalInput(1);



    public ElevatorSubsystem() {
        motor = new SparkMax(6, MotorType.kBrushed);
        // limitSwitch = new DigitalInput(0);
        heightStack = new Stack<>();

        myDictionary = new HashMap<>();
        myDictionary.put("L1", false);
        myDictionary.put("L2", false);
        myDictionary.put("L3", false);
    }


    public void moveToL1() {
        if (leftSwitch.get() && rightSwitch.get()) {
            motor.set(-0.5);
        } 

        if (leftSwitch.get() == false){
            motor.set(0.0);
            myDictionary.put("L1", true);

        }



    }

    public void moveToL2() {
        if (!leftSwitch.get() && rightSwitch.get() || leftSwitch.get() && rightSwitch.get()) {
            motor.set(-0.5);
        } 
        // else if(myDictionary.get("L1") == false && myDictionary.get("L2") == false){
        //     motor.set(powerUp);

        // }

        else if (rightSwitch.get() == false  || myDictionary.get("L2") == true){
            motor.set(0.0);
            myDictionary.put("L2", true);
            myDictionary.put("L1", true);
        }


        // System.out.println(leftSwitch.get());





    }

    public void moveToL3() {
        if (leftSwitch.get() == true && rightSwitch.get() == false && myDictionary.get("L3") == false || leftSwitch.get() == true && rightSwitch.get() == true ) {
            motor.set(-0.5);
            System.out.println("entrooooooooo");

        } 

        // else if(myDictionary.get("L1") == false && myDictionary.get("L2") == false && myDictionary.get("L3") ==  false){
        //     motor.set(powerUp);
        //     System.out.println("SIUUUUUUUU");

        // }

        else if (leftSwitch.get() == false  || myDictionary.get("L3")){
            motor.set(0.0);
            myDictionary.put("L3", true);
            myDictionary.put("L2", true);
            myDictionary.put("L1", true);

        }






    }

    public void setL1True(){
        myDictionary.put("L1", true);
    }

    public void setL2True(){
        myDictionary.put("L2", true);
    }

    public void setL3True(){
        myDictionary.put("L3", true);
    }

    public void moveToLevel(int level){
        if (level == 1) moveToL1();
        else if (level == 2) moveToL2();
        else if (level == 3) moveToL3();

        else if (level == 0) moveDown();
        else if (level == 4) setL1True();
        else if (level == 5) setL2True();
        else if (level == 6) setL3True();



    }

    public void moveDown() {
        motor.set(0.4);
    }

    @Override
    public void periodic() {

        System.out.println(myDictionary);
        // System.out.println(leftSwitch.get());
    }


    public void stop() {
        // TODO Auto-generated method stub
        motor.set(0);
    }
}




