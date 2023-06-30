import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.Timer;

public class Model { 
    // Hold our data, canvas calls us for latest when redraws
	private ArrayList<Ship> ships;
	private int numOfCalls;
	private int zoomMagnitude;

	protected int gamePoints;

	private Dimension size;

    public Model () {
		this.ships = new ArrayList<Ship>();
		numOfCalls = 0;
		zoomMagnitude = 0;
		gamePoints = 0;
    }

	public void drawAll(Graphics g, int frameNumber) {
		for (Ship s : ships) {
            s.drawShip(g, frameNumber,zoomMagnitude);
        }
	}

	public void addShip(String name, int length, int frameNumber) {
		int min = 5;
		int max = 400;
		int x = (int)Math.floor(Math.random()*(max-min+1)+min);
		int y = (int)Math.floor(Math.random()*(max-min+1)+min);
		int width = (int)Math.floor(Math.random()*(50-10+1)+10);
		if (name == "Battleship") {
			ShipBattleShip battleship = new ShipBattleShip(x,y,length,width);
			findSpace(battleship, name,length, frameNumber);
	}
		else if (name == "Submarine") {
			ShipSubmarine sub = new ShipSubmarine(x,y,length,width);
			findSpace(sub, name,length, frameNumber);
		}
	}

	public void findSpace(Ship ship, String name, int length, int frameNumber) {

		if (numOfCalls > 1000) {
			System.out.println("Couldn't find space!");
			numOfCalls = 0;
			return;
		}
		
		else if (intersectsAny(ship, frameNumber)) {
			numOfCalls++;
			addShip(name, length, frameNumber);
		}
		else {
			ships.add(ship);
			System.out.println ("Ship added!");
		}

	}

	public void zoom(String direction) {
		if (direction == "IN") {
			zoomMagnitude -= 5;
		}
		else if (direction == "OUT") {
			zoomMagnitude += 5;
		}
		else if (direction == "RESET") {
			zoomMagnitude = 0;
		}
	}

	public void toggleTimer(Timer timer) {
		if (timer.isRunning()) {
			timer.stop();
		}
		else {
			timer.start();
		}
	}

	public void speedUp(Main parent) {
		parent.frameNumberChange(true);
	}

	public void slowDown(Main parent) {
		parent.frameNumberChange(false);
	}

	public void addToListAt(Ship ship, int index) {
		ships.add(index, ship);
	}

	public void removeShip() {
		boolean removedship = false;
		for (Ship s : ships) {
            if (s.isSelected()) {
				ships.remove(s);
				System.out.println("Ship removed!");
				removedship = true;
				break;
			}
        }
		if (!removedship) {
			System.out.println("No ship selected!");
		}
	}

	public void clearSelection() {
		for (Ship s : ships) {
            s.setSelected(false);
        }
	}

	public void clearList() {
		ships.clear();
		System.out.println("All ships removed");
	}

	public int getSize() {
		return ships.size();
	}

	public boolean isEmpty() {
		return ships.isEmpty();
	}

	public void changeX(int value) {
		for (Ship s : ships) {
			s.changeX(value);
		}
	}

	public void changeY(int value) {
		for (Ship s : ships) {
			s.changeY(value);
		}
	}

	public void mousePress(MouseEvent event, int frameNumber) {
		for (Ship s : ships) {
			if (s.isClicked(event, frameNumber)) {
				clearSelection();
				s.setSelected(true);
				return;
			}
		}
	}

	public boolean intersectsAny(Ship ship, int frameNumber) {
		for (Ship s : ships) {
			if (ship.intersects(s, frameNumber)) {
				return true;

			}
        }
		return false;
	}

	public void addPoint() {
		gamePoints++;
	}

	public void substractPoint() {
		gamePoints--;
	}

}
