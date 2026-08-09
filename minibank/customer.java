package minibank;

public class customer {

    private String name;
    private String email;
    private String mobile;
    private final String customerid;

    private static long customercounter = 101;

    private static String generatecustomerid() {
        return "CUST" + customercounter++;
    }

    public customer(String name, String email, String mobile) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        customerid = generatecustomerid();
    }

    public String getname() {
        return name;
    }

    public String getemail() {
        return email;
    }

    public String getmobile() {
        return mobile;
    }

    public String getcustomerid() {
        return customerid;
    }
}