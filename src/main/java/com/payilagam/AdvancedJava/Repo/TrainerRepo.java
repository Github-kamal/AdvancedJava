package com.payilagam.AdvancedJava.Repo;

import com.payilagam.AdvancedJava.Entity.TrainerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepo extends JpaRepository <TrainerEntity, Integer>
{
}
