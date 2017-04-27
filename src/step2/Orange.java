package step2;

public class Orange implements Item {
    @Override
    public Integer getUid() {
        return 5678;
    }

    @Override
    public double getPrice() {
        return 0.25;
    }
}
