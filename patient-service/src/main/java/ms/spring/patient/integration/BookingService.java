package ms.spring.patient.integration;

import ms.spring.patient.model.Coffee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "cis-service", contextId = "coffee", path = "/booking")
public interface CoffeeService {
    @GetMapping(path = "/", params = "!name")
    List<Coffee> getAll();

//    @GetMapping("/{id}")
//    Coffee getById(@PathVariable Long id);
//
//    @GetMapping(path = "/", params = "name")
//    Coffee getByName(@RequestParam String name);
}
