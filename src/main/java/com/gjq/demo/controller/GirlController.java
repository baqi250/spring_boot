package com.gjq.demo.controller;

import com.gjq.demo.domain.Girl;
import com.gjq.demo.resposity.GirlRepository;
import com.gjq.demo.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GirlController {
    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;
    @GetMapping(value = "/girls")
    public List<Girl>girlList(){
        System.out.println("agsdgd");
        return girlRepository.findAll();
    }
    @PostMapping(value = "/girls")
    public Girl addGirl(@RequestParam("cupSize") String cupSize,@RequestParam("age") Integer age){
        Girl girl=new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }
    @GetMapping(value = "/girls/{id}")
    public Optional<Girl> getGirlById(@PathVariable("id") Integer id){
        return girlRepository.findById(id);
    }

    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age){
        Girl girl=new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        System.out.println("sdfddg");
        return girlRepository.save(girl);
    }
    @DeleteMapping (value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        girlRepository.deleteById(id);
    }
    //通过年龄查询
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){
        return  girlRepository.findByAge(age);
    }
    @PostMapping(value = "/girls/two")
    public void insertTwo(){
         girlService.insertTwo();
    }
}
