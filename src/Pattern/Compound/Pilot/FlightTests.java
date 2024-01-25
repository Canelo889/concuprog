package Pattern.Compound.Pilot;

import Pattern.Compound.Pilot.proxy.Proxy;
import Pattern.Compound.Pilot.subject.Controller;

public class FlightTests {
	public static void main(String[] args) {
		Pilot max = new Pilot(false);
		Pilot alex = new Pilot(true);

		Plane plane = new Plane("Airbus");
		
		Controller proxy = new Proxy(plane);
		
		proxy.takeOff(max);
		proxy.landing(max);
		proxy.startAutoPilot(max);
		
		proxy.takeOff(alex);
		proxy.landing(alex);
		proxy.startAutoPilot(alex);
	}
}
