package hr.ja.myhttp.form;

import hr.ja.myhttp.gui.Widget;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class FormWidget extends Widget {

    private List<Widget> widgets = new ArrayList<>(4);

    public FormWidget() {
        //language=InjectedFreeMarker
        setTemplate("""
                <form>
                <#list widgets as w>
                    ${w}
                </#list>
                <button type='submit' class='btn btn-info'>Submit</button>
                </form>
                """);
    }
}
