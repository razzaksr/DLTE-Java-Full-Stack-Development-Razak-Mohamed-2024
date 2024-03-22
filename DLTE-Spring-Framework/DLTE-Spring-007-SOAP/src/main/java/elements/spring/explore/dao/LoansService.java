package elements.spring.explore.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class LoansService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Loans> viewEvery(){
        List<Loans> lists=jdbcTemplate.query("select * from mybank_loans",new LoansMapper());
        System.out.println(lists.toString());
        return lists;
    }

    protected class LoansMapper implements RowMapper<Loans>{
        @Override
        public Loans mapRow(ResultSet rs, int rowNum) throws SQLException {
            Loans loans=new Loans();
            loans.setLoanId(rs.getLong(1));
            loans.setLoanPrinciple(rs.getDouble(2));
            loans.setLoanBorrower(rs.getString(3));
            loans.setLoanTenure(rs.getInt(4));
            loans.setLoanInterest(rs.getDouble(5));
            loans.setLoanPayable(rs.getDouble(6));
            return loans;
        }
    }
}
