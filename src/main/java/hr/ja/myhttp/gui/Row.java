package hr.ja.myhttp.gui;

import java.util.ArrayList;
import java.util.List;

public class Row extends Widget {

    private List<Column> columns = new ArrayList<>(4);

    public Row() {
    }

    public void addColumn(Column column) {
        columns.add(column);
    }

    public Column column(Column.Size size, int length) {
        Column c = new Column();
        c.addClass(size, length);
        columns.add(c);
        return c;
    }
}
