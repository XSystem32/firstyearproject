package firstyear.project.repositories;

import firstyear.project.models.SalesOverview;
import org.springframework.stereotype.Repository;


import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

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
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            String stringDelete = "DELETE FROM salesoverviews  WHERE salesOverviewId =" + index + ";";
            statement.execute(stringDelete);


            return true;
        } catch (Exception e) { e.printStackTrace();} finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
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
        //TODO VLC - virker ikke lige nu.
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            String stringGet = "SELECT * FROM charlie.salesoverviews WHERE salesOverviewId ="+ index +";";

            statement.executeQuery(stringGet);
            ResultSet result = statement.getResultSet();
            result.next();

            SalesOverview so = new SalesOverview();

            so.setId(result.getInt("salesOverviewId"));

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


            Date tempDate = result.getDate("date");

            String dateString = dateFormat.format(tempDate);

            //so.setDate();
            so.setCredit(result.getDouble("credit"));
            so.setCash(result.getDouble("cash"));
            so.setTill(result.getDouble("till"));
            so.setVault(result.getDouble("vault"));
            so.setComment(result.getString("comment"));





            return so;

        } catch (Exception e) {
            e.printStackTrace();
            return null;} finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
