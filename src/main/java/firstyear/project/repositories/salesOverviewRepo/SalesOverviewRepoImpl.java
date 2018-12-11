package firstyear.project.repositories.salesOverviewRepo;

import firstyear.project.models.SalesOverview;
import firstyear.project.repositories.JdbcFix;
import org.springframework.stereotype.Repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SalesOverviewRepoImpl extends JdbcFix implements SalesOverviewRepo {

    @Override
    public boolean createSalesOverview(SalesOverview so) {
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();

            String stringInsert = "INSERT INTO charlie.salesoverviews VALUE (default, '" + so.getDateString() + "', " + so.getCredit() + ", "+ so.getCash() +","+ so.getTill()+","+ so.getVault()+",'"+so.getComment()+"'); ";

            System.out.println(stringInsert);
            statement.execute(stringInsert);

            return true;
        } catch (Exception e) { e.printStackTrace();} finally {
            closeConnection(connection);
        }
        return false;
    }

    @Override
    public boolean deleteSalesOverview(int index) {
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            String stringDelete = "DELETE FROM charlie.salesoverviews  WHERE salesOverviewId =" + index + ";";
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
            String stringUpdate = "UPDATE charlie.salesoverviews SET date='"+ so.getDateString() +"" +
                    "', credit='" + so.getCredit() +"" +
                    "', cash='"+ so.getCash()+ "" +
                    "',till='"+ so.getTill()+"" +
                    "', vault ='" + so.getVault() +"" +
                    "', comment ='" + so.getComment() + "'" +
                    " WHERE salesOverviewId = "+ so.getSalesOverviewId() +";";
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
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            String stringGet = "SELECT * FROM charlie.salesoverviews WHERE salesOverviewId ="+ index +";";

            statement.executeQuery(stringGet);
            ResultSet result = statement.getResultSet();
            result.next();

            SalesOverview so = new SalesOverview();



            so.setSalesOverviewId(result.getInt("salesOverviewId"));
            so.setDate(result.getDate("date"));
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




    @Override
    public List<SalesOverview> getSalesOverviews(LocalDate start, LocalDate end) {
        List<SalesOverview> salesOverviews = new ArrayList<>();
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            String stringGet = "SELECT * FROM charlie.salesoverviews WHERE date BETWEEN '" + start + "' AND '" + end +"' ORDER by date asc;";

            System.out.println(stringGet);
            statement.executeQuery(stringGet);
            ResultSet result = statement.getResultSet();

            while (result.next()){
                SalesOverview so = new SalesOverview();
                so.setSalesOverviewId(result.getInt("salesOverviewId"));
                so.setDate(result.getDate("date"));
                so.setCredit(result.getDouble("credit"));
                so.setCash(result.getDouble("cash"));
                so.setTill(result.getDouble("till"));
                so.setVault(result.getDouble("vault"));
                so.setComment(result.getString("comment"));
                so.getTotal();
                salesOverviews.add(so);
            }
            return salesOverviews;

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
