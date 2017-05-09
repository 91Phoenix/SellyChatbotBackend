package com.reply.hackaton.repository;

import org.springframework.data.repository.CrudRepository;

import com.reply.hackaton.model.PersonalInformation;

public interface PersonalInfoRepository extends CrudRepository<PersonalInformation, Long> {

}
