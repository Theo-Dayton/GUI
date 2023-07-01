import java.util.*;
import java.awt.*;

import javax.swing.Timer;

public class Model { 
    // Hold our data, canvas calls us for latest when redraws
	private ArrayList<Ship> ships;

    public Model () {
		this.ships = new ArrayList<Ship>();
    }

	public void drawAll(Graphics g, int frameNumber) {
		for (Ship s : ships) {
            s.paintComponent(g, frameNumber);
        }
	}

	public void addShipRand(String name, int length) {
		int min = 10;
		int max = 200;
		int x = (int)Math.floor(Math.random()*(max-min+1)+min);
		int y = (int)Math.floor(Math.random()*(max-min+1)+min);
		int width = (int)Math.floor(Math.random()*(50-10+1)+10);
		if (name == "Battleship") {
			ShipBattleShip battleship = new ShipBattleShip(x,y,length,width);
			ships.add(battleship);
	}
		else if (name == "Submarine") {
			ShipSubmarine sub = new ShipSubmarine(x,y,length,width);
			ships.add(sub);
		}
	}

	public void addShip(String name, int length) {
		addShipRand(name, length);
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

	public void removeLastShip() {
		if (!isEmpty()) {
			int index = ships.size() -1;
			ships.remove(index);
		}
	}

	public void clearList() {
		ships.clear();
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

}
