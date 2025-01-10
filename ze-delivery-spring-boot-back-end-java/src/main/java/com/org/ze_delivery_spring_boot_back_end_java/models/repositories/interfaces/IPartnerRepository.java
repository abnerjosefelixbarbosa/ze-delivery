package com.org.ze_delivery_spring_boot_back_end_java.models.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.ze_delivery_spring_boot_back_end_java.models.entities.Partner;

@Repository
public interface IPartnerRepository extends JpaRepository<Partner, String> {

}