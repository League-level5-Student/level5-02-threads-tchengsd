package _02_Advanced_Robot_Race;

import java.util.Random;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	// Re-do the robot race recipe from level 3 module 0. 
	// This time, use threads to make all of the robots go at the same time.
	// 1. make a main method
	Thread[] threads;
	public static int nextPosition;
	public static boolean robotReachedTop;
	static final int numberRobots = 5;
	AdvancedRobotRace() {
		threads = new Thread[numberRobots];
		for(int i = 0; i < threads.length; i++) {
			long seed = Math.abs(new Random().nextLong());
			threads[i] = new Thread(new RunnableRobot(seed));
		}
	}
	public static void main(String[] args) {
		AdvancedRobotRace race = new AdvancedRobotRace();
		race.begin();
	}
	void begin() {
		for(int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
	}
}

class RunnableRobot implements Runnable {
	Robot rob;
	int position;
	Random rand;
	
	RunnableRobot(long seed) {
		position = AdvancedRobotRace.nextPosition;
		rob = new Robot(100 + position * 100, 750);
		AdvancedRobotRace.nextPosition++;
		rand = new Random(seed);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!AdvancedRobotRace.robotReachedTop) {
			rob.move(rand.nextInt(50));
			if(rob.getY() <=50 ) {
				if(!AdvancedRobotRace.robotReachedTop) {
					AdvancedRobotRace.robotReachedTop = true;
					System.out.println("Robot " + position +  " won");
					rob.sparkle();
				}
			}
		}
	}

}