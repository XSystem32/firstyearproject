package firstyear.project.repositories;

import firstyear.project.models.SalesOverview;
import org.springframework.stereotype.Repository;

@Repository
public class SalesOverviewRepoImpl implements SalesOverviewRepo{

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
