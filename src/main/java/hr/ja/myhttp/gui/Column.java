package hr.ja.myhttp.gui;

import lombok.Data;

@Data
public class Column {

    public enum Size {
        SM, MD, LG, XL
    }

    private String classes = "";


    public void addClass(Size size, int length) {
        classes += "col-%s-%s".formatted(size, length);
    }

}
