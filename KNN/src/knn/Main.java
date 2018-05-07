package knn;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		String datasetFilePath = "src/trainwrist.csv";
//		String testFilePath = "src/testwrist.csv";
		String datasetFilePath = "src/Joon_wrist.csv";
		String testFilePath = "src/Boyu_wrist.csv";
		List<Data> trainList = new ArrayList<Data>();
		List<Data> testList = new ArrayList<Data>();

		Init trainData = new Init(datasetFilePath);
		trainList = trainData.loadSourceFile();
		trainList = trainData.preProcess(trainList);
		Init testData = new Init(testFilePath);
		testList = testData.loadSourceFile();
		testList = testData.preProcess(testList);
		
        int fallErrorCount = 0;
        int unfallErrorCount = 0;
        int totfallErrorCount = 0;
        int unfall = 0;
        int fall = 0;
        int tot = 0;
//        List<Point3D> falllist = new ArrayList<Point3D>();
//        List<Point3D> unfalllist = new ArrayList<Point3D>();
        for (Data sample : testList) {
            int type = testData.predict(sample, trainList, 2);
            if(sample.getIs_fall() == 0) {
            		unfall++;
//            		Point3D point = new Point3D(sample.getVar_x(), sample.getVar_y(), sample.getVar_z());
//            		unfalllist.add(point);
            		if (type != sample.getIs_fall()) {
            			unfallErrorCount++;
                		++totfallErrorCount;
                }
            }
            if(sample.getIs_fall() == 1) {
            		fall++;
//            		Point3D point = new Point3D(sample.getVar_x(), sample.getVar_y(), sample.getVar_z());
//            		falllist.add(point);
            		 if (type != sample.getIs_fall()) {
                 	++fallErrorCount;
                 	++totfallErrorCount;
                 }
            }
        }
         tot = unfall+fall;
        System.out.println("unfall error rate：" + (double)unfallErrorCount / testList.size() * 100 + "%, "+unfall+" / "+tot);
        System.out.println("fall error rate：" + (double)fallErrorCount / testList.size() * 100 + "%, "+fall+" / "+tot); 
        System.out.println("total error rate：" + (double)totfallErrorCount / testList.size() * 100 + "%, "+tot);
        double pos = (double)(66-totfallErrorCount) / 66;
        double rec = (double)(66-totfallErrorCount) / ((66-totfallErrorCount)+(double)unfallErrorCount);
        System.out.println(pos);
        System.out.println(rec);
        System.out.println(2*pos*rec/(pos+rec));
//        testData.draw(falllist, unfalllist);
	}

}
