class ParkingSystem {
    private int[] slots;

    public ParkingSystem(int big, int medium, int small) {
        slots = new int[]{0, big, medium, small}; // index = carType (1, 2, 3)
    }

    public boolean addCar(int carType) {
        if (slots[carType] == 0) return false; // no space left for this type
        slots[carType]--;                      // occupy one slot
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
