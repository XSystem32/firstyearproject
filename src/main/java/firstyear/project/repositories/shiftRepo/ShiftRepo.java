package firstyear.project.repositories.shiftRepo;


import firstyear.project.models.Shift;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShiftRepo {
    boolean createShift(Shift shift);
    boolean deleteShift(int index);
    boolean updateShift(Shift shift);
    Shift getShift(int index);
    List<Shift> getShifts();

}
