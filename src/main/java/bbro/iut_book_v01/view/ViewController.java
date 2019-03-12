package bbro.iut_book_v01.view;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping
public class ViewController {
    @GetMapping
    public String index(){return "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>REST API LIST</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "<a href=\"/swagger-ui.html\">REST API LIST</a>\n" +
            "</body>\n" +
            "</html>";}
    public String test(){
        return ";";
    }

}
