package firstyear.project.services;

import firstyear.project.models.SalesOverview;
import firstyear.project.repositories.SalesOverviewRepo;
import org.springframework.stereotype.Service;

@Service
public class SalesOverviewService implements SalesOverviewRepo {

    @Override
    public boolean createSalesOverview(SalesOverview salesOverview) {
        return false;
    }

    @Override
    public boolean deleteSalesOverview(int index) {
        return false;
    }

    @Override
    public boolean updateSalesOverview(SalesOverview salesOverview) {
        return false;
    }

    @Override
    public SalesOverview getSalesOverview(int index) {
        return null;
    }
}
