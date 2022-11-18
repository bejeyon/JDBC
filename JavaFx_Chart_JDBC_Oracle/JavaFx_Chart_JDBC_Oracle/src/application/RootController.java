package application;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;

public class RootController implements Initializable {
	@FXML private ScatterChart sChart;
	@FXML private BarChart barChart;
	@FXML private AreaChart areaChart;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		ChartDAO dao = new ChartDAO();
		
		List<ChartVO> list = dao.getData();
		
		//lineChart 에 XYChart 데이터 삽입
		for(ChartVO i : list) {
		     String name = i.getJob_id();
		     int no = i.getSum();
		     XYChart.Series<String, Integer> series = new XYChart.Series<>();
		     series.getData().add( new XYChart.Data<>(name, no));
		     sChart.getData().add(series );
		}//end for
		
		//barChart 에 XYChart 데이터 삽입
		for(ChartVO i : list) {
		     String name = i.getJob_id();
		     int no = i.getSum();
		     XYChart.Series<String, Integer> series = new XYChart.Series<>();
		     series.getData().add( new XYChart.Data<>(name, no));
		     barChart.getData().add(series );
		}//end for
		barChart.setTitle("HR job_id Salary");
		
		//AreaChart 에 XYChart 데이터 삽입
		for(ChartVO i : list) {
		     String name = i.getJob_id();
		     int no = i.getSum();
		     XYChart.Series<String, Integer> series = new XYChart.Series<>();
		     series.getData().add( new XYChart.Data<>(name, no));
		     areaChart.getData().add(series );
		}//end for
	
	
		
		
	
	}//end 
}//end class







