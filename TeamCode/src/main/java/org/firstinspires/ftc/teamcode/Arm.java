package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.controller.PIDController;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Arm {
    private static final double ticksPerDegree = 537.7 / 360;
    private static final double starPos = 0;
    private static final double highPos = 15;
    private static final double armMechanicalPos = 0;
    private static DcMotor arm;

    private static PIDController controller;

    private static final double p = 0;
    private static final double i = 0;
    private static final double d = 0;
    private static final double f = 0;

    public static void init(HardwareMap hardwareMap) {
        arm = hardwareMap.get(DcMotor.class, "arm");

        arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        moveDown();

        controller = new PIDController(p ,i ,d);
    }

    public static void PID() {

    }

    private static void moveArm(double degree) {
        int ticks = (int) (degree * ticksPerDegree);

        arm.setTargetPosition(ticks);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        arm.setPower(0.3);
    }

    public static void moveUp() {
        moveArm(starPos);
    }

    public static void moveDown() {
        double tagetPos = highPos - armMechanicalPos;
        moveArm(tagetPos);
    }

    private static int getPos() {
        return (int) (arm.getCurrentPosition() / ticksPerDegree);
    }

    public static void telemetryArm(Telemetry telemetry) {
        telemetry.addData("Current pos: ", getPos());
        telemetry.addData("Target pos: ", arm.getTargetPosition() / ticksPerDegree);
        telemetry.addData("Current power: ", arm.getPower());
        telemetry.update();
    }
}
