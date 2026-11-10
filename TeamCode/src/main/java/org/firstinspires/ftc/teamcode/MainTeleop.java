package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class MainTeleop extends LinearOpMode {

    @Override
    public void runOpMode() {
        MecanumDrive.init(hardwareMap);

        CRServo rightServo = hardwareMap.get(CRServo.class, "rightServo");
        CRServo leftServo = hardwareMap.get(CRServo.class, "leftServo");
        DcMotor Motor5 = hardwareMap.get(DcMotor.class, "Motor5");

        leftServo.setDirection(DcMotorSimple.Direction.REVERSE);
        Motor5.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


        waitForStart();

        while (opModeIsActive()) {
            MecanumDrive.drive(gamepad1);

            if (gamepad1.circle) {
                rightServo.setPower(1);
                leftServo.setPower(1);
                Motor5.setPower(0.7);
            } else if (gamepad1.cross) {
                rightServo.setPower(-1);
                leftServo.setPower(-1);
                Motor5.setPower(-0.7);
            } else {
                rightServo.setPower(0);
                leftServo.setPower(0);
                Motor5.setPower(0);
            }
        }
    }
}
