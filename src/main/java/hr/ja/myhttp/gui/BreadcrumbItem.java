package hr.ja.myhttp.gui;

import lombok.Data;

@Data
public class BreadcrumbItem {

    private String label;
    private Class<? extends Page> page;
    private String icon;
    private boolean active = false;

    public BreadcrumbItem(String label, Class<? extends Page> page, String icon) {
        this.label = label;
        this.page = page;
        this.icon = icon;
    }

    public BreadcrumbItem(String label, Class<? extends Page> page) {
        this.label = label;
        this.page = page;
    }

    public BreadcrumbItem(String label) {
        this.label = label;
    }


    @Override
    public String toString() {
        return """
                      <li class="breadcrumb-item"><a href="#">Home</a></li>
                     <li class="breadcrumb-item active">Dashboard v1</li>
                """;
    }
}
