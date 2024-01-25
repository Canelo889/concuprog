package Pattern.Compound.Pilot.realSubject;

import Pattern.Compound.Pilot.Pilot;
import Pattern.Compound.Pilot.Plane;
import Pattern.Compound.Pilot.command.LandingCommand;
import Pattern.Compound.Pilot.command.StartAutoPilotCommand;
import Pattern.Compound.Pilot.command.TakeoffCommand;
import Pattern.Compound.Pilot.invoker.Cabin;
import Pattern.Compound.Pilot.subject.Controller;

public class FullController implements Controller {

	public FullController(Plane plane) {
		this.cabin = new Cabin();
		cabin.setCommand(0, new TakeoffCommand(plane));
		cabin.setCommand(1, new LandingCommand(plane));
		cabin.setCommand(2, new StartAutoPilotCommand(plane));
	}

	@Override
	public void takeOff(Pilot pilot) {
		cabin.pushKey(0);
	}

	@Override
	public void landing(Pilot pilot) {
		cabin.pushKey(1);
	}

	@Override
	public void startAutoPilot(Pilot pilot) {
		cabin.pushKey(2);
	}

	private Cabin cabin;

}
