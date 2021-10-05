package SQLITEModel;

public class Product {
    private int _id;
    private String _idCategory;
    private String nameProduct;
    private Double price;
    private String descriptions;
    private String location;

    public Product(int _id, String _idCategory, String nameProduct, Double price, String descriptions, String location) {
        this._id = _id;
        this._idCategory = _idCategory;
        this.nameProduct = nameProduct;
        this.price = price;
        this.descriptions = descriptions;
        this.location = location;
    }

    public Product() {
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_idCategory() {
        return _idCategory;
    }

    public void set_idCategory(String _idCategory) {
        this._idCategory = _idCategory;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
