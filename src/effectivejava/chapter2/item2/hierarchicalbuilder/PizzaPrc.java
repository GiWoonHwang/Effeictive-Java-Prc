package effectivejava.chapter2.item2.hierarchicalbuilder;
import java.util.*;


public abstract class PizzaPrc {

    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}

    final Set<Topping> toppings;


    abstract static class Builder<T extends Builder<T>> {

        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract PizzaPrc build();

        protected abstract T self();

    }

    PizzaPrc(Builder<?> builder) { toppings = builder.toppings.clone();}

}