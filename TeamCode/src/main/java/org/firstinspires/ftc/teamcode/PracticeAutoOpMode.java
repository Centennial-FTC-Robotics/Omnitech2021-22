package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;

import java.util.List;

import omnitech.OurRobot;

@Autonomous
public class PracticeAutoOpMode extends LinearOpMode {

    private OurRobot robot;
    private TFObjectDetector tfod;

    @Override
    public void runOpMode() {

        telemetry.addData("State", "Initializing...");
        telemetry.update();

        robot = new OurRobot();
        robot.initialize(this);

        telemetry.addData("State", "Ready to start...");
        telemetry.update();

        ElapsedTime timer = new ElapsedTime();

        tfod = robot.camera.getTfod();

        waitForStart();

        timer.reset();

        double target = 90.0;
        double lastError = -1*(target - robot.imu.getHeading());
        double lastTime = timer.milliseconds();
        while(opModeIsActive()) {
//            robot.imu.logVals();
//            telemetry.update();
//            double angle = robot.imu.getHeading();
//
//            double timeNow = timer.milliseconds();
//
//            double kp = 0.06; // 0.05 is kinda stable and 0.75 oscillates a decent amt2
//            double p = -1*kp*(target - angle);
//
//            double kd = 100;
//            double d = kd*(p-lastError)/(timeNow-lastTime);
//
//
//
//
//            double turnAmt = Range.clip(p+d, -1.0, 1.0);
//
//            robot.drivetrain.povDrive(0.0, turnAmt);
//
//            lastError = p;
//            lastTime = timeNow;

            robot.drivetrain.rotate(90);
        }
    }
}
