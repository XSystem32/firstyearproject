package firstyear.project.repositories.bookingRepo;

import firstyear.project.models.Booking;
import firstyear.project.models.SalesOverview;
import firstyear.project.repositories.JdbcFix;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

public class BookingRepoImpl extends JdbcFix implements BookingRepo {

    @Override
    public boolean createBooking(Booking booking) {
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();

            String stringInsert = "INSERT INTO charlie.bookings VALUE (default, '" + booking.getBandName() +
                    "', " + booking.getBandName() +
                    ", "+ booking.getBandDate() +
                    ","+ booking.getBandCost()+
                    ","+ booking.getBandEmail()+
                    ",'"+booking.getBandPhone()+
                    "','"+booking.getContactName()+
                    "',"+booking.getWebside()+"); ";

            System.out.println(stringInsert);
            statement.execute(stringInsert);

            return true;
        } catch (Exception e) { e.printStackTrace();} finally {
            closeConnection(connection);
        }
        return false;
    }

    @Override
    public boolean deleteBooking(int index) {
        try {
        connection = getConnection();
        Statement statement = connection.createStatement();
        String stringDelete = "DELETE FROM charlie.bookings  WHERE bookingId =" + index + ";";
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
    public boolean updateBooking(Booking booking) {
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            String stringUpdate = "UPDATE charlie.bookings SET bandName='"+ booking.getBandName() +"" +
                    "', bandeDate='" + booking.getBandDate() +"" +
                    "', bandCost='"+ booking.getBandCost()+ "" +
                    "',bandEmail='"+ booking.getBandEmail()+"" +
                    "', bandPhone ='" + booking.getBandPhone() +"" +
                    "', contactName ='" + booking.getContactName() + "" +
                    "', webside ='" + booking.getWebside()+ "'" +
                    " WHERE bookingId = "+ booking.getBookingId() +";";
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
    public Booking getBooking(int index) {
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            String stringGet = "SELECT * FROM charlie.bookings WHERE bookingId ="+ index +";";

            statement.executeQuery(stringGet);
            ResultSet result = statement.getResultSet();
            result.next();

            Booking booking = new Booking();



            booking.setBookingId(result.getInt("bookingId"));
            booking.setBandName(result.getString("date"));
            booking.setBandDate(result.getLocalDate("credit"));
            booking.setBandCost(result.getDouble("cash"));
            booking.setBandEmail(result.getString("till"));
            booking.setBandPhone(result.getInt("vault"));
            booking.setContactName(result.getString("comment"));
            booking.setWebside(result.getString("comment"));

            return booking;

        } catch (Exception e) {
            e.printStackTrace();
            return null;} finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

    @Override
    public List<Booking> getBookings() {
        return null;
    }
}
