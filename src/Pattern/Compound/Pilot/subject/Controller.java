package Pattern.Compound.Pilot.subject;

import Pattern.Compound.Pilot.Pilot;

public interface Controller {
	void takeOff(Pilot pilot);
	void landing(Pilot pilot);
	void startAutoPilot(Pilot pilot);
}
