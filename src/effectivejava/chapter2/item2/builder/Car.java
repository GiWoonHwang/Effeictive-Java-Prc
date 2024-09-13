package effectivejava.chapter2.item2.builder;

public class Car {

    private  final int door;
    private  final int wheel;
    private final String color;
    private final String brand;



    public static class  Builder {

        // required
        private final int door;
        private final int wheel;

        // optional
        private String color = "";
        private String brand = "";
        private boolean hiPass = false;
        private boolean automation = true;

        public Builder(int door, int wheel) {
            this.door = door;
            this.wheel = wheel;
        }


        public Builder color(String val) {
            color = val;
            return this;
        }


        public Builder brand(String val) {
            brand = val;
            return this;
        }

        public Car build() {
            return new Car(this);
        }


    }

    private Car(Builder builder) {
        door = builder.door;
        wheel = builder.wheel;
        color = builder.color;
        brand = builder.brand;

    }

    public static  void main(String[] args) {
        Car car = new Builder(4,4)
                .color("Black").brand("sm").build();
    }







}