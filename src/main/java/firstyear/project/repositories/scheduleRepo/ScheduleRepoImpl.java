package firstyear.project.repositories.scheduleRepo;

import firstyear.project.controllers.salesOverviewController.SalesOverviewController;
import firstyear.project.models.SalesOverview;
import firstyear.project.models.Schedule;
import firstyear.project.models.Shift;
import firstyear.project.repositories.JdbcFix;
import firstyear.project.services.ShiftService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class ScheduleRepoImpl extends JdbcFix implements ScheduleRepo {

    @Autowired
    ShiftService shiftService;

    private static final Logger LOGGER = Logger.getLogger(ScheduleRepoImpl.class.getName());

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

    public Schedule createScheduleFromDate(String date) {
        LOGGER.info("createScheduleFromDate was called with date " + date);
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();

            String stringInsert = "INSERT INTO charlie.schedules (scheduleId, scheduleDate) VALUE (default, '" + date + "' ); ";

            statement.execute(stringInsert);

            Schedule schedule = new Schedule();

            String lastInsertId = "SELECT LAST_INSERT_ID();";
            statement.executeQuery(lastInsertId);
            ResultSet result = statement.getResultSet();
            result.next();
            schedule.setScheduleId(result.getInt(1));
            schedule.setScheduleDate(LocalDate.parse(date));

            

            return schedule;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return null;
    }


    public boolean deleteSchedule(int index) {
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            String stringDelete = "DELETE FROM charlie.schedules WHERE scheduleId =" + index + ";";
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

    public Schedule getScheduleByDate(String date) {
        LOGGER.info("repo getScheduleByDate was called with: " + date);
        try {
            connection = getConnection();

            Statement statement = connection.createStatement();
            String stringGet = "SELECT * FROM charlie.schedules WHERE scheduleDate = '" + date + "';";

            statement.executeQuery(stringGet);
            ResultSet result = statement.getResultSet();
            Schedule schedule = new Schedule();

            if (result.next() != false) {
                LOGGER.info("Creating the object as intended");
                schedule.setScheduleId(result.getInt("scheduleId"));
                schedule.setStart(result.getString("openingTime"));
                schedule.setEnd(result.getString("closingTime"));
                schedule.setScheduleDate(LocalDate.parse(result.getString("scheduleDate")));
            } else {
                LOGGER.info("returning a dummy with ID 0 since none was found.");
                schedule.setScheduleId(0);
            }
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
            schedule.setStart(result.getString("openingTime"));
            schedule.setEnd(result.getString("closingTime"));
            schedule.setScheduleDate(LocalDate.parse(result.getString("scheduleDate")));

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
            String stringGet =
                    "SELECT * FROM charlie.schedules " +
                    "LEFT JOIN charlie.shifts ON charlie.schedules.scheduleId = charlie.shifts.scheduleId WHERE scheduleDate BETWEEN '" + start + "' AND '" + end + "'" +
            "ORDER by scheduleDate asc;";



            System.out.println(stringGet);
            statement.executeQuery(stringGet);
            ResultSet result = statement.getResultSet();

            int lastId = 0;

            while (result.next()) {
                Schedule schedule = new Schedule();
                schedule.setScheduleId(result.getInt("scheduleId"));
                schedule.setStart((result.getString("openingTime")));
                schedule.setEnd(result.getString("closingTime"));
                schedule.setScheduleDate(LocalDate.parse(result.getString("scheduleDate")));
                schedule.setShifts(shiftService.getShifts(result.getInt("scheduleId")));
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