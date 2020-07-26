package challenge.apidemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/source")
public class SourceController {

    public static final String sourceRepoURL = "https://github.com/diasdev/apidemo.git";

    @GetMapping
    public String getSource() {
        return sourceRepoURL;
    }
}
