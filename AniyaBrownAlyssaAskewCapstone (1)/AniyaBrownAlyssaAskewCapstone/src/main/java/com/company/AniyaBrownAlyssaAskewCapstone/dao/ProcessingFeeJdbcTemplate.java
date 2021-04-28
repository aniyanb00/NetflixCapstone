package com.company.AniyaBrownAlyssaAskewCapstone.dao;

import com.company.AniyaBrownAlyssaAskewCapstone.model.ProcessingFee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ProcessingFeeJdbcTemplate implements ProcessingFeeDao{
    //prepared statements
    private static final String SELECT_PROCESS_FEE_SQL =
            "select fee from processing_fee where product_type = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProcessingFeeJdbcTemplate (JdbcTemplate jdbcTemplate){

        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public ProcessingFee getProcessingFee(String productType){
        try {
            return jdbcTemplate.queryForObject(SELECT_PROCESS_FEE_SQL, this::mapRowToProcessingFee, productType);

        } catch (EmptyResultDataAccessException e) {
            // if nothing is returned just catch the exception and return null
            return null;
        }
    }


    //rowMapper
    private ProcessingFee mapRowToProcessingFee(ResultSet rs, int rowNum) throws SQLException {
        ProcessingFee processFee = new ProcessingFee();
        processFee.setProductType(rs.getString("product_type"));
        processFee.setFee(rs.getBigDecimal("fee"));
        return processFee;
    }

}
