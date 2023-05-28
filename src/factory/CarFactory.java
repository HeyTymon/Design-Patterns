package factory;

public class CarFactory extends Factory {
    @Override
    public Car createCar(CarType carType) {

        switch (carType) {
            case CMax -> return new Ford();
            case

        }


        return null;
    }
}
