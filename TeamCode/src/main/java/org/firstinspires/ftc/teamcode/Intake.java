package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    private DcMotor intake;
    private CRServo rightShurikan;
    private CRServo leftShurikan;

    public void init(HardwareMap hardwareMap) {
        intake = hardwareMap.get(DcMotor.class, "intake");
        leftShurikan = hardwareMap.get(CRServo.class, "leftShurikan");
        rightShurikan = hardwareMap.get(CRServo.class, "rightShurikan");

        leftShurikan.setDirection(DcMotorSimple.Direction.REVERSE);
        intake.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void pumping() {
        intake.setPower(1);
        leftShurikan.setPower(1);
        rightShurikan.setPower(1);
    }

    public void emission() {
        intake.setPower(-1);
        leftShurikan.setPower(-1);
        rightShurikan.setPower(-1);
    }

    public void stop() {
        intake.setPower(0);
        leftShurikan.setPower(0);
        rightShurikan.setPower(0);
    }

    public void operation(Gamepad gamepad) {
        if (gamepad.cross) {
            pumping();
        } else if (gamepad.circle) {
            emission();
        } else {
            stop();
        }
    }
}
