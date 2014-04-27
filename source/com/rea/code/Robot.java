package com.rea.code;

import java.util.Arrays;
import java.util.List;

/**
 * @author Aamer Abbas
 *
 */
public class Robot {

	int x;						//X coordinate of Robot's location
	int y;						//Y coordinate of Robot's location
	String face;				//Robot's direction
	boolean placed=false;		//Robot's status (placed or not)
	
	static int MIN_X = 0;		//Minimum X coordinate
	static int MAX_X = 4;		//Maximum X coordinate. Increase if you want to increase the size of table
	static int MIN_Y = 0;		//Minimum Y coordinate
	static int MAX_Y = 4;		//Maximum Y coordinate. Increase if you want to increase the size of table
	
	static List<String> direction = Arrays.asList("EAST", "WEST", "NORTH", "SOUTH"); //Valid directions for initial placement
	
	public Robot(){}
	
	/** 
	 * Place the Robot on the table.
	 * Valid location is within valid values of X and Y coordinates
	 * Valid face is one of valid directions
	 * 
	 * @param x - x coordinate of Robot's location
	 * @param y - y coordinate of Robot's location
	 * @param face - Robot's direction
	 * @return - true if Robot is successfully placed on the table
	 * @
	 */
	public boolean place(int x, int y, String face){
		
		if(x < MIN_X || x > MAX_X || y < MIN_Y || y > MAX_Y){
			System.out.println("Invalid location to place the Robot");
			return false;
		}else{
			if(direction.contains(face.toUpperCase())){
				this.face = face.toUpperCase();
				this.x = x;
				this.y = y;
				this.setPlaced(true);
			}else{
				System.out.println("Invalid direction. Valid directions are "+direction.toString());
				return false;
			}
			return true;
		}
	}
		
	/**
	 * @return - Report Robot's current location
	 */	
	public String getLocation(){
		return "Location: "+this.x+","+this.y+","+this.face;
	}
	
	/** 
	 * Turn the Robot to RIGHT or LEFT
	 * and update the Direction
	 * 
	 * @param command - RIGHT or LEFT
	 * */
	public void changeDirection(String command){
		if(command.toUpperCase().equals("LEFT") || command.toUpperCase().equals("RIGHT")){
			if(this.face.toUpperCase().equals("NORTH") && command.toUpperCase().equals("LEFT")){
				this.face = "WEST";
			}else if(this.face.toUpperCase().equals("NORTH") && command.toUpperCase().equals("RIGHT")){
				this.face = "EAST";
			}else if(this.face.toUpperCase().equals("WEST") && command.toUpperCase().equals("LEFT")){
				this.face = "SOUTH";
			}else if(this.face.toUpperCase().equals("WEST") && command.toUpperCase().equals("RIGHT")){
				this.face = "NORTH";
			}else if(this.face.toUpperCase().equals("EAST") && command.toUpperCase().equals("LEFT")){
				this.face = "NORTH";
			}else if(this.face.toUpperCase().equals("EAST") && command.toUpperCase().equals("RIGHT")){
				this.face = "SOUTH";
			}else if(this.face.toUpperCase().equals("SOUTH") && command.toUpperCase().equals("LEFT")){
				this.face = "EAST";
			}else if(this.face.toUpperCase().equals("SOUTH") && command.toUpperCase().equals("RIGHT")){
				this.face = "WEST";
			}
		}else{
			System.out.println("Invalid direction command. Valid commands are RIGHT & LEFT. Please try again.");
		}
	}
	
	/** 
	 * Move the Robot one step forward in the current direction
	 * and set the X and Y coordinates
	 *  
	 * */
	public void move(){
		if(this.face.toUpperCase().equals("EAST")){
			if(this.x == 4){
				System.out.println("Invalid move. Robot will fall down from the table.");
			}else{
				this.x++;
			}
		}
		if(this.face.toUpperCase().equals("WEST")){
			if(this.x == 0){
				System.out.println("Invalid move. Robot will fall down from the table.");
			}else{
				this.x--;
			}
		}
		if(this.face.toUpperCase().equals("NORTH")){
			if(this.y == 4){
				System.out.println("Invalid move. Robot will fall down from the table.");
			}else{
				this.y++;
			}
		}
		if(this.face.toUpperCase().equals("SOUTH")){
			if(this.y == 0){
				System.out.println("Invalid move. Robot will fall down from the table.");
			}else{
				this.y--;
			}
		}
	}
	
	public boolean isPlaced() {
		return placed;
	}

	public void setPlaced(boolean placed) {
		this.placed = placed;
	}
}
