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
		
		//first, try to grab a point
		for (int dx = -1; dx <= 1; dx++) {
			for (int dy = -1; dy <= 1; dy++) {
				Location potential = new Location(location.getX() + dx, location.getY() + dy);
				if (graphics.checkForPoint(potential)) {
					points++;
					location.move(dx, dy);
					return;
				}
			}
		}
		//then, make a random, legal move
		Random rand = new Random();
		int dx = 0;
		int dy = 0;
		int movement = rand.nextInt(4);
		for (int i = 0; i < 4; i++ ) {
			movement = (movement + 1) % 4;
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
			if (isMovementValid(dx, dy)) {
				location.move(dx, dy);
				break;
			}
		}
		
		
	}
	
	

}
