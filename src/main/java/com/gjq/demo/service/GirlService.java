package com.gjq.demo.service;

import com.gjq.demo.domain.Girl;
import com.gjq.demo.resposity.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        Girl gir1A=new Girl();
        gir1A.setCupSize("A");
        gir1A.setAge(18);
        girlRepository.save(gir1A);

        Girl gir1B=new Girl();
        gir1B.setCupSize("BB");
        gir1B.setAge(26);
        girlRepository.save(gir1B);
    }
}
