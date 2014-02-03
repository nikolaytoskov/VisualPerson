
public class Address {

    private String city;
    private int code;
    private double popDen;
    
    public Address(String s, int c, double p){
        this.city = s;
        this.code = c;
        this.popDen = p;
    }
    
    public String getCity(){
        return city;
    }
    
    public void setCity(String city){
        this.city = city;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public double getPopDen() {
        return popDen;
    }

    public void setPopDen(double popDen) {
        this.popDen = popDen;
    }   
}
