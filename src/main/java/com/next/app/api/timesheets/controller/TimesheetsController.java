package com.next.app.api.timesheets.controller;

import com.next.app.api.timesheets.entity.Timesheets;
import com.next.app.api.timesheets.service.TimesheetsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timesheets")
@Tag(name = "timesheets Controller", description = "근무시간 관리 API")
@CrossOrigin(origins = "http://localhost")
public class TimesheetsController {
    
    
    private final TimesheetsService timesheetsService;

    @Autowired
    public TimesheetsController(TimesheetsService timesheetsService) {
        this.timesheetsService = timesheetsService;
    }
    
    @GetMapping
    @Operation(summary = "모든 근무시간 조회", description = "등록된 모든 근무시간 목록을 반환합니다.")
    public List<Timesheets> getAllTimesheets(){ return timesheetsService.getAllTimesheets(); }

    @GetMapping("/{id}")
    @Operation(summary = "근무시간 조회", description = "ID로 특정 근무시간를 조회합니다.")
    public Timesheets getTimesheetsById(@PathVariable Long id) {
        return timesheetsService.getTimesheetsById(id);
    }

    @PostMapping
    @Operation(summary = "근무시간 생성", description = "새로운 근무시간을 생성합니다.")
    public Timesheets createTimesheets(@RequestBody Timesheets timesheets) {
        return timesheetsService.createTimesheets(timesheets);
    }

    @PutMapping("/{id}")
    @Operation(summary = "근무시간 수정", description = "기존 근무시간 정보를 수정합니다.")
    public Timesheets updateTimesheets(@PathVariable Long id, @RequestBody Timesheets timesheets) {
        return timesheetsService.updateTimesheets(id, timesheets);
    }
}
