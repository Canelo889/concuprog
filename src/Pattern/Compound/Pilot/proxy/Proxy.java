package Pattern.Compound.Pilot.proxy;

import Pattern.Compound.Pilot.Pilot;
import Pattern.Compound.Pilot.Plane;
import Pattern.Compound.Pilot.realSubject.FullController;
import Pattern.Compound.Pilot.subject.Controller;

public class Proxy implements Controller {

	@Override
	public void takeOff(Pilot pilot) {
		if (!pilot.isCopilot()) {
			fullController.takeOff(pilot);
		}
	}

	@Override
	public void landing(Pilot pilot) {
		if (!pilot.isCopilot()) {
			fullController.landing(pilot);
		}
	}

	@Override
	public void startAutoPilot(Pilot pilot) {
		fullController.startAutoPilot(pilot);
	}

	private FullController fullController;
	
	public Proxy(Plane plane) {
		this.fullController = new FullController(plane);
	}

}
