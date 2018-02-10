public class Address {
    private int floor;
    private int box;
    private String desc;

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getBox() {
        return box;
    }

    public void setBox(int box) {
        this.box = box;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Address(int floor, int box, String desc) {
        this.floor = floor;
        this.box = box;
        this.desc = desc;
    }

    public Address(int floor, int box) {
        this.floor = floor;
        this.box = box;
    }

    public Address(String desc) {
        this(0,0, desc);
    }
}
