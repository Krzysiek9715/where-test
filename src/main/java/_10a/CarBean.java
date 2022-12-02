package _10a;


import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named
public class CarBean implements Serializable {

    Logger log = LoggerFactory.getLogger(getClass());


    @EJB
    CarController carController;

    private List<Car> cars;
    private Long carId;
    private Car car2;

    private Car car;
    @PostConstruct
    public void init(){
        cars = carController.findAll();
//        car2= carController.findById(1L);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Car getCar2() {
        return car2;
    }

    public void setCar2(Car car2) {
        this.car2 = car2;
    }

    public void getCarById(){
        car =  carController.findById(carId);
    }

}
