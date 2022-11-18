package application;

public class ChartVO {

	private int sum;
	private String job_id;
	
	protected int getSum() {
		return sum;
	}
	protected void setSum(int sum) {
		this.sum = sum;
	}
	protected String getJob_id() {
		return job_id;
	}
	protected void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public ChartVO(int sum, String job_id) {
		super();
		this.sum = sum;
		this.job_id = job_id;
	}
	public ChartVO() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ChartVO [sum=" + sum + ", job_id=" + job_id + "]";
	}
	
}//end class
