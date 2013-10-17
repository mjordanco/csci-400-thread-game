
public class HumanPlayer extends Player {

	public HumanPlayer(GraphicsPanel g) {
		super(g);
	}

	@Override
	public void initLocation() {
		location = new Location(0, 0);
	}
	
	@Override
	protected void handleMovement() {
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
		default:
			break;
		}
		
		
		synchronized (graphics) {
			if (isMovementValid(movementArray[0], movementArray[1])) {
				location.move(movementArray[0], movementArray[1]);
			}
			if (graphics.checkForPoint(location)) {
				points++;
			}
		}
		
	}
	
}
