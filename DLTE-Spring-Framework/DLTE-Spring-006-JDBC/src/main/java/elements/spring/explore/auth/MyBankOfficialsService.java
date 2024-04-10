package elements.spring.explore.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyBankOfficialsService implements UserDetailsService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    Logger logger= LoggerFactory.getLogger(MyBankOfficialsService.class);


    public MyBankOfficials signingUp(MyBankOfficials myBankOfficials){
        int ack = jdbcTemplate.update("insert into mybank_officials values(?,?,?,?,?)",new Object[]{
                myBankOfficials.getFullName(),myBankOfficials.getUsername(),
                myBankOfficials.getPassword(),myBankOfficials.getContact(),
                myBankOfficials.getRole()
        });
        return myBankOfficials;
    }

    public MyBankOfficials findByUsername(String username){
        MyBankOfficials myBankOfficials = jdbcTemplate.queryForObject("select * from mybank_officials where username=?",
                new Object[]{username},new BeanPropertyRowMapper<>(MyBankOfficials.class));
        return myBankOfficials;
    }

    public void updateAttempts(MyBankOfficials myBankOfficials){
        jdbcTemplate.update("update mybank_officials set attempts=? where username=?",
                new Object[]{myBankOfficials.getAttempts(),myBankOfficials.getUsername()});
        logger.info("Attempts are updated");
    }

    public void updateStatus(MyBankOfficials myBankOfficials){
        jdbcTemplate.update("update mybank_officials set status=0 where username=?",
                new Object[]{myBankOfficials.getUsername()});
        logger.info("Status has changed");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyBankOfficials officials = findByUsername(username);
        if(officials==null)
            throw new UsernameNotFoundException(username);
        return officials;
    }
}