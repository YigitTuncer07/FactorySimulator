public class Payroll {

    private int workHour;
    private int itemCount;

    public Payroll(int workHour, int itemCount){
        this.workHour = workHour;
        this.itemCount = itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public void setWorkHour(int workHour) {
        this.workHour = workHour;
    }

    public int getItemCount() {
        return itemCount;
    }

    public int getWorkHour() {
        return workHour;
    }
    public String toString(){
        return "The work hour is " + workHour + " and the produced item count is " + itemCount + ".";
    }
    public int calculateSalary(){
        return itemCount * 2 + workHour * 3;
    }
}

