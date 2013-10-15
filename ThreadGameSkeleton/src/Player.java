import java.awt.Point;


public abstract class Player implements Runnable{

	public static final int MOVE_DELAY = (int)(1000); // 1 FPS
	
	protected Location location;
	protected int points;
	protected char direction;
	
	private boolean running;
	private Thread thread;
	
	public Player() {
		initLocation();
		initThread();
	}
	
	public void initThread() {
		thread = new Thread(this);
	}
	
	public abstract void initLocation();
	
	public void start() {
		running = true;
		thread.start();
	}
	
	public void stopPlaying() {
		running = false;
	}
	
	public final void run() {
		while(true) {
			if (!running) {
				break;
			}
			
			handleMovement();
			
			try {
				Thread.sleep(MOVE_DELAY);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void handleMovement() {
		int[] movementArray = new int[] {0, 0};
		switch(direction) {
		case 'L':
			movementArray[0] = -1;
			break;
		case 'U':
			movementArray[1] = -1;
			break;
		case 'R':
			movementArray[0] = 1;
			break;
		case 'D':
			movementArray[1] = 1;
			break;
		}

		int newX = location.getX() + movementArray[0];
		int newY = location.getY() + movementArray[0];
		
		location.setX(newX);
		location.setY(newY);
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}
	
}
