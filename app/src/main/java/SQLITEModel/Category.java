package SQLITEModel;

public class Category {
    private int _id;
    private String nameCategory;

    public Category(int _id, String nameCategory) {
        this._id = _id;
        this.nameCategory = nameCategory;
    }

    public Category(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public Category() {

    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
