package hr.ja.myhttp.gui.table;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Getter
@Setter
public class TableColumn<T> {

    private ValueProvider<T, ?> valueProvider;

    private TableHeader header;

    public TableColumn(ValueProvider<T, ?> valueProvider) {
        this.valueProvider = valueProvider;
    }

    public TableColumn<T> setHeader(String label) {
        header = new TableHeader(label);
        return this;
    }

    public TableColumn<T> setHeader(TableHeader header) {
        this.header = header;
        return this;
    }

}
