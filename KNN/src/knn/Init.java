package knn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import knn.WriteCSV;

public class Init {

	String sourceFile;

	public Init(String sourceFile) {
		super();
		this.sourceFile = sourceFile;
	}

	List<Data> loadSourceFile() throws IOException {
		List<Data> list = new ArrayList<Data>();
		try {
			String encoding = "GBK";
			File file = new File(sourceFile);
			if (file.isFile() && file.exists()) {
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				bufferedReader.readLine();
				// WriteCSV.initFile(sourceFile+"_Generated.csv");
				while ((lineTxt = bufferedReader.readLine()) != null) {
					String[] frameData = lineTxt.split(",");
					Data data = new Data();
					data.setId(Integer.parseInt(frameData[0]));
					data.setMax_x(Double.parseDouble(frameData[1]));
					data.setMax_y(Double.parseDouble(frameData[2]));
					data.setMax_z(Double.parseDouble(frameData[3]));
					data.setMin_x(Double.parseDouble(frameData[4]));
					data.setMin_y(Double.parseDouble(frameData[5]));
					data.setMin_z(Double.parseDouble(frameData[6]));
					data.setMean_x(Double.parseDouble(frameData[7]));
					data.setMean_y(Double.parseDouble(frameData[8]));
					data.setMean_z(Double.parseDouble(frameData[9]));
					data.setVar_x(Double.parseDouble(frameData[10]));
					data.setVar_y(Double.parseDouble(frameData[11]));
					data.setVar_z(Double.parseDouble(frameData[12]));
					data.setActivity(frameData[13]);
					data.setIs_fall(Integer.parseInt(frameData[14]));
					// double[] resultToPrint =
					// {data.getId(),data.getMax_x(),data.getMax_y(),data.getMax_z(),data.getMin_x(),data.getMin_y(),data.getMin_z(),data.getMean_x(),data.getMean_y(),data.getMean_z(),data.getVar_x(),data.getVar_y(),data.getVar_z(),data.getIs_fall()};
					// WriteCSV.writeRow(resultToPrint);
					list.add(data);
					// if(data.getIs_fall() == 1) {
					// for(int i = 0; i < 10; i++) {
					// Data dataFake = new Data();
					// dataFake.setId(Integer.parseInt(frameData[0])+300);
					// dataFake.setMax_x(dataGenerate(Double.parseDouble(frameData[1])));
					// dataFake.setMax_y(dataGenerate(Double.parseDouble(frameData[2])));
					// dataFake.setMax_z(dataGenerate(Double.parseDouble(frameData[3])));
					// dataFake.setMin_x(dataGenerate(Double.parseDouble(frameData[4])));
					// dataFake.setMin_y(dataGenerate(Double.parseDouble(frameData[5])));
					// dataFake.setMin_z(dataGenerate(Double.parseDouble(frameData[6])));
					// dataFake.setMean_x(Double.parseDouble(frameData[7]));
					// dataFake.setMean_y(Double.parseDouble(frameData[8]));
					// dataFake.setMean_z(Double.parseDouble(frameData[9]));
					// dataFake.setVar_x(Double.parseDouble(frameData[10]));
					// dataFake.setVar_y(Double.parseDouble(frameData[11]));
					// dataFake.setVar_z(Double.parseDouble(frameData[12]));
					// dataFake.setActivity(frameData[13]);
					// dataFake.setIs_fall(Integer.parseInt(frameData[14]));
					// list.add(dataFake);
					//// double[] resultToPrintFake =
					// {data.getId(),data.getMax_x(),data.getMax_y(),data.getMax_z(),data.getMin_x(),data.getMin_y(),data.getMin_z(),data.getMean_x(),data.getMean_y(),data.getMean_z(),data.getVar_x(),data.getVar_y(),data.getVar_z(),data.getIs_fall()};
					//// WriteCSV.writeRow(resultToPrintFake);
					// }
					// }
				}
				read.close();
				// WriteCSV.closeFile();
			} else {
				System.out.println("No such file");
			}
		} catch (Exception e) {
			System.out.println("Can't read this file");
			e.printStackTrace();
		}

		HashMap<String, Double> attributes = new HashMap<String, Double>();
		for (Data data : list) {
		}

		return list;
	}

	public List<Data> preProcess(List<Data> dataset) {
		double[] max_x_norm = { dataset.get(0).getMax_x(), dataset.get(0).getMax_x() };
		double[] max_y_norm = { dataset.get(0).getMax_y(), dataset.get(0).getMax_y() };
		double[] max_z_norm = { dataset.get(0).getMax_z(), dataset.get(0).getMax_z() };
		double[] min_x_norm = { dataset.get(0).getMin_x(), dataset.get(0).getMin_x() };
		double[] min_y_norm = { dataset.get(0).getMin_y(), dataset.get(0).getMin_y() };
		double[] min_z_norm = { dataset.get(0).getMin_z(), dataset.get(0).getMin_z() };
		double[] mean_x_norm = { dataset.get(0).getMean_x(), dataset.get(0).getMean_x() };
		double[] mean_y_norm = { dataset.get(0).getMean_y(), dataset.get(0).getMean_y() };
		double[] mean_z_norm = { dataset.get(0).getMean_z(), dataset.get(0).getMean_z() };
		double[] var_x_norm = { dataset.get(0).getVar_x(), dataset.get(0).getVar_x() };
		double[] var_y_norm = { dataset.get(0).getVar_y(), dataset.get(0).getVar_y() };
		double[] var_z_norm = { dataset.get(0).getVar_z(), dataset.get(0).getVar_z() };
		for (Data trainData : dataset) {
			if (trainData.getMax_x() > max_x_norm[0])
				max_x_norm[0] = trainData.getMax_x();
			if (trainData.getMax_y() > max_y_norm[0])
				max_y_norm[0] = trainData.getMax_y();
			if (trainData.getMax_z() > max_z_norm[0])
				max_z_norm[0] = trainData.getMax_z();
			if (trainData.getMin_x() > min_x_norm[0])
				min_x_norm[0] = trainData.getMin_x();
			if (trainData.getMin_y() > min_y_norm[0])
				min_y_norm[0] = trainData.getMin_y();
			if (trainData.getMin_z() > min_z_norm[0])
				min_z_norm[0] = trainData.getMin_z();
			if (trainData.getMean_x() > mean_x_norm[0])
				mean_x_norm[0] = trainData.getMean_x();
			if (trainData.getMean_y() > mean_y_norm[0])
				mean_y_norm[0] = trainData.getMean_y();
			if (trainData.getMean_z() > mean_z_norm[0])
				mean_z_norm[0] = trainData.getMean_z();
			if (trainData.getVar_x() > var_x_norm[0])
				var_x_norm[0] = trainData.getVar_x();
			if (trainData.getVar_y() > var_y_norm[0])
				var_y_norm[0] = trainData.getVar_y();
			if (trainData.getVar_z() > var_z_norm[0])
				var_z_norm[0] = trainData.getVar_z();

			if (trainData.getMax_x() < max_x_norm[1])
				max_x_norm[1] = trainData.getMax_x();
			if (trainData.getMax_y() < max_y_norm[1])
				max_y_norm[1] = trainData.getMax_y();
			if (trainData.getMax_z() < max_z_norm[1])
				max_z_norm[1] = trainData.getMax_z();
			if (trainData.getMin_x() < min_x_norm[1])
				min_x_norm[1] = trainData.getMin_x();
			if (trainData.getMin_y() < min_y_norm[1])
				min_y_norm[1] = trainData.getMin_y();
			if (trainData.getMin_z() < min_z_norm[1])
				min_z_norm[1] = trainData.getMin_z();
			if (trainData.getMean_x() < mean_x_norm[1])
				mean_x_norm[1] = trainData.getMean_x();
			if (trainData.getMean_y() < mean_y_norm[1])
				mean_y_norm[1] = trainData.getMean_y();
			if (trainData.getMean_z() < mean_z_norm[1])
				mean_z_norm[1] = trainData.getMean_z();
			if (trainData.getVar_x() < var_x_norm[1])
				var_x_norm[1] = trainData.getVar_x();
			if (trainData.getVar_y() < var_y_norm[1])
				var_y_norm[1] = trainData.getVar_y();
			if (trainData.getVar_z() < var_z_norm[1])
				var_z_norm[1] = trainData.getVar_z();
		}
		for (int i = 0; i < dataset.size(); i++) {
			dataset.get(i).setMax_x((dataset.get(i).getMax_x() - max_x_norm[1]) / (max_x_norm[0] - max_x_norm[1]));
			dataset.get(i).setMax_y((dataset.get(i).getMax_y() - max_y_norm[1]) / (max_y_norm[0] - max_y_norm[1]));
			dataset.get(i).setMax_z((dataset.get(i).getMax_z() - max_z_norm[1]) / (max_z_norm[0] - max_z_norm[1]));
			dataset.get(i).setMin_x((dataset.get(i).getMin_x() - min_x_norm[1]) / (min_x_norm[0] - min_x_norm[1]));
			dataset.get(i).setMin_y((dataset.get(i).getMin_y() - min_y_norm[1]) / (min_y_norm[0] - min_y_norm[1]));
			dataset.get(i).setMin_z((dataset.get(i).getMin_z() - min_z_norm[1]) / (min_z_norm[0] - min_z_norm[1]));
			dataset.get(i).setMean_x((dataset.get(i).getMean_x() - mean_x_norm[1]) / (mean_x_norm[0] - mean_x_norm[1]));
			dataset.get(i).setMean_y((dataset.get(i).getMean_y() - mean_y_norm[1]) / (mean_y_norm[0] - mean_y_norm[1]));
			dataset.get(i).setMean_z((dataset.get(i).getMean_z() - mean_z_norm[1]) / (mean_z_norm[0] - mean_z_norm[1]));
			dataset.get(i).setVar_x((dataset.get(i).getVar_x() - var_x_norm[1]) / (var_x_norm[0] - var_x_norm[1]));
			dataset.get(i).setVar_y((dataset.get(i).getVar_y() - var_y_norm[1]) / (var_y_norm[0] - var_y_norm[1]));
			dataset.get(i).setVar_z((dataset.get(i).getVar_z() - var_z_norm[1]) / (var_z_norm[0] - var_z_norm[1]));
		}
		return dataset;
	}

	public int predict(Data toPredict, List<Data> dataset, int k) {
		int fall = 0;
		int unfall = 0;
		int i = 0;
		for (Data trainData : dataset) {
			trainData.setDistance(cabDistance(toPredict, trainData));
		}
		Collections.sort(dataset);
		while (i < k) {
			if (dataset.get(i).getIs_fall() == 1) {
				fall++;
			} else {
				unfall++;
			}
			i++;
		}
		if (fall > unfall)
			return 1;
		return 0;
	}

	public double eurDistance(Data toPredict, Data trainData) {
		// TODO Auto-generated method stub
		double distance = 0.0;
		distance += Math.pow((trainData.getMax_x() - toPredict.getMax_x()), 2);
		distance += Math.pow((trainData.getMax_y() - toPredict.getMax_y()), 2);
		distance += Math.pow((trainData.getMax_z() - toPredict.getMax_z()), 2);
		distance += Math.pow((trainData.getMin_x() - toPredict.getMin_x()), 2);
		distance += Math.pow((trainData.getMin_y() - toPredict.getMin_y()), 2);
		distance += Math.pow((trainData.getMin_z() - toPredict.getMin_z()), 2);
//		distance += Math.pow((trainData.getMean_x() - toPredict.getMean_x()), 2);
//		distance += Math.pow((trainData.getMean_y() - toPredict.getMean_y()), 2);
//		distance += Math.pow((trainData.getMean_z() - toPredict.getMean_z()), 2);
		distance += Math.pow((trainData.getVar_x() - toPredict.getVar_x()), 2);
		distance += Math.pow((trainData.getVar_y() - toPredict.getVar_y()), 2);
		distance += Math.pow((trainData.getVar_z() - toPredict.getVar_z()), 2);
		distance = Math.sqrt(distance);
		return distance;
	}
	
	public double cabDistance(Data toPredict, Data trainData) {
		// TODO Auto-generated method stub
		double distance = 0.0;
		distance += Math.abs((trainData.getMax_x() - toPredict.getMax_x()));
		distance += Math.abs((trainData.getMax_y() - toPredict.getMax_y()));
		distance += Math.abs((trainData.getMax_z() - toPredict.getMax_z()));
		distance += Math.abs((trainData.getMin_x() - toPredict.getMin_x()));
		distance += Math.abs((trainData.getMin_y() - toPredict.getMin_y()));
		distance += Math.abs((trainData.getMin_z() - toPredict.getMin_z()));
//		distance += Math.abs((trainData.getMean_x() - toPredict.getMean_x()));
//		distance += Math.abs((trainData.getMean_y() - toPredict.getMean_y()));
//		distance += Math.abs((trainData.getMean_z() - toPredict.getMean_z()));
		distance += Math.abs((trainData.getVar_x() - toPredict.getVar_x()));
		distance += Math.abs((trainData.getVar_y() - toPredict.getVar_y()));
		distance += Math.abs((trainData.getVar_z() - toPredict.getVar_z()));
		return distance;
	}
	

	public double dataGenerate(double rawData) {
		java.util.Random r = new java.util.Random();
		return r.nextGaussian() * Math.sqrt(1) + rawData;
	}

//	public void draw(List<Point3D> fall, List<Point3D> unfall) {
//		Point3D a = new Point3D(0, 0, 0);
//		MatPlot3DMgr matPlot3DMgr = new MatPlot3DMgr();
//		matPlot3DMgr.setDataInputType(MatPlot3DMgr.DATA_TYPE_DOTS);
//		matPlot3DMgr.addData("fall", fall);
//		matPlot3DMgr.addData("unfall", unfall);
//
//		matPlot3DMgr.setTitle("Data Visualisation");
//		matPlot3DMgr.show();
//
//	}

}
