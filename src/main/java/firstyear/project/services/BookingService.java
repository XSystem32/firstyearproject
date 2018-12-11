package firstyear.project.services;

import firstyear.project.models.Booking;
import firstyear.project.repositories.bookingRepo.BookingRepo;
import firstyear.project.repositories.bookingRepo.BookingRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookingService implements BookingRepo {

    @Autowired
    BookingRepoImpl bookingRepo;

    @Override
    public boolean createBooking(Booking booking) {
        bookingRepo.createBooking(booking);
        return true;
    }

    @Override
    public boolean deleteBooking(int index) {
        bookingRepo.deleteBooking(index);
        return true;
    }

    @Override
    public boolean updateBooking(Booking booking) {
        bookingRepo.updateBooking(booking);
        return true;
    }

    @Override
    public Booking getBooking(int index) {
        return bookingRepo.getBooking(index);
    }

    @Override
    public List<Booking> getBookings() {
        return null;
    }
}
