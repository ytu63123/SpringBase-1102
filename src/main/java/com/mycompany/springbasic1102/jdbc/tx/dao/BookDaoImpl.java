package com.mycompany.springbasic1102.jdbc.tx.dao;

import com.mycompany.springbasic1102.jdbc.tx.exception.InsufficientAmount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer getPrice(Integer bid) {
        String sql = "select price from Book where bid=?";
        Integer price = jdbcTemplate.queryForObject(sql, Integer.class, bid);
        return price;
    }

    @Override
    public void updateStock(Integer bid) {
        String sql = "update Stock set amount=amount-1 where bid=?";
        jdbcTemplate.update(sql, bid);
    }

    @Override
    public void updateWallet(Integer wid, Integer money)throws InsufficientAmount{
        String sql ="select money from wallet where wid=?";
        int walletMoney=jdbcTemplate.queryForObject(sql, Integer.class, wid);
        if(walletMoney<money){
        throw  new InsufficientAmount();
        }
         sql = "update Wallet set money=money- ? where wid=?";
        jdbcTemplate.update(sql, money, wid);
    }
    

}
