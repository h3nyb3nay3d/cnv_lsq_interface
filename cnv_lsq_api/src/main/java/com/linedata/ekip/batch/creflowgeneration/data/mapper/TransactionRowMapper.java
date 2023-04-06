package com.linedata.ekip.batch.creflowgeneration.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.linedata.ekip.std.converter.LongConverter;
import com.linedata.ekip.std.services.entity.factory.TransactionFactory;
import com.linedata.ekip.std.services.transaction.entity.Transaction;

public class TransactionRowMapper implements RowMapper<Transaction>
{
   @Autowired
   TransactionFactory transactionFactory;

   @Override
   public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException
   {

      Transaction transaction = transactionFactory.buildBean();
      transaction.setId(LongConverter.convertObjectToLong(rs.getString("ID")));
      return transaction;
   }
}
