import java.util.Random;


public class ComputerPlayer extends Player {

	public ComputerPlayer(GraphicsPanel g) {
		super(g);
	}

	@Override
	public void initLocation() {
		Random rand = new Random();

		location = new Location(rand.nextInt(GraphicsPanel.MAX_X), rand.nextInt(GraphicsPanel.MAX_Y));
	}

	@Override
	protected void handleMovement() {
		Random rand = new Random();
		int dx = 0;
		int dy = 0;
		do {
			int movement = rand.nextInt(4);
			switch (movement) {
			case 0:
				dx = 1;
				break;
			case 1:
				dx = -1;
				break;
			case 2:
				dy = 1;
				break;
			case 3:
				dy = -1;
				break;
			default:
				break;
			}
			
		} while (!isMovementValid(dx, dy));
		
		location.move(dx, dy);
		
		if (graphics.checkForPoint(location)) {
			points++;
		}
		
		
	}
	
	

}
