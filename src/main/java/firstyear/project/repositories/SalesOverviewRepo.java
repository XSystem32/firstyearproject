package firstyear.project.repositories;

import firstyear.project.models.SalesOverview;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface SalesOverviewRepo {

    boolean createSalesOverview(SalesOverview salesOverview);
    boolean deleteSalesOverview(int index);
    boolean updateSalesOverview(int index, SalesOverview salesOverview);
    SalesOverview getSalesOverview(int index);
    List<SalesOverview> getSalesOverviews(LocalDate start, LocalDate end);
}
