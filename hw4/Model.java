import java.util.*;

public class Model { 
    // Hold our data, canvas calls us for latest when redraws
	private ArrayList<Ship> ships;

    public Model () {
		this.ships = new ArrayList<Ship>();
    }

	public void addShip(String name) {
		int min = 10;
		int max = 200;
		int x = (int)Math.floor(Math.random()*(max-min+1)+min);
		int y = (int)Math.floor(Math.random()*(max-min+1)+min);
		int width = (int)Math.floor(Math.random()*(200-100+1)+100);
		int length = (int)Math.floor(Math.random()*(100-50+1)+50);
		if (name == "Battleship") {
			Battleship battleship = new Battleship(x,y,width,length);
			ships.add(battleship);
	}
		else {
			Submarine sub = new Submarine(x,y,width,length);
			ships.add(sub);
		}
	}

	public void addBattleship() {
		addShip("Battleship");
	}

	public void addSubmarine() {
		addShip("Submarine");
	}

	public void addToList(Ship ship) {
		ships.add(ship);
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

	public ArrayList<Ship> getList() {
		return ships;
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

	public void rotate() {
        for (Ship s : ships) {
			s.rotateShip();
		}
    }

}
