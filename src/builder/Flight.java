package builder;

import java.time.Duration;

public class Flight {

    public static void main(String[] args) {

        Flight flight1 = new FlightBuilder().buildOrigin("Warsaw")
                .buildDestination("Wroclaw")
                .buildPrice(1500).buildDelay(Duration.ofHours(2))
                .build();
        System.out.println(flight1);

        Flight flight2 = new FlightBuilder().buildOrigin("Warsaw")
                .buildDestination("Wroclaw")
                .buildPrice(0).buildDelay(Duration.ofHours(2))
                .build();
        System.out.println(flight2);
    }

    String origin;
    String destination;
    double price;
    Duration delay;

    private Flight(FlightBuilder builder) {
        this.origin = builder.origin;
        this.destination = builder.destination;
        this.price = builder.price;
        this.delay = builder.delay;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", price=" + price +
                ", delay=" + delay +
                '}';
    }

    public static class FlightBuilder
    {
        String origin;
        String destination;
        double price;
        Duration delay;

        public FlightBuilder buildOrigin(String origin)
        {
            this.origin = origin;
            return this;
        }

        public FlightBuilder buildDestination(String destination)
        {
            this.destination = destination;
            return this;
        }

        public FlightBuilder buildPrice(double price)
        {
            this.price = price;
            return this;
        }

        public FlightBuilder buildDelay(Duration delay)
        {
            this.delay = delay;
            return this;
        }

        public Flight build()
        {
            if(this.price == 0.0)
            {
                throw new IllegalStateException("Price is missing");
            }

            return new Flight(this);
        }
    }
}
