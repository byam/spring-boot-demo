package edu.miu.spring.boot.demo.service.impl;

import edu.miu.spring.boot.demo.entity.Logger;
import edu.miu.spring.boot.demo.repo.LoggerRepo;
import edu.miu.spring.boot.demo.service.LoggerService;

public class LoggerServiceImpl implements LoggerService {
    private LoggerRepo loggerRepo;

    @Override
    public void save(Logger logger) {
        loggerRepo.save(logger);
    }
}
