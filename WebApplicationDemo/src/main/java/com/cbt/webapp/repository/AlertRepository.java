package com.cbt.webapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.cbt.webapp.entity.AlertMonitor;

public interface AlertRepository extends CrudRepository<AlertMonitor, Integer> {

}
