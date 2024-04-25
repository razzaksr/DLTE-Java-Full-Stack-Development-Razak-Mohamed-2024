package soap.rest.wsdl.thyme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class LoansService implements LoansRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Loans save(Loans loans) {
        jdbcTemplate.update("insert into mybank_available_loans values(mybank_available_loans_seq.nextval,?,?,?,?)",
                new Object[]{loans.getLoanName(),loans.getLoanType(),loans.getLoanDescription(),loans.getLoanRoi()});
        return loans;
    }

    @Override
    public List<Loans> findAll() {
        return jdbcTemplate.query("select * from mybank_available_loans",new LoansMapper());
    }

    @Override
    public Loans findById(int id) {
        return jdbcTemplate.queryForObject("select * from mybank_available_loans where loan_number=?",new Object[]{id},new BeanPropertyRowMapper<>(Loans.class));
    }

    @Override
    public String deleteById(int id) {
        jdbcTemplate.update("delete from mybank_available_loans where loan_number=?",new Object[]{id});
        return "loans deleted";
    }

    @Override
    public Loans update(Loans loans) {
        jdbcTemplate.update("update mybank_available_loans set loan_name=?,loan_type=?,loan_description=?,loan_roi=? where loan_number=?",
                new Object[]{loans.getLoanName(),loans.getLoanType(),loans.getLoanDescription(),loans.getLoanRoi(),loans.getLoanNumber()});
        return loans;
    }

    protected class LoansMapper implements RowMapper<Loans> {

        @Override
        public Loans mapRow(ResultSet rs, int rowNum) throws SQLException {
            Loans loans = new Loans();
            loans.setLoanName(rs.getString("loan_name"));
            loans.setLoanType(rs.getString("loan_type"));
            loans.setLoanDescription(rs.getString("loan_description"));
            loans.setLoanNumber(rs.getInt("loan_number"));
            loans.setLoanRoi(rs.getDouble("loan_roi"));
            return loans;
        }
    }
}
