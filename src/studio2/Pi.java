package studio2;

public class Pi {

	public static void main(String[] args) {
		//Ratio of points outside the circle vs inside the circle is 0.25pi
		double x;
		double y;
		int numTrials = 100000000;
		int numInside = 0;
		int numOutside = 0;
		double distance;
		
		while (numTrials != 0) {
			x = Math.random();
			y = Math.random();
			
			distance = Math.sqrt(Math.pow(0.49 - x,2) + Math.pow(0.49 - y, 2));
			
			
			//System.out.println("x: " + x);
			//System.out.println("y: " + y);
			
			if (distance < 0.5) {
				numInside++;
				//System.out.println("Inside");
			}
			else {
				numOutside++;
				//System.out.println("Outside");
			}
			
			numTrials--;
		}
		
		double ratio = numOutside / (double) numInside;
		double pi =  4 * ratio;
		System.out.println(pi);
		
	}

}
