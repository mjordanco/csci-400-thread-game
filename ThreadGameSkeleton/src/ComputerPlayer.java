import java.util.Random;


public class ComputerPlayer extends Player {

	public ComputerPlayer() {
		super();
	}

	@Override
	public void initLocation() {
		Random rand = new Random();
		
		location = new Location(rand.nextInt(GraphicsPanel.MAX_X), rand.nextInt(GraphicsPanel.MAX_Y));
	}

}
