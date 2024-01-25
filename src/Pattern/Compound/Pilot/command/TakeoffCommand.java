package Pattern.Compound.Pilot.command;

import Pattern.Compound.Pilot.Plane;

public class TakeoffCommand implements Command {
	private Plane plane;

	public TakeoffCommand(Plane plane) {
		super();
		this.plane = plane;
	}

	@Override
	public void execute() {
		plane.takeoff();
	}

}
