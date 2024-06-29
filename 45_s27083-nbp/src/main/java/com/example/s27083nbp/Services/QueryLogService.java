package com.example.s27083nbp.Services;

import com.example.s27083nbp.Models.QueryLog;
import com.example.s27083nbp.Repositories.QueryLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class QueryLogService {
    private final QueryLogRepository queryLogRepository;

    public QueryLogService(QueryLogRepository queryLogRepository) {
        this.queryLogRepository = queryLogRepository;
    }

    public void saveQueryLog(String currency, String startDate, String endDate, double averageRate) {
        QueryLog queryLog = new QueryLog();
        queryLog.setCurrency(currency);
        queryLog.setStartDate(startDate);
        queryLog.setEndDate(endDate);
        queryLog.setAverageRate(averageRate);
        queryLog.setQueryTime(LocalDateTime.now());
        queryLogRepository.save(queryLog);
    }
}