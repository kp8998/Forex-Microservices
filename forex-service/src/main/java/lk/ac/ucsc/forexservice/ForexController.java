package lk.ac.ucsc.forexservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForexController {

    @Autowired
    private ExchangeValueRepository repository;

    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue getExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to){
        ExchangeValue value = repository.findByFromAndTo(from, to);
        value.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return value;
    }
}
