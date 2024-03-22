package elements.spring.explore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.List;
import java.util.Optional;

@Service
public class MyBankService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String apiBlock(Long number, Integer pin){
        // this commented block will be used on testing since the jdbcTemplate update method return 1 or 0 based on that
//        jdbcTemplate.update("delete from mybank_creditcard where creditcard_number=? and creditcard_pin=?",
//                new Object[]{
//                        number,pin
//                });
//        return number+" card is blocked";
        int ack = jdbcTemplate.update("delete from mybank_creditcard where creditcard_number=? and creditcard_pin=?",
                new Object[]{
                        number,pin
                });
        if(ack!=0)
            return number+" card is blocked";
        else
            throw new CardException(" Unauthorized access");
    }

    public CreditCard apiUpdate(CreditCard creditCard, int newPurchase){
        if(newPurchase+creditCard.getCreditcardUsage() <= creditCard.getCreditcardLimit()*0.800 ) {
            int ack = jdbcTemplate.update("update mybank_creditcard set creditcard_available=?, creditcard_usage=? where creditcard_number=?",
                    new Object[]{
                            creditCard.getCreditcardAvailable()-newPurchase,
                            creditCard.getCreditcardUsage()+newPurchase,
                            creditCard.getCreditcardNumber()
                    });
            System.out.println(apiFindById(creditCard.getCreditcardNumber()).get());
            return apiFindById(creditCard.getCreditcardNumber()).get();
        }
        else
            throw new CardException(" Due to over limit usage");
    }

    public CreditCard apiSave(CreditCard creditCard){
        int ack = jdbcTemplate.update("insert into mybank_creditcard values(?,?,?,?,?,?,?,?,?)",
                new Object[]{
                        creditCard.getCreditcardNumber(),
                        creditCard.getCreditcardCvv(),
                        creditCard.getCreditcardExpiry(),
                        creditCard.getCreditcardPin(),
                        creditCard.getCreditcardLimit(),
                        creditCard.getCreditcardUsage(),
                        creditCard.getCreditcardAvailable(),
                        creditCard.isCreditcardStatus(),
                        creditCard.getCreditcardHolder()
                });
        if(ack!=0)
            return creditCard;
        else
            throw new CardException(" due insertion failed");
    }

    public List<CreditCard> apiByLimit(Integer limit){
        return jdbcTemplate.query("select * from mybank_creditcard where creditcard_limit>=?",
                new Object[]{limit},
                new CardMapper());
    }

    public Optional<CreditCard> apiFindById(Long cardNumber){
        return Optional.of(jdbcTemplate.queryForObject("select * from mybank_creditcard where creditcard_number=?",
                new Object[]{cardNumber},
                new BeanPropertyRowMapper<>(CreditCard.class)
        ));
    }

    public List<CreditCard> apiFindAll() throws SQLSyntaxErrorException {
        List<CreditCard> myCards=null;
        try{
            myCards=jdbcTemplate.query("select * from mybank_creditcard",new CardMapper());
        }
        catch (DataAccessException sqlException){
            throw new SQLSyntaxErrorException();
        }
        if(myCards.size()==0){
            throw new CardException();
        }
        return myCards;
    }


    protected class CardMapper implements RowMapper<CreditCard>{

        @Override
        public CreditCard mapRow(ResultSet rs, int rowNum) throws SQLException {
            CreditCard creditCard=new CreditCard();
            creditCard.setCreditcardNumber(rs.getLong(1));
            creditCard.setCreditcardAvailable(rs.getInt("creditcard_available"));
            creditCard.setCreditcardCvv(rs.getInt("creditcard_cvv"));
            creditCard.setCreditcardExpiry(rs.getDate(3));
            creditCard.setCreditcardHolder(rs.getString("creditcard_holder"));
            creditCard.setCreditcardLimit(rs.getInt(5));
            creditCard.setCreditcardPin(rs.getInt(4));
            creditCard.setCreditcardStatus(rs.getBoolean(8));
            creditCard.setCreditcardUsage(rs.getInt(6));
            return creditCard;
        }
    }
}
