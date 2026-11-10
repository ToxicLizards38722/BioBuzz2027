package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class MainTeleop extends LinearOpMode {
    MecanumDrive mecanumDrive = new MecanumDrive();
    Intake intake = new Intake();

    @Override
    public void runOpMode() {
        mecanumDrive.init(hardwareMap);
        intake.init(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {
            mecanumDrive.drive(gamepad1);
            intake.operation(gamepad1);
        }
    }
}
