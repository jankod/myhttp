package hr.ja.myhttp.gui;

import hr.ja.myhttp.util.Page;
import lombok.Getter;
import lombok.Setter;
import spark.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Getter
@Setter
public abstract class LayoutPage extends Page {

    private Page currentPage;

}
