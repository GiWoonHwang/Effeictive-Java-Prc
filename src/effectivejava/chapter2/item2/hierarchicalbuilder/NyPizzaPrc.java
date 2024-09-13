package effectivejava.chapter2.item2.hierarchicalbuilder;

import java.util.Objects;


public class NyPizzaPrc extends PizzaPrc {
    public enum Size {SMALL, MEDIUM, LARGE}

    private final Size size;


    public  static class Builder extends PizzaPrc.Builder<Builder> {
        private final Size size;

        public Builder(Size size) { this.size = Objects.requireNonNull(size);}

        @Override public NyPizzaPrc build() { return new NyPizzaPrc(this);}

        @Override protected Builder self() {return this;}

    }

    private NyPizzaPrc(Builder builder) {
        super(builder);
        size = builder.size;
    }

    @Override public String toString() {
        return toppings + "로 토핑한 뉴욕 피자";
    }


}