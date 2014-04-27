package com.rea.code;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RobotSimulator {
	private enum Command{
		PLACE, MOVE, LEFT, RIGHT, REPORT, EXIT;
	}
	
	/**
	 * @param args
	 */
	public static void main (String args[]){
		Robot robo = new Robot();

		System.out.println("Starting Robot Simulator Console ...");
		
		System.out.println("Valid Commands:\r\n" +
				"\tPLACE <X,Y,DIRECTION> - To place the robot on the 5x5 table.\r\n" +
				"\t                        X and Y must be between 0 and 4.\r\n" +
				"\t                        DIRECTION must be one of EAST, WEST, NORTH, SOUTH.\r\n" +
				"\t                        Default starting point is 0,0,NORTH.\r\n" +
				"\tMOVE                  - To move the Robot 1 step in the current direction.\r\n" +
				"\tLEFT                  - To turn the Robot to its left.\r\n" +
				"\tRIGHT                 - To turn the Robot to its right.\r\n" +
				"\tREPORT                - To display Robot's current location and direction.\r\n" +
				"\tEXIT                  - To exit the simulator.\r\n\r\n");

		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter command to proceed: ");
		String input = "";
		do{
			System.out.print("> ");
			input = scanner.nextLine();
			try{
			List<String> command = Arrays.asList(input.split(" "));
			Command cmd = Command.valueOf(command.get(0).toUpperCase());
			switch (cmd){
				case PLACE:
					List<String> inputParam = Arrays.asList(command.get(1).split(","));
					robo.place(Integer.parseInt(inputParam.get(0)),Integer.parseInt(inputParam.get(1)),inputParam.get(2));
					break;
				
				case MOVE:
					if(robo==null || !robo.isPlaced()){
						System.out.println("Robot is not yet placed on the table. Use the PLACE X,Y,DIRECTION command to place the Robot on the table.");
					}else{
						robo.move();
					}
					break;
					
				case LEFT:
					if(robo==null || !robo.isPlaced()){
						System.out.println("Robot is not yet placed on the table. Use the PLACE X,Y,DIRECTION command to place the Robot on the table.");
					}else{
						robo.changeDirection("LEFT");
					}
					break;
				
				case RIGHT:
					if(robo==null || !robo.isPlaced()){
						System.out.println("Robot is not yet placed on the table. Use the PLACE X,Y,DIRECTION command to place the Robot on the table.");
					}else{
						robo.changeDirection("RIGHT");
					}
					break;
				 
				case REPORT:
					if(robo==null || !robo.isPlaced()){
						System.out.println("Robot is not yet placed on the table. Use the PLACE X,Y,DIRECTION command to place the Robot on the table.");
					}else{
						System.out.println(robo.getLocation());
					}
					break;
					

			}
			}catch(IllegalArgumentException e){
				System.out.println("Invalid input. Please try again with a valid command.");
			}
		}while(!input.toUpperCase().equals("EXIT"));
		
		
		
	}
}
