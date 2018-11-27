package firstyear.project.repositories;

import firstyear.project.models.SalesOverview;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class SalesOverviewRepoImpl extends JdbcFix implements SalesOverviewRepo{

    @Override
    public boolean createSalesOverview(SalesOverview so) {
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();

            String stringInsert = "INSERT INTO charlie.salesoverviews VALUE (default, '" + so.getDateString() + "', " + so.getCredit() + ", "+ so.getCash() +","+ so.getTill()+","+ so.getVault()+",'"+so.getComment()+"'); ";

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
    public boolean updateSalesOverview(SalesOverview so) {
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            String stringUpdate = "UPDATE salesoverviews SET date='"+ so.getDateString() +"', credit='" + so.getCredit() +"', cash='"+ so.getCash()+ "',till='"+ so.getTill()+"',+ vault ='" + so.getVault() +"', comment =" + so.getComment();
            System.out.println(stringUpdate);
            statement.execute(stringUpdate);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    @Override
    public SalesOverview getSalesOverview(int index) {
        return null;
    }
}
