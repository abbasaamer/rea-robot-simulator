package com.rea.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.rea.code.Robot;

public class RobotTest {

	Robot robo = null;
	@Before
	public void setUp() throws Exception {
		robo = new Robot();
		assertNotNull(robo);
	}

	@Test
	public void testPlace() {
		robo.place(0,0,"NORTH");
		assertTrue(robo.isPlaced());
		assertEquals("Location: 0,0,NORTH", robo.getLocation());
	}

	@Test
	public void testGetLocation() {
		robo.place(0,0,"NORTH");
		assertTrue(robo.isPlaced());
		robo.move();
		assertEquals("Location: 0,1,NORTH", robo.getLocation());
	}

	@Test
	public void testChangeDirection() {
		robo.place(0,0,"NORTH");
		assertTrue(robo.isPlaced());
		robo.changeDirection("RIGHT");
		assertEquals("Location: 0,0,EAST", robo.getLocation());
	}

	@Test
	public void testMove() {
		robo.place(0,0,"NORTH");
		assertTrue(robo.isPlaced());
		robo.move();
		robo.move();
		assertEquals("Location: 0,2,NORTH", robo.getLocation());
	}

}
