package hr.ja.myhttp.gui;

import java.util.List;

public class Table extends Widget {

    public Table() {
        setTemplate("""
                <table class='table'>
                  <tr>
                    <th>Firstname</th>
                    <th>Lastname</th>
                    <th>Age</th>
                  </tr>
                  <tr>
                    <td>Jill</td>
                    <td>Smith</td>
                    <td>50</td>
                  </tr>
                  <tr>
                    <td>Eve</td>
                    <td>Jackson</td>
                    <td>94</td>
                  </tr>
                </table>
                """);
    }
}
