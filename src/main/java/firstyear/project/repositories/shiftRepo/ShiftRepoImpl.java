package firstyear.project.repositories.shiftRepo;


import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import firstyear.project.models.Shift;
import firstyear.project.repositories.JdbcFix;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ShiftRepoImpl extends JdbcFix implements ShiftRepo {



    @Override
    public boolean createShift(Shift shift) {
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();

            String stringInsert = "INSERT INTO charlie.shifts VALUE (default, '" + shift.getStart() + "', " + shift.getEnd() + ", " + shift.getUser() +  ", " + shift.getScheduleId() + "); ";


            statement.execute(stringInsert);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return false;
    }

    @Override
    public boolean deleteShift(int index) {
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            String stringDelete = "DELETE FROM charlie.shifts  WHERE shiftId =" + index + ";";
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
    public boolean updateShift(Shift shift) {
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            String stringUpdate = "UPDATE charlie.shifts SET start='"+ shift.getStart() +"" +
                    "', end='" + shift.getEnd() +"" +
                    "', user ='"+ shift.getUser()+ "'" +
                    "', schedule ='"+ shift.getScheduleId()+ "" +
                    " WHERE salesOverviewId = "+ shift.getShiftId() +";";

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
    public Shift getShift(int index) {
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            String stringGet = "SELECT * FROM charlie.shifts WHERE shiftId ="+ index +";";

            statement.executeQuery(stringGet);
            ResultSet result = statement.getResultSet();
            result.next();

            Shift shift = new Shift();



            shift.setShiftId(result.getInt("shiftId"));
            shift.setStart(result.getString("start"));
            shift.setEnd(result.getString("end"));
            return shift;

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
    public List<Shift> getShifts(int scheduleId) {
        List<Shift> shifts = new ArrayList<>();
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            String stringGet = "SELECT * FROM charlie.shifts WHERE scheduleId = " + scheduleId + ";";

            statement.executeQuery(stringGet);
            ResultSet result = statement.getResultSet();

            while (result.next()) {
                Shift shift = new Shift();
                shift.setShiftId(result.getInt("shiftId"));
                shift.setStart(result.getString("start"));
                shift.setEnd(result.getString("end"));
                shift.setScheduleId(result.getInt("scheduleId"));

                shifts.add(shift);
            }
            return shifts;

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
