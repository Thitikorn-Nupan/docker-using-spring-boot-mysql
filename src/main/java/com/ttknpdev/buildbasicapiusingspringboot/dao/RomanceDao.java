package com.ttknpdev.buildbasicapiusingspringboot.dao;

import com.ttknpdev.buildbasicapiusingspringboot.entity.Romance;
import com.ttknpdev.buildbasicapiusingspringboot.log.MyLog;
import com.ttknpdev.buildbasicapiusingspringboot.repository.RomanceRepository;
import com.ttknpdev.buildbasicapiusingspringboot.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class RomanceDao implements BooksService<Romance> {
    private RomanceRepository repository;
    private MyLog myLog;
    @Autowired
    public RomanceDao(RomanceRepository repository) {
        this.repository = repository;
        myLog = new MyLog(RomanceDao.class);
    }

    @Override
    public Iterable<Romance> reads() {
        return repository.findAll();
    }

    @Override
    public Romance read(String rid) {
        return repository.findById(rid).map(romance -> {
            myLog.log4j.info("RID : "+rid+" exits!!");
            return romance;
        }).orElseThrow(()-> {
            throw new RuntimeException("RID : "+rid+" didn't exit!!");
        });
    }

    @Override
    public Romance create(Romance obj) {
        return repository.save(obj);
    }

    @Override
    public Romance update(Romance obj, String rid) {
        return repository.findById(rid).map(romance -> {
            romance.setTitle(obj.getTitle());
            romance.setPrice(obj.getPrice());
            return repository.save(romance);
        }).orElseThrow(() -> {
            // *** response.put("deleted",null);
            myLog.log4j.info("RID : "+rid+" exits!!");
            return new RuntimeException(("RID : "+rid+" exits!!"));
        });
    }

    @Override
    public Map<String, Romance> delete(String rid) {
        Map<String,Romance> response = new HashMap<>();;
        return repository.findById(rid).map(romance -> {
            response.put("deleted",romance);
            repository.delete(romance);
            return response;
        }).orElseThrow(() -> {
            // response.put("deleted",null);
            myLog.log4j.info("RID : "+rid+" exits!!");
            return new RuntimeException(("RID : "+rid+" exits!!"));
        });
    }
}
