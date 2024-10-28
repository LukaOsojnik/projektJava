package hr.java.restaurant.model;

public class Restaurant extends Entity {

    private String name;
    private Address address;
    private Meal[] meal;
    private Chef[] chef;
    private Waiter[] waiter;
    private Deliverer[] deliverers;

    public Restaurant(String name, Address address, Meal[] meal, Chef[] chef, Waiter[] waiter, Deliverer[] deliverers, Long id) {
        super(id);
        this.name = name;
        this.address = address;
        this.meal = meal;
        this.chef = chef;
        this.waiter = waiter;
        this.deliverers = deliverers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Meal[] getMeal() {
        return meal;
    }

    public void setMeal(Meal[] meal) {
        this.meal = meal;
    }

    public Chef[] getChef() {
        return chef;
    }

    public void setChef(Chef[] chef) {
        this.chef = chef;
    }

    public Waiter[] getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter[] waiter) {
        this.waiter = waiter;
    }

    public Deliverer[] getDeliverers() {
        return deliverers;
    }

    public void setDeliverers(Deliverer[] deliverers) {
        this.deliverers = deliverers;
    }
}
