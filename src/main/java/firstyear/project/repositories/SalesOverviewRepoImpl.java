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

            String stringInsert = "INSERT INTO charlie.saleoverviews VALUE (default, '" + so.getDateString() + "', " + so.getCredit() + ", "+ so.getCash() +","+ so.getTill()+","+ so.getVault()+",'"+so.getComment()+"'); ";

            System.out.println(stringInsert);
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
