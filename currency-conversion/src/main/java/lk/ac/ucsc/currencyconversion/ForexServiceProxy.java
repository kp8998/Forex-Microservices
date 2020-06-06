package lk.ac.ucsc.currencyconversion;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="forex-service") //if a URL is mentioned then the request coming to this proxy will return to that particular port/url
@RibbonClient(name = "forex-service")
public interface ForexServiceProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversionBean retrieveExchangeValue
            (@PathVariable("from") String from, @PathVariable("to") String to);
}

//this proxy is configured to send the load into different servers in a round-robin manner calling different sever each time
//this is enabled by removing the url from feign client and adding the ribbonclient