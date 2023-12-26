package entities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class UsedProduct extends Product{


    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private LocalDate manufactureDate;

    public UsedProduct(){
        super();
    }

    public UsedProduct(String name, Double price, LocalDate manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }


    public static SimpleDateFormat getSdf() {
        return sdf;
    }

    public static void setSdf(SimpleDateFormat sdf) {
        UsedProduct.sdf = sdf;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String priceTag(){
        return super.getName() +
                " $ "
                + String.format("%.2f", super.getPrice())
                + " (Manufacture date: "
                + manufactureDate + ")";
    }

}
