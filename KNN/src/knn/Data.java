package knn;

public class Data implements Comparable<Data>{

	private double max_x;
	private double max_y;
	private double max_z;
	private double min_x;
	private double min_y;
	private double min_z;
	private double mean_x;
	private double mean_y;
	private double mean_z;
	private double var_x;
	private double var_y;
	private double var_z;
	private String activity;
	private int is_fall;
	private double timestep;
	private double duration;
	private double weight;
	private int type;
	private double distance;
	private int id;

	@Override
	public int compareTo(Data arg0) {
		// TODO Auto-generated method stub
		if (this.distance < arg0.getDistance()) {  
            return -1;  
        }else if (this.distance  > arg0.getDistance()) {  
            return 1;  
        }  
        return 0;
	}

	public double getMax_x() {
		return max_x;
	}

	public void setMax_x(double max_x) {
		this.max_x = max_x;
	}

	public double getMax_y() {
		return max_y;
	}

	public void setMax_y(double max_y) {
		this.max_y = max_y;
	}

	public double getMax_z() {
		return max_z;
	}

	public void setMax_z(double max_z) {
		this.max_z = max_z;
	}

	public double getMin_x() {
		return min_x;
	}

	public void setMin_x(double min_x) {
		this.min_x = min_x;
	}

	public double getMin_y() {
		return min_y;
	}

	public void setMin_y(double min_y) {
		this.min_y = min_y;
	}

	public double getMin_z() {
		return min_z;
	}

	public void setMin_z(double min_z) {
		this.min_z = min_z;
	}

	public double getMean_x() {
		return mean_x;
	}

	public void setMean_x(double mean_x) {
		this.mean_x = mean_x;
	}

	public double getMean_y() {
		return mean_y;
	}

	public void setMean_y(double mean_y) {
		this.mean_y = mean_y;
	}

	public double getMean_z() {
		return mean_z;
	}

	public void setMean_z(double mean_z) {
		this.mean_z = mean_z;
	}

	public double getVar_x() {
		return var_x;
	}

	public void setVar_x(double var_x) {
		this.var_x = var_x;
	}

	public double getVar_y() {
		return var_y;
	}

	public void setVar_y(double var_y) {
		this.var_y = var_y;
	}

	public double getVar_z() {
		return var_z;
	}

	public void setVar_z(double var_z) {
		this.var_z = var_z;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public int getIs_fall() {
		return is_fall;
	}

	public void setIs_fall(int is_fall) {
		this.is_fall = is_fall;
	}

	public double getTimestep() {
		return timestep;
	}

	public void setTimestep(double timestep) {
		this.timestep = timestep;
	}

	public double getDuration() {
		return duration;
	}
	
	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
