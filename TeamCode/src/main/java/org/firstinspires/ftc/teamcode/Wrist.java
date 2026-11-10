package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Wrist {
    private static final double down = 0;
    private static Servo wrist;
    private static boolean movedDown = false;
    private static boolean movedUp = false;


    public static void init(HardwareMap hardwareMap) {
        wrist = hardwareMap.get(Servo.class, "wrist");

        reset();

        movedDown = false;
        movedUp = false;
    }

    public static void reset() {
        wrist.setPosition(down);
    }

    public static void moveDown(boolean buttonPressed) {
        if (!buttonPressed) {
            movedDown = false;
        } else if (!movedDown) {
            wrist.setPosition(wrist.getPosition() - 0.01);
            movedDown = true;
        }
    }

    public static void moveUp(boolean buttonPressed) {
        if (!buttonPressed) {
            movedUp = false;
        } else if (!movedUp) {
            wrist.setPosition(wrist.getPosition() + 0.01);
            movedUp = true;
        }
    }

    public static void telemetryWrist(Telemetry telemetry) {
        telemetry.addData("Current pos: ", wrist.getPosition());
        telemetry.update();
    }
}
