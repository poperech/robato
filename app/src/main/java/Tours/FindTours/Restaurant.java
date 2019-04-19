package Tours.FindTours;

//Класс для записи и вывода данных
class Restaurant {
    private String name, description, type, image, price;

    Restaurant(String name, String description, String type, String image, String price) {
        super();
        this.name = name;
        this.description = description;
        this.type = type;
        this.image = image;
        this.price = price;
    }
    //Методы для получения данных

    String getName() {
        return this.name;
    }

    String getDescription() {
        return this.description;
    }

    String getType() {
        return this.type;
    }

    String getImage() {
        return this.image;
    }

    String getPrice() { return this.price; }

}
