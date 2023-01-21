package kz.aitu.oop.practice.practice2;

abstract class Train {
    protected int maxCarriages;
    protected int currentCarriages = 0;
    protected int restaurantCarriages = 0;
    protected int goodsCarriages = 0;
    protected int speed;
    private Carriage[] carriages;

    public void addCarriage(Carriage carriage) {
        if (currentCarriages < maxCarriages && carriage instanceof RestaurantCarriage && restaurantCarriages < 1) {
            currentCarriages++;
            restaurantCarriages++;
        } else if (currentCarriages < maxCarriages && carriage instanceof GoodsCarriage && goodsCarriages < 4) {
            currentCarriages++;
            goodsCarriages++;
        }
    }

    public void removeCarriage(Carriage carriage) {
        if (currentCarriages > 0 && carriage instanceof RestaurantCarriage && restaurantCarriages > 0) {
            currentCarriages--;
            restaurantCarriages--;
        } else if (currentCarriages > 0 && carriage instanceof GoodsCarriage && goodsCarriages > 0) {
            currentCarriages--;
            goodsCarriages--;
        }
    }

    public int getCarriageCount() {
        return currentCarriages;
    }

    public int getCapacity() {
        int totalCapacity = 0;
        for (Carriage carriage : carriages) {
            totalCapacity += carriage.getCapacity();
        }
        return totalCapacity;
    }

    public int getCapacityByType(Class carriageType) {
        int totalCapacity = 0;
        for (Carriage carriage : carriages) {
            if (carriage.getClass().equals(carriageType)) {
                totalCapacity += carriage.getCapacity();
            }
        }
        return totalCapacity;
    }

    public void setCarriages(Carriage[] carriages) {
        this.carriages = carriages;
    }
}

class TrainType1 extends Train {
    TrainType1(){
        maxCarriages=40;
        speed=120;
    }
}

class TrainType2 extends Train {
    TrainType2(){
        maxCarriages=35;
        speed=150;
    }
}
