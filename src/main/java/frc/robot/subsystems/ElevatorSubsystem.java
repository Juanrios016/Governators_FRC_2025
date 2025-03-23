package frc.robot.subsystems;


import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import java.util.HashMap;
import java.util.Map;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;


public class ElevatorSubsystem extends SubsystemBase {
    private final SparkMax motor;
    private final double powerUp = -0.5;
    private final double powerDown = 0.5;
    private Map<String, Boolean> myDictionary;
    private Map<String, Boolean> myDictionary2;
    private boolean controlManually = false;

    private final DigitalInput leftSwitch = new DigitalInput(0);
    private final DigitalInput rightSwitch = new DigitalInput(1);


    public ElevatorSubsystem() {
        motor = new SparkMax(6, MotorType.kBrushed);

        myDictionary = new HashMap<>();
        myDictionary.put("L1", false);
        myDictionary.put("L2", false);
        myDictionary.put("L3", false);

        myDictionary2 = new HashMap<>();
        myDictionary2.put("L1", false);
        myDictionary2.put("L2", false);
        myDictionary2.put("L3", false);
    }

    public Boolean moveToL1() {
        if (myDictionary.get("L1") == false && myDictionary2.get("L1") == false) {
            if (leftSwitch.get() && rightSwitch.get()) {
                motor.set(-0.5);
            } 
            if (leftSwitch.get() == false){
                motor.set(0.0);
                myDictionary.put("L1", true);
                return true;
            }
        }

        else if (myDictionary.get("L1") == true && myDictionary2.get("L1") == false) {

            if (leftSwitch.get() == false && myDictionary2.get("L3") == false) {
                myDictionary2.put("L3", true);
                motor.set(powerDown);
            }
            else if (rightSwitch.get() == false && myDictionary2.get("L2") == false) {
                myDictionary2.put("L2", true);
            }
            else if (leftSwitch.get() == false && myDictionary2.get("L2") == true) {
                motor.set(0);
                myDictionary2.put("L1", true);
                resetDown();
                return true;
            }
            else if (myDictionary.get("L1") == true && myDictionary2.get("L1") == false){
                motor.set(powerDown);
            }
        }
        return false;
    }

    public Boolean moveToL2() {

        if (myDictionary.get("L2") == false && myDictionary2.get("L2") == false) {
            if (!leftSwitch.get() && rightSwitch.get() || leftSwitch.get() && rightSwitch.get()) {
                motor.set(-0.5);
            } 
            else if (rightSwitch.get() == false  || myDictionary.get("L2") == true){
                motor.set(0.0);
                myDictionary.put("L2", true);
                myDictionary.put("L1", true);
                return true;
            }
        }
        else if (myDictionary.get("L2") == true && myDictionary2.get("L2") == false) {
            if (leftSwitch.get() == false && rightSwitch.get() == true) {
                myDictionary.put("L3", false);
                myDictionary2.put("L3", false);
                motor.set(powerDown);
            } 
            else if (rightSwitch.get() == false) {
                motor.set(0);
                myDictionary2.put("L2", true);
                return true;

            }
        }
        return false;
        
    }

    public Boolean moveToL3() {

        if (myDictionary.get("L3") == false) {
            
            if (!leftSwitch.get() && myDictionary.get("L1") == false || !leftSwitch.get() && myDictionary.get("L2") == false){
                myDictionary.put("L1", true);
                motor.set(powerUp);
            }
            else if ( !rightSwitch.get() ) {
                motor.set(powerUp);
                myDictionary.put("L2", true);
            }
            else if (leftSwitch.get() && rightSwitch.get()){
                motor.set(powerUp);
            }
            else if (!leftSwitch.get() && myDictionary.get("L2") == true ) {
                motor.set(0);
                myDictionary.put("L3", true);
                resetUp();
                return true;
            }
        }
        return false;
    }

    private void resetDown() {
        System.out.println("Reseting status");
            
        myDictionary.put("L2", false);
        myDictionary.put("L3", false);
        
        myDictionary2.put("L1", false);
        myDictionary2.put("L2", false);
        myDictionary2.put("L3", false);

    }

    private void resetUp() {
        System.out.println("Reseting status");
            
        myDictionary.put("L2", true);
        myDictionary.put("L3", true);
        
        myDictionary2.put("L1", false);
        myDictionary2.put("L2", false);
        myDictionary2.put("L3", false);

    }

    public Boolean moveToLevel(int level){
        boolean status = false;
        if (controlManually == false){
            if (level == 1) status = moveToL1();
            else if (level == 2) status = moveToL2();
            else if (level == 3)status =  moveToL3();
        }
        else{
            if (level == 1) status = moveDown();
            else if (level == 2) status = stop();
            else if (level == 3)status =  moveUp();
        }

        return status;
    }

    public void manualElevator() {
        controlManually = !controlManually;
    }

    public Boolean moveDown() {
        motor.set(powerDown);
        return false;
    }

    public Boolean moveUp() {
        motor.set(powerUp);
        return false;
    }

    public Boolean stop() {
        motor.set(0);
        return true;
    }


    @Override
    public void periodic() {

        // long currentTime = System.currentTimeMillis();
        // if (currentTime - lastPrintTime >= 1000) {
        //     System.out.println("Up Status: " + myDictionary);
        //     System.out.println("Down Status: " + myDictionary2);

        //     lastPrintTime = currentTime;
        // }

    }


}




