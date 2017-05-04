package test.checkout.counter.step2;

public class Apple implements Item {
    @Override
    public Integer getUid() {
        return 1234;
    }

    @Override
    public double getPrice() {
        return 0.6;
    }
}
