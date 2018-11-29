package firstyear.project.services;

import firstyear.project.models.SalesOverview;
import firstyear.project.repositories.SalesOverviewRepo;
import firstyear.project.repositories.SalesOverviewRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SalesOverviewService implements SalesOverviewRepo {

    @Override
    public List<SalesOverview> getSalesOverviews(Date start, Date end) {
        return null;
    }

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
