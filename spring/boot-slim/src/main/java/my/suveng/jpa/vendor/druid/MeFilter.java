package my.suveng.jpa.vendor.druid;

import com.alibaba.druid.filter.FilterChain;
import com.alibaba.druid.filter.FilterEventAdapter;
import com.alibaba.druid.proxy.jdbc.ConnectionProxy;
import com.alibaba.druid.proxy.jdbc.PreparedStatementProxy;
import com.alibaba.druid.proxy.jdbc.ResultSetProxy;
import com.alibaba.druid.proxy.jdbc.StatementProxy;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 *
 * @author suwenguang
 * 
 * @version 1.0.0
 **/
@Component(value = "me")
public class MeFilter extends FilterEventAdapter {

    @Override
    protected void statementExecuteUpdateBefore(StatementProxy statement, String sql) {
        System.out.println("insert update # before #语句在这里");
        super.statementExecuteUpdateBefore(statement, sql);
    }

    @Override
    protected void statementExecuteUpdateAfter(StatementProxy statement, String sql, int updateCount) {
        System.out.println("insert update# after # 语句在这里");
        super.statementExecuteUpdateAfter(statement, sql, updateCount);
    }

    @Override
    protected void statementExecuteQueryBefore(StatementProxy statement, String sql) {
        System.out.println("select # before # 语句在这里");
        super.statementExecuteQueryBefore(statement, sql);
    }

    @Override
    protected void statementExecuteQueryAfter(StatementProxy statement, String sql, ResultSetProxy resultSet) {
        System.out.println("select # after # 语句在这里");
        super.statementExecuteQueryAfter(statement, sql, resultSet);
    }

    @Override
    protected void statementExecuteBefore(StatementProxy statement, String sql) {
        System.out.println("DDL # before # 语句在这里");
        super.statementExecuteBefore(statement, sql);
    }

    @Override
    protected void statementExecuteAfter(StatementProxy statement, String sql, boolean result) {
        System.out.println("DDL # after #  语句在这里");
        super.statementExecuteAfter(statement, sql, result);
    }

    @Override
    protected void statementExecuteBatchBefore(StatementProxy statement) {
        System.out.println("批处理 # before");
        super.statementExecuteBatchBefore(statement);
    }

    @Override
    protected void statementExecuteBatchAfter(StatementProxy statement, int[] result) {
        System.out.println("批处理 # after ");
        super.statementExecuteBatchAfter(statement, result);
    }

    @Override
    protected void statement_executeErrorAfter(StatementProxy statement, String sql, Throwable error) {
        System.out.println("错误# after ");
        super.statement_executeErrorAfter(statement, sql, error);
    }
}
