package firstyear.project.repositories.scheduleRepo;

import firstyear.project.models.Schedule;
import firstyear.project.repositories.JdbcFix;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ScheduleRepoImpl extends JdbcFix implements ScheduleRepo {

    //@Autowired
    //shiftrepo goes here

    public boolean createSchedule(Schedule schedule) {
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();

            String stringInsert = "INSERT INTO charlie.schedule VALUE (default, '" + schedule.getOpeningTime() + "', " + schedule.getClosingTime() + ", " + schedule.getShifts() + "," + schedule.getBookings() + "); ";

            System.out.println(stringInsert);
            statement.execute(stringInsert);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return false;
    }


    public boolean deleteSchedule(int index) {
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            String stringDelete = "DELETE FROM charlie.schedule  WHERE scheduleId =" + index + ";";
            statement.execute(stringDelete);


            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    public boolean updateSchedule(Schedule schedule) {
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            String stringUpdate = "UPDATE charlie.schedules SET start='" + schedule.getOpeningTime() + "" +
                    "', end ='" + schedule.getClosingTime() + "" +
                    "', shifts='" + schedule.getShifts() + "" +
                    "',bookings='" + schedule.getBookings() + "'" +
                    " WHERE ScheduleId = " + schedule.getScheduleId() + ";";
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

    public Schedule getSchedule(int index) {
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            String stringGet = "SELECT * FROM charlie.schedules WHERE scheduleId =" + index + ";";

            statement.executeQuery(stringGet);
            ResultSet result = statement.getResultSet();
            result.next();

            Schedule schedule = new Schedule();


            schedule.setScheduleId(result.getInt("scheduleId"));
            schedule.setStart(result.getString("start"));
            schedule.setEnd(result.getString("end"));
            //schedule.setShifts(get shift, use metoed from shiftrepo

            return schedule;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Schedule> getSchedules(LocalDate start, LocalDate end) {
        List<Schedule> schedules = new ArrayList<>();
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            String stringGet = "SELECT * FROM charlie.schedules WHERE scheduleDate BETWEEN '" + start + "' AND '" + end + "' ORDER by scheduleDate asc;";

            System.out.println(stringGet);
            statement.executeQuery(stringGet);
            ResultSet result = statement.getResultSet();

            while (result.next()) {
                Schedule schedule = new Schedule();
                schedule.setScheduleId(result.getInt("scheduleId"));
                schedule.setStart((result.getString("openingTime")));
                schedule.setEnd(result.getString("closingTime"));
                schedule.setScheduleDate(LocalDate.parse(result.getString("scheduleDate")));
                schedules.add(schedule);
            }
            return schedules;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}