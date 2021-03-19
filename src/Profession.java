public abstract class Profession {
    protected int loan;
    protected String designation;
    protected double[] work_time = new double[2];
    protected abstract void work();
    public int get_loan(){
        return loan;
    }
    public double get_work_time(String time){
        switch(time){
            case "Begin":
                return work_time[0];
            case "End":
                return work_time[1];
            case "Duration":
                return work_time[1] - work_time[0];
        }
        return -1.0;
    }
    public String get_designation(){
        return designation;
    }
}
