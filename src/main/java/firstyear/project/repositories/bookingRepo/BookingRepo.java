package firstyear.project.repositories.bookingRepo;


import firstyear.project.models.Booking;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepo {

    boolean createBooking(Booking booking);
    boolean deleteBooking(int index);
    boolean updateBooking(Booking booking);
    Booking getBooking(int index);
    List<Booking> getBookings();

}
