package _10a;

import jakarta.persistence.*;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.Where;

import java.sql.Date;

@Entity
@Table(name = "CARS")
@Where(clause = "AVAILABLE=TRUE")
//@FilterDef(
//        name = "activeCar",
//        parameters = @ParamDef(
//                name = "available",
//                type = Boolean.class
//        )
//)
//@Filter(
//        name = "activeCar",
//        condition = "AVAILABLE =:available"
//)
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CAR_ID", nullable = false)
    private Long carId;

    @Column(name = "BRAND")
    private String brand;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "AVAILABLE")
    private boolean available;

    @Column(name = "DATE_OF_DELETE")
    private Date dateOfDelete;

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Date getDateOfDelete() {
        return dateOfDelete;
    }

    public void setDateOfDelete(Date dateOfDelete) {
        this.dateOfDelete = dateOfDelete;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", available=" + available +
                '}';
    }
}
