package Pattern.Compound.Pilot.command;

import Pattern.Compound.Pilot.Plane;

public class LandingCommand implements Command {
	private Plane plane;

	public LandingCommand(Plane plane) {
		super();
		this.plane = plane;
	}

	@Override
	public void execute() {
		plane.landing();
	}

}
