package net.nautsch.scpartner;

import static java.util.Arrays.asList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * delivers the partners.
 */
@Controller
@RequestMapping("/partners")
public class PartnerRestController {

    private static final List<String> allPartners = asList("Mr. X", "Vader", "Donald");

    @RequestMapping(method = GET)
    public @ResponseBody List<String> all () {
        return allPartners;
    }

}
