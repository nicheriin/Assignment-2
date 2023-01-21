package kz.aitu.oop.practice.practice2;

abstract class Carriage {
    protected int capacity;
    protected int currentPassengers = 0;

    public void addPassenger() {
        if (currentPassengers < capacity) {
            currentPassengers++;
        }
    }

    public void removePassenger() {
        if (currentPassengers > 0) {
            currentPassengers--;
        }
    }

    public int getCapacity() {
        return capacity;
    }
}

class LuxuryCarriage extends Carriage {
    LuxuryCarriage() {
        capacity = 12;
    }
}

class CoupeCarriage extends Carriage {
    CoupeCarriage() {
        capacity = 24;
    }
}

class SittingCarriage extends Carriage {
    SittingCarriage(){
        capacity=50;
    }
}

class ReserveCarriage extends Carriage {
    ReserveCarriage(){
        capacity=40;
    }
}

class InvalidCarriage extends Carriage {
    InvalidCarriage(){
        capacity=5;
    }
}

class RestaurantCarriage extends Carriage {
    RestaurantCarriage(){
        capacity=0;
    }
}

class GoodsCarriage extends Carriage {
    GoodsCarriage(){
        capacity=0;
    }
}