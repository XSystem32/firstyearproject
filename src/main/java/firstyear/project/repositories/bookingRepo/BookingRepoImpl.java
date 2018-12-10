package firstyear.project.repositories.bookingRepo;

import firstyear.project.models.Booking;
import firstyear.project.models.SalesOverview;
import firstyear.project.models.User;
import firstyear.project.repositories.JdbcFix;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
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
                    "',"+booking.getWebsite()+"); ";

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
                    "', website ='" + booking.getWebsite()+ "'" +
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
            booking.setBandName(result.getString("bandName"));
            booking.setbandDate(result.getDate("bandDate"));
            booking.setBandCost(result.getDouble("bandCost"));
            booking.setBandEmail(result.getString("bandEmail"));
            booking.setBandPhone(result.getInt("bandPhone"));
            booking.setContactName(result.getString("contactName"));
            booking.setWebsite(result.getString("website"));

            return booking;

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
    public List<Booking> getBookings() {
        List<Booking> bookings = new ArrayList<>();
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            String stringGet = "SELECT * FROM charlie.bookings ";

            statement.executeQuery(stringGet);
            ResultSet result = statement.getResultSet();

            while (result.next()){
                Booking booking = new Booking();
                booking.setBookingId(result.getInt("bookingId"));
                booking.setBandName(result.getString("bandName"));
                booking.setbandDate(result.getDate("bandDate"));
                booking.setBandCost(result.getDouble("bandCost"));
                booking.setBandEmail(result.getString("bandEmail"));
                booking.setBandPhone(result.getInt("bandPhone"));
                booking.setContactName(result.getString("contactName"));
                booking.setWebsite(result.getString("website"));
                bookings.add(booking);
            }
            return bookings;

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
