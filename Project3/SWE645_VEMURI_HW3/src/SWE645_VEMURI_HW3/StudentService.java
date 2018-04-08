//Krishna Sindhuri Vemuri G01024066 SWE_645_HW3
//This is the StudentService java class.
package SWE645_VEMURI_HW3;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

@ManagedBean(name = "studentserviceBean")
public class StudentService implements Serializable {

		private ArrayList<HashMap<String, String>> surveys;

		private static final long serialVersionUID = 1L;
		Writer writer;
		double mean = 0;
		double deviation = 0;
		double standardDeviation = 0;
		private String obj;
		@ManagedProperty(value = "#{studentBean}")
		private StudentBean student = new StudentBean();
		@ManagedProperty(value = "#{winningresultBean}")
		private WinningResultBean winningresult;
		
		public StudentBean getStudent() {
			return student;
		}
		public void setStudent(StudentBean student) {
			this.student = student;
		}
		public WinningResultBean getWinningresult() {
			return winningresult;
		}
		public void setWinningresult(WinningResultBean winningresult) {
			this.winningresult = winningresult;
		}
		public String showSubmit() throws IOException{
			if(student.getDos1().compareTo(student.getDos()) < 0)
			{			
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage("surveyForm:dateOfStart", new FacesMessage("Date of start cannot be less than the survey date."));
				return null;
			}
			int i;
			String[] values = student.getRaffle().split(",");
			if(!((values.length)==10)) {
				FacesContext context1 = FacesContext.getCurrentInstance();
				context1.addMessage("surveyForm:Raffle", new FacesMessage("You must enter atleast 10 values"));
				return null;
			}
			for(i=0;i<10;i++) {
				if(Integer.parseInt(values[i]) < 1 || Integer.parseInt(values[i]) > 100) {
					FacesContext context2 = FacesContext.getCurrentInstance();
					context2.addMessage("surveyForm:Raffle", new FacesMessage("You must enter values in range 1 to 100"));
					return null;			
				}
			}
			Datacheckraffle();
			try {
				FileInput();
			}catch(IOException e) {
				e.printStackTrace();
			}
			if(winningresult.getMean()>90) {
				return "WinnerAcknowledgement.jsf";
			}
			else {
				return "SimpleAcknowledgement.jsf";
			}
		}
		
		public void Datacheckraffle() throws IOException {
			String raffle = student.getRaffle();
			double mean = 0;double sd = 0, temp = 0;
            if(raffle.isEmpty()) {
            	mean=0;
            	sd=0;
            }
            else {
            String[] values = raffle.split(",");
			for (int i = 0; i < values.length; i++)
				mean = mean + Integer.parseInt(values[i]);
			mean = mean / values.length;

			for (int i = 0; i < values.length; i++)
				temp += Math.pow(Integer.parseInt(values[i]) - mean, 2);
			sd = Math.sqrt(temp / (values.length - 1));
            }
			winningresult.setMean(mean);
			winningresult.setStandardDeviation(sd);
		}
		public void FileInput() throws IOException {

			Writer writer = new FileWriter(
					"surveyoutputfile.txt", true);

			try {
				writer.write(student.getFirstName() + "|" + student.getLastName() + "|"
						+ student.getAddress() + "|" + student.getCity() + "|"
						+ student.getState() + "|" + student.getZip() + "|"
						+ student.getPhone() + "|" + student.getEmail() + "|"
						+ student.getDos() + "|" + student.getDos1() + "|" + student.getLikedMost1() + "|" + student.getInterested()
						+ "|" + student.getLikelihood() + "|" + student.getRaffle() + "|"
						+ student.getComments() + " | "
						+ System.getProperty("line.separator"));

			} finally {
				writer.close();
			}

		}
		public String surveyList() throws IOException {
			try {
				obj = listallsurveys();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return "ListSurvey.jsf";
		}

		public String listallsurveys() throws FileNotFoundException, IOException {
			ArrayList<HashMap<String, String>> list1 = new ArrayList<HashMap<String, String>>();

			String data;
			BufferedReader buffer = new BufferedReader(new FileReader(
					"surveyoutputfile.txt"));
			String line = buffer.readLine();
			StringBuilder sb = new StringBuilder();

			while (line != null) {
				String a[] = line.split("\\|");

				HashMap<String, String> surveyobj = new HashMap<String, String>();
				surveyobj.put("firstName", a[0]);
				surveyobj.put("lastName", a[1]);
				surveyobj.put("address", a[2]);
				surveyobj.put("city", a[3]);
				surveyobj.put("state", a[4]);
				surveyobj.put("zip", a[5]);
				surveyobj.put("phone", a[6]);
				surveyobj.put("email", a[7]);
				surveyobj.put("dos", a[8]);
				surveyobj.put("dos1",a[9]);
				surveyobj.put("likedMost1", a[10]);
				surveyobj.put("interested", a[11]);
				surveyobj.put("likelihood", a[12]);
				surveyobj.put("raffle", a[13]);
				surveyobj.put("comments", a[14]);
				list1.add(surveyobj);
				line = buffer.readLine();

			}
			setSurveys(list1);
			data = sb.toString();
			buffer.close();
			return data;
		}
		public String getObj() {
			return obj;
		}
		public void setObj(String obj) {
			this.obj = obj;
		}
		public ArrayList<HashMap<String, String>> getSurveys() {
			return surveys;
		}

		public void setSurveys(ArrayList<HashMap<String, String>> list1) {
			this.surveys = list1;
		}

		public void main(String args[]) {
			try {
				listallsurveys();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

}
