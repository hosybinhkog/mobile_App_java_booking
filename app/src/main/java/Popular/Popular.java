package Popular;

import java.io.Serializable;

public class Popular implements Serializable {
    private String title;
    private String desc;
    private int ResourceId;

    public Popular(String title, String desc, int resourceId) {
        this.title = title;
        this.desc = desc;
        this.ResourceId = resourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getResourceId() {
        return ResourceId;
    }

    public void setResourceId(int resourceId) {
        ResourceId = resourceId;
    }
}
