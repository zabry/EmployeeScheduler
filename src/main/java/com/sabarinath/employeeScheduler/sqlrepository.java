package com.sabarinath.employeeScheduler;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface sqlrepository extends JpaRepository <EmployeeTaskDetails,Integer> {
    List<EmployeeTaskDetails> findAll();

    @Query(value = "SELECT c FROM EmployeeTaskDetails c WHERE nameofemp=?1")
    public List<EmployeeTaskDetails> findBySearch(String text);

    @Query(value = "SELECT c FROM EmployeeTaskDetails c WHERE employeeid=?1")
    public EmployeeTaskDetails findOne(int eid);

    @Query(value = "SELECT c FROM EmployeeTaskDetails c WHERE ?1 between c.startdate and c.enddate")
    public List<EmployeeTaskDetails> findScheduleByDate(Date date);


    //@Query(value = "insert into SCHEDULED_TASKS (EMPLOYEEID,STARTDATE,ENDDATE,TIMEOFTASK,DURATION,IS_REPEAT,FREQUENCY, nameofemp) VALUES (?1.employeeid,?1.startdate,?1.enddate,?1.timeoftask,?1.duration,?1.is_repeat,?1.frequency.text,?1.nameofemp)",
    //nativeQuery=true)
    //public EmployeeTaskDetails save(EmployeeTaskDetails employeeTaskDetails);
}
