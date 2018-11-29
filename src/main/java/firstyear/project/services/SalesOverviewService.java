package firstyear.project.services;

import firstyear.project.models.SalesOverview;
import firstyear.project.repositories.SalesOverviewRepo;
import firstyear.project.repositories.SalesOverviewRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesOverviewService implements SalesOverviewRepo {

    @Autowired
    SalesOverviewRepoImpl salesOverviewRepo;

    @Override
    public boolean createSalesOverview(SalesOverview salesOverview) {
        salesOverviewRepo.createSalesOverview(salesOverview);
        return true;

    }

    @Override
    public boolean deleteSalesOverview(int index) {
        return false;
    }

    public boolean updateSalesOverview(int index, SalesOverview salesOverview) {
        salesOverviewRepo.updateSalesOverview(index, salesOverview);
        return true;
    }

    @Override
    public SalesOverview getSalesOverview(int index) {
        return salesOverviewRepo.getSalesOverview(index);
    }
}
