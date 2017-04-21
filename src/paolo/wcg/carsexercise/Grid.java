package paolo.wcg.carsexercise;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.data.Range;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Grid extends JFrame {

	private static final int maxX = 15;
	private static final int maxY = 15;

	public Grid(Car car) {
		super("White Clarke Group Test");
		JPanel chartPanel = createChartPanel(createDataset(car.getListMovements()));
		add(chartPanel, BorderLayout.CENTER);

		setSize(640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	private JPanel createChartPanel(XYDataset dataset) {
		String chartTitle = "Movement Chart";
		String xAxisLabel = "X";
		String yAxisLabel = "Y";

		JFreeChart chart = ChartFactory.createXYLineChart(chartTitle, xAxisLabel, yAxisLabel, dataset);

		NumberAxis axisX = (NumberAxis) chart.getXYPlot().getRangeAxis();
		axisX.setRange(new Range(0, maxX - 1));
		axisX.setTickUnit(new NumberTickUnit(1));
		axisX.setAutoRange(false);

		NumberAxis axisY = (NumberAxis) chart.getXYPlot().getDomainAxis();
		axisY.setRange(new Range(0, maxY - 1));
		axisY.setTickUnit(new NumberTickUnit(1));
		axisY.setAutoRange(false);

		return new ChartPanel(chart);
	}

	private XYDataset createDataset(List<Point> list) {
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries series1 = new XYSeries("Car Movements", false);

		for (Point p : list) {
			series1.add(p.getX(), p.getY());
		}

		dataset.addSeries(series1);

		return dataset;
	}

	public static void main(String[] args) {
		try {
			String coord = null, X = null, Y = null, commands = null;
			if (args.length > 0) {
				int delimiter = args[0].indexOf(":");
				if (delimiter > 0)
					coord = args[0].substring(0, delimiter);
				else
					throw new Exception("Specify the coordinate in this way x,y:commands");

				commands = args[0].substring(delimiter + 1, args[0].length());
				int delim2 = coord.indexOf(",");
				if (delim2 > 0) {
					X = coord.substring(0, delim2);
					Y = coord.substring(delim2 + 1, coord.length());
				} else
					throw new Exception("Specify the coordinate in this way x,y:commands");
			} else
				throw new Exception("Use the following sintax x,y:commands");

			Point p = null;
			if ((X != null) && (Y != null)) {
				p = new Point(Integer.valueOf(X), Integer.valueOf(Y));
			}

			Coordinates coordinates = new Coordinates(p, Direction.NORTH, Grid.maxX, Grid.maxY);

			final Car car = new Car(coordinates);

			car.receiveCommand(commands);

			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					new Grid(car).setVisible(true);
				}
			});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
