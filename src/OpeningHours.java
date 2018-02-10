public class OpeningHours {

    // ************ Fields **********

    private int openingTime;
    private int closingTime;

    // ************ End of Fields **********

    // ************ Constructors for Opening Hours **********

    public OpeningHours(int openingTime, int closingTime) {
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    // ************ End of Constructors for Opening Hours **********

    // ************ Getters and Setters **********

    public int getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(int openingTime) {
        this.openingTime = openingTime;
    }

    public int getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(int closingTime) {
        this.closingTime = closingTime;
    }

    // ************ End of Getters and Setters **********

}
