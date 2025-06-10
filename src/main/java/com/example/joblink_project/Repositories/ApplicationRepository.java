package com.example.joblink_project.Repositories;

import com.example.joblink_project.Models.Application;
import com.example.joblink_project.Models.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByOfferId(Long offerId);
    List<Application> findByOffer(Offer offer);
    List<Application> findByCandidateId(Long candidateId);

}
