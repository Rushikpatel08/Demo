package com.example.demo.Controller;

import com.example.demo.Entity.Mobile;
import com.example.demo.Service.mobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
@RequestMapping("/mobile")
//@CrossOrigin(origins = "http://localhost:4200")
public class mobileController {


    @Autowired
    private mobileService MobileService;


    @GetMapping("/getallmobilebybrand/{brand}")
    public List<Mobile> displaymobilebybrand(@PathVariable String brand)
    {
        return MobileService.getallmobilebybrand(brand);

    }

    @GetMapping("/getallmobile")
    public Page<Mobile> displaymobile(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "2") int size)
    {
        Pageable pageable = PageRequest.of(page, size);
        return MobileService.getallmobile(pageable);

    }

    @PostMapping("/addmobile")
    public Mobile insertmobile(@RequestBody Mobile mobile)
    {
        return MobileService.addMobile(mobile);
    }

    @DeleteMapping("/deletemobile/{id}")
    public void deleteMobile(@PathVariable Long id)
    {
        MobileService.deletemobile(id);
    }

    @PutMapping("/updatemobile/{id}")
    public Mobile updatemobile(@PathVariable Long id,@RequestBody Mobile mobile)
    {
        return MobileService.updateMobile(id,mobile);
    }


}
