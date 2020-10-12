package hr.ja.myhttp.gui.table;

import hr.ja.myhttp.gui.Widget;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Table<T> extends Widget {

    private List<TableColumn<T>> columns = new ArrayList<>();
    private List<T> data;

    public Table() {

        //language=InjectedFreeMarker
        setTemplate("""
                <table class='table'>
                <caption>Ovo je tabela s podataka</caption>
                <thead>
                <tr>
                <#list columns as col>
                    <th>${col.header}</th>
                </#list>
                </tr>
                </thead>
                <tbody>
                <#if data??>
                <#list data as d>
                  <tr>
                  <#list columns as col>
                    <td>${col.valueProvider.apply(d)}</td>
                  </#list>
                  </tr>
                  </#list>
                  </#if>
                </tbody>
                                
                </table>
                """);
    }

    public TableColumn addColumn(ValueProvider<T, ?> valueProvider) {
        TableColumn tableColumn = new TableColumn(valueProvider);
        this.columns.add(tableColumn);
        return tableColumn;
    }
}
