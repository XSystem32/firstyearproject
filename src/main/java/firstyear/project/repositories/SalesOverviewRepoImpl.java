package firstyear.project.repositories;

import firstyear.project.models.SalesOverview;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.ResultSet;
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
    public boolean updateSalesOverview(SalesOverview salesOverview) {
        return false;
    }

    @Override
    public SalesOverview getSalesOverview(int index) {
        //TODO VLC - virker ikke lige nu.
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            String stringGet = "SELECT " +
                    "       salesOverviewId, \n" +
                    "       date, \n" +
                    "       credit, \n" +
                    "       cash, \n" +
                    "       till, \n" +
                    "       vault, \n" +
                    "       comment" +
                    "FROM salesoverviews \n" +
                    "WHERE salesOverviewId ="+ index +";";

            statement.executeQuery(stringGet);
            ResultSet result = statement.getResultSet();
            result.next();

            SalesOverview so = new SalesOverview();

            so.setId(result.getInt("salesOverviewId"));

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = dateFormat.format(new Date());
            //Date date = dateFormat.parse(result.getString("date"));




//            movie.setMovie_id(result.getInt("movie_id"));
  //          movie.getGenre().setGenre_id(result.getInt("genre_id"));
    //        movie.getGenre().setGenre(result.getString("genre"));
      //      movie.setProductionYear(result.getInt("productionYear"));
        //    movie.setTitle(result.getString("title"));

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
