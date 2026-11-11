package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Shooter {
    private DcMotor shooter ;

    public void init(HardwareMap hardwareMap) {
        shooter = hardwareMap.get(DcMotor.class, "shooter");
    }

    public void start() {
        shooter.setPower(0.6);
    }

    public void stop() {
        shooter.setPower(0);
    }
}
