//Krishna Sindhuri Vemuri G01024066 SWE_645_HW4
//This is the StudentService class
package SWE645_VEMURI_HW4;

import java.io.Serializable;


public class StudentService implements Serializable {


	private static final long serialVersionUID = 1L;


	public double calculateMean(Student student) {
		String raffle[] = (student.getRaffle()).split(",");

		int mean = 0;

		int i;
		for (i = 0; i < raffle.length; i++) {
			int sum = Integer.parseInt(raffle[i]);
			mean += sum;
		}

		return mean / i;

	}


	public double calculateStandardDeviation(Student student) {
		String raffle[] = (student.getRaffle()).split(",");
		int raffleData[] = new int[20];
		int i = 0;
		int sum = 0;
		double deviation;
		for (String string : raffle) {
			raffleData[i] = Integer.parseInt(string);
			i++;
		}

		double mean = calculateMean(student);
		for (int j = 0; j < raffle.length; j++) {
			sum += Math.pow((raffleData[j] - mean), 2);

		}
		deviation = Math.pow(sum / (raffle.length - 1), 1 / 2);

		return deviation;
	}

}