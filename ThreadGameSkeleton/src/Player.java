import java.awt.Point;


public abstract class Player implements Runnable{

	public static final int MOVE_DELAY = (int)(300); // 1 FPS
	
	protected GraphicsPanel graphics;
	
	protected Location location;
	protected int points;
	protected char direction;
	
	private boolean running;
	private Thread thread;
	
	public Player(GraphicsPanel g) {
		initLocation();
		initThread();
		graphics = g;
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

	protected abstract void handleMovement();
	
	public Boolean isMovementValid(int dx, int dy) {
		Location potential = new Location(location.getX() + dx, location.getY() + dy);
		return !graphics.isBlocked(potential, false);
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
