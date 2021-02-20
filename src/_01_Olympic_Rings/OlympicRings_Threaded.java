package _01_Olympic_Rings;

import java.awt.Color;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.
	
	public static void main(String[] args) {
		Robot red = new Robot();
		Robot blue = new Robot();
		Robot green = new Robot();
		Robot yellow = new Robot();
		Robot black = new Robot();
		red.setPenColor(Color.RED);
		blue.setPenColor(Color.BLUE);
		green.setPenColor(Color.GREEN);
		yellow.setPenColor(Color.YELLOW);
		black.setPenColor(Color.BLACK);
		blue.moveTo(100, 40);
		black.moveTo(230, 40);
		red.moveTo(360, 40);
		yellow.moveTo(165, 100);
		green.moveTo(295, 100);
		blue.hide();
		black.hide();
		red.hide();
		yellow.hide();
		green.hide();
		blue.penDown();
		black.penDown();
		red.penDown();
		yellow.penDown();
		green.penDown();
		blue.turn(90);
		black.turn(90);
		red.turn(90);
		yellow.turn(90);
		green.turn(90);
		Thread blueT = new Thread(()->{
			for(int i = 0; i < 360; i++) {
				blue.move(1);
				blue.turn(1);
			}
		});
		Thread blackT = new Thread(()->{
			for(int i = 0; i < 360; i++) {
				black.move(1);
				black.turn(1);
			}
		});
		Thread redT = new Thread(()->{
			for(int i = 0; i < 360; i++) {
				red.move(1);
				red.turn(1);
			}
		});
		Thread yellowT = new Thread(()->{
			for(int i = 0; i < 360; i++) {
				yellow.move(1);
				yellow.turn(1);
			}
		});
		Thread greenT = new Thread(()->{
			for(int i = 0; i < 360; i++) {
				green.move(1);
				green.turn(1);
			}
		});
		blueT.start();
		blackT.start();
		redT.start();
		yellowT.start();
		greenT.start();
	}
}

