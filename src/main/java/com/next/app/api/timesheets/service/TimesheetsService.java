package com.next.app.api.timesheets.service;

import com.next.app.api.timesheets.entity.Timesheets;
import com.next.app.api.timesheets.repository.TimesheetsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TimesheetsService {

    @Autowired
    private TimesheetsRepository timesheetsRepository;

    public List<Timesheets> getAllTimesheets(){ return  timesheetsRepository.findAll(); }

   public Timesheets getTimesheetsById(Long id){
        return timesheetsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Timesheets not found with id : " + id));
   }

   public Timesheets createTimesheets(Timesheets timesheets) {return timesheetsRepository.save(timesheets); }

    public Timesheets updateTimesheets(Long id, Timesheets updateTimesheets){
        Timesheets timesheets = timesheetsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Timesheets not found with id : " + id));
        timesheets.setHoursWorked(updateTimesheets.getHoursWorked());
        timesheets.setWorkDate(updateTimesheets.getWorkDate());

        return timesheetsRepository.save(timesheets);
    }

    public void deleteTimesheets(Long id){
        timesheetsRepository.deleteById(id);
    }
}
