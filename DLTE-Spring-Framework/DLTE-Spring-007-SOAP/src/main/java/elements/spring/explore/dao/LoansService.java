package elements.spring.explore.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class LoansService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String proceduralDelete(long loanId){

        CallableStatementCreator creator=con -> {
            CallableStatement statement=con.prepareCall("{call mybank_loans_deletion(?,?)}");
            statement.setLong(1,loanId);
            statement.registerOutParameter(2, Types.VARCHAR);
            return statement;
        };

        Map<String,Object> returnedExecution = jdbcTemplate.call(creator, Arrays.asList(
                new SqlParameter[]{
                        new SqlParameter(Types.NUMERIC),
                        new SqlOutParameter("errOrInfo",Types.VARCHAR),
                }
        ));

        return returnedExecution.get("errOrInfo").toString();

    }

    public String closeLoan(long loanId){
        int acknowledge = jdbcTemplate.update("delete from mybank_loans where loan_id=?",new Object[]{loanId});
        if(acknowledge!=0)
            return loanId+" has closed";
        else
            return "Invalid "+loanId;
    }

    public Loans updateLoans(Loans loans){
        int acknowledge = jdbcTemplate.update("update mybank_loans set loan_tenure=?, loan_interest=?, loan_payable=? where loan_id=?",
                new Object[]{loans.getLoanTenure(),loans.getLoanInterest(),loans.getLoanPayable(),loans.getLoanId()});
        if(acknowledge!=0)
            return loans;
        else
            return null;
    }

    public List<Loans> readByTenure(int minTenure, int maxTenure){
        List<Loans> shortlisted = jdbcTemplate.query("select * from mybank_loans where loan_tenure between ? and ?",
                new Object[]{minTenure,maxTenure},new LoansMapper());
        return shortlisted;
    }

    public Loans publishNewLoan(Loans loans){
        int acknowledge = jdbcTemplate.update("insert into mybank_loans values(mybank_loan_seq.nextval,?,?,?,?,?)",
                new Object[]{loans.getLoanPrinciple(),loans.getLoanBorrower(),loans.getLoanTenure(),
                        loans.getLoanInterest(),loans.getLoanPayable()});
        if(acknowledge!=0)
            return loans;
        else
            return null;
    }

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
