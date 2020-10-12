package hr.ja.myhttp.util;

import hr.ja.myhttp.gui.LayoutPage;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class SiteConfiguration {

    private List<Class<? extends Page>> pages = new ArrayList<>();

    private Class<? extends LayoutPage> layoutPage;
}
