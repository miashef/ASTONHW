class House {
    private String wall;
    private String floor;
    private boolean isDoorOpen;

    private House(Builder builder) {
        this.wall = builder.wall;
        this.floor = builder.floor;
        this.isDoorOpen = builder.isDoorOpen;
    }

    public static class Builder {
        private String wall;
        private String floor;
        private boolean isDoorOpen;

        public Builder(String wall, String floor) {
            this.floor = floor;
            this.wall = wall;
        }

        public Builder setDoorOpen(boolean isDoorOpen) {
            this.isDoorOpen = isDoorOpen;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }

    public String getWall() {
        return wall;
    }

    public String getFloor() {
        return floor;
    }

    public boolean isDoorOpen() {
        return isDoorOpen;
    }
}

class Main2 {
    public static void main(String[] args) {
        House house = new House.Builder("Кирпич", "Паркет")
                .setDoorOpen(true)
                .build();
        System.out.println(house.getWall() + " " + house.getFloor() + " Дверь открыта: " + house.isDoorOpen());
    }
}