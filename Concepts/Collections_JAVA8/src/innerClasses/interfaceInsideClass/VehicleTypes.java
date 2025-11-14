package innerClasses.interfaceInsideClass;

public class VehicleTypes {

	interface Vehicle{
		
		int noOfWheels();
		
	}
	
	class Bus implements Vehicle{

		@Override
		public int noOfWheels() {
			return 12;
		}
	}
	
	class Cycle implements Vehicle{

		@Override
		public int noOfWheels() {
			return 2;
		}
	}
	
	class Auto implements Vehicle{

		@Override
		public int noOfWheels() {
			return 3;
		}
	}
}
