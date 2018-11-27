package firstyear.project.repositories;

import firstyear.project.models.SalesOverview;
import org.springframework.stereotype.Repository;

import java.sql.Statement;

@Repository
public class SalesOverviewRepoImpl extends JdbcFix implements SalesOverviewRepo{

    @Override
    public boolean createSalesOverview(SalesOverview so) {
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();

            String stringInsert = "INSERT INTO salesOverviews VALUE (default, '" + so.getDate() + "', " + so.getCredit() + ", "+ so.getCash() +","+ so.getTill()+","+ so.getVault()+","+so.getComment()+"); ";

            statement.execute(stringInsert);


            closeConnection(connection);
            return true;
        } catch (Exception e) { e.printStackTrace();}
        return false;
    }

    @Override
    public boolean deleteSalesOverview(int index) {
        return false;
    }

    @Override
    public boolean updateSalesOverview(SalesOverview salesOverview) {
        return false;
    }

    @Override
    public SalesOverview getSalesOverview(int index) {
        return null;
    }
}
