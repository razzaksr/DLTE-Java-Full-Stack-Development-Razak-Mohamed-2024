package layer.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class BankersService implements BankersRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String deleteOne(int id){
        String information=id+" has deleted";
        jdbcTemplate.update("delete from bankers where banker_id=?",new Object[]{id});
        return information;
    }

    public String updateOne(Bankers bankers){
        String information=bankers.getBankerId()+" has updated";
        int ack=jdbcTemplate.update("update bankers set banker_name=?, banker_passcode=? where banker_id=?",
                new Object[]{bankers.getBankerName(),bankers.getBankerPasscode(),bankers.getBankerId()});
        if(ack!=0)
            return information;
        else
            return bankers.getBankerId()+" hasn't updated";
    }

    public List<Bankers> readNames(String name){
        return jdbcTemplate.query("select * from bankers where banker_name=?",new Object[]{name},new BankersMapper());
    }

    public String insertion(Bankers bankers){
        String information=bankers.getBankerName()+" access created";
        jdbcTemplate.update("insert into bankers values(bank_seq.nextval,?,?)",new Object[]{bankers.getBankerName(),bankers.getBankerPasscode()});
        return information;
    }

    public Optional<Bankers> listOne(int id){
        return Optional.of(jdbcTemplate.queryForObject("select * from bankers where banker_id=?",new Object[]{id},
                new BeanPropertyRowMapper<>(Bankers.class)));
    }

    public List<Bankers> listAll(){
        return jdbcTemplate.query("select * from bankers",new BankersMapper());
    }

    class BankersMapper implements RowMapper<Bankers> {

        @Override
        public Bankers mapRow(ResultSet rs, int rowNum) throws SQLException {
            Bankers bankers=new Bankers();
            bankers.setBankerId(rs.getInt("banker_id"));
            bankers.setBankerName(rs.getString("banker_name"));
            bankers.setBankerPasscode(rs.getString("banker_passcode"));
            return bankers;
        }
    }
}