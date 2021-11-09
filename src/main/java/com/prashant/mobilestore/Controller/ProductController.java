package com.prashant.mobilestore.Controller;

import com.prashant.mobilestore.Model.Phone;
import com.prashant.mobilestore.Repository.PhoneRepository;
import com.prashant.mobilestore.Service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mobile")
public class ProductController {

    @Autowired
    PhoneService phoneService;

    @PostMapping("/import")
    public List<Phone> importPhone(@RequestBody List<Phone> phones){
        return phoneService.saveAllPhones(phones);
    }

    /*@GetMapping("/search")
    public List<Phone> getPhone()
    {
        return phoneService.getAllPhones();
    }*/

    @GetMapping("/search")
    public List<Phone> getPhones(@RequestParam MultiValueMap<String,String> params){

        return phoneService.getSelectedPhones(params);
    }
}
