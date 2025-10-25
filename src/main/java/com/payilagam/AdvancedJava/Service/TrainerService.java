package com.payilagam.AdvancedJava.Service;

import com.payilagam.AdvancedJava.Controller.PayilagamException;
import com.payilagam.AdvancedJava.Entity.TrainerEntity;
import com.payilagam.AdvancedJava.Pojo.TrainerPojo;
import com.payilagam.AdvancedJava.Repo.TrainerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TrainerService {
    @Autowired
    TrainerRepo repo;

    public String addTrainer(TrainerPojo pojo) {
        TrainerEntity entity = new TrainerEntity(pojo.getId(), pojo.getName(), pojo.getSubject(), pojo.getExperience());
       if (repo.save(entity) != null)
        return "Trainer added successfully";
       return "Error adding trainer";

    }


        public void deleteTrainer(int id) {
        repo.findById(id).ifPresent(entity -> repo.delete(entity));


    }

    public TrainerPojo getTrainer(int id) {
        Optional<TrainerEntity> opt = repo.findById(id);
        if (opt.isPresent()) {
            TrainerEntity entity = opt.get();
            TrainerPojo pojo = new TrainerPojo(entity.getId(), entity.getName(), entity.getSubject(), entity.getExperience());
            return pojo;
        } else {
            throw new PayilagamException("Trainer with "+id+" not found");
        }
    }

    public void updateTrainer(TrainerPojo pojo) {
        TrainerEntity entity = new TrainerEntity(pojo.getId(), pojo.getName(), pojo.getSubject(), pojo.getExperience());
        repo.save(entity);
    }
}
