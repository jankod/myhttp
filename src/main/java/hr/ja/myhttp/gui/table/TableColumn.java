package hr.ja.myhttp.gui.table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TableColumn<T> {

    private String header;
    private ValueProvider<T, ?> valueProvider;

    public TableColumn(ValueProvider<T, ?> valueProvider) {
        this.valueProvider = valueProvider;
    }
}
