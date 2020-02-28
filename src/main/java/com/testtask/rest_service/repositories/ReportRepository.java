package com.testtask.rest_service.repositories;

import com.testtask.rest_service.model.ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReportRepository  extends JpaRepository<ReportEntity, Long> {
    @Query(value = "select \n" +
            "cr.id || bo.status as pk,\n" +
            "cr.id,\n" +
            "cr.name,\n" +
            "cr.telephone,\n" +
            "bo.status,\n" +
            "count (b) as book_count\n" +
            "from\n" +
            "public.book as b\n" +
            "inner join public.book_order as b_o on b_o.book_id = b.id\n" +
            "inner join public.bookorder as bo on b_o.order_id = bo.id\n" +
            "inner join public.customer as cr on bo.customer_id = cr.id\n" +
            "where\n" +
            "bo.cdate >= :to \n" +
            "and bo.cdate < :from \n" +
            "group by cr.id, bo.status\n",
            nativeQuery = true)
    List<ReportEntity> bildReport(
            @Param("to") Date to, @Param("from") Date from);

    @Query(value = "select \n" +
            "cr.id || '' as pk,\n" +
            "cr.id,\n" +
            "cr.name,\n" +
            "cr.telephone,\n" +
            "null as status,\n" +
            "count (b) as book_count\n" +
            "from\n" +
            "public.book as b\n" +
            "inner join public.book_order as b_o on b_o.book_id = b.id\n" +
            "inner join public.bookorder as bo on b_o.order_id = bo.id and bo.status = 'C'\n" +
            "inner join public.customer as cr on bo.customer_id = cr.id\n" +
            "where\n" +
            "bo.cdate >= :to \n" +
            "and bo.cdate < :from \n" +
            "group by cr.id\n",
            nativeQuery = true)
    List<ReportEntity> bildReportClosed(
            @Param("to") Date to, @Param("from") Date from);
}
