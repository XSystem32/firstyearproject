package firstyear.project.services;


import firstyear.project.models.Shift;
import firstyear.project.repositories.shiftRepo.ShiftRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiftService implements ShiftRepo {

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
    public List<Shift> getShifts() {
        return null;
    }
}
