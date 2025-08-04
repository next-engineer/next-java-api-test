package com.next.app.api.timesheets.repository;

import com.next.app.api.timesheets.entity.Timesheets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimesheetsRepository extends JpaRepository<Timesheets, Long> {
}
