package firstyear.project.services;


import firstyear.project.models.Shift;
import firstyear.project.repositories.shiftRepo.ShiftRepo;
import firstyear.project.repositories.shiftRepo.ShiftRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiftService implements ShiftRepo {

    @Autowired
    ShiftRepoImpl shiftRepo;

    @Override
    public boolean createShift(Shift shift) {
        return false;
    }

    @Override
    public boolean deleteShift(int index) {
        return false;
    }

    @Override
    public boolean updateShift(Shift shift) {
        return false;
    }

    @Override
    public Shift getShift(int index) {

        return null;
    }

    @Override
    public List<Shift> getShifts(int scheduleId) {
        return shiftRepo.getShifts(scheduleId);
    }
}
