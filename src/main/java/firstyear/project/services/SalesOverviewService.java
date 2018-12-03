package firstyear.project.services;

import firstyear.project.models.SalesOverview;
import firstyear.project.repositories.SalesOverviewRepo;
import firstyear.project.repositories.SalesOverviewRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
public class SalesOverviewService implements SalesOverviewRepo {

    @Autowired
    SalesOverviewRepoImpl salesOverviewRepo;

    @Override
    public List<SalesOverview> getSalesOverviews(LocalDate start, LocalDate end) {
        return salesOverviewRepo.getSalesOverviews(start, end);
    }

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



    public boolean getCsv(LocalDate start, LocalDate end){
        // snak med faisal om path til csv
        File file = new File("c://tmp//testFile1s.csv");
        String header =  "Date,cash,card,till,vault,comment";
        FileWriter writer;

        try {
            writer = new FileWriter(file);
            writer.write(header+System.getProperty("line.separator"));

            for (SalesOverview obj: getSalesOverviews(start, end)) {
                String data = (obj.getDate()+","+obj.getCash()+","+obj.getCredit()+","+obj.getTill()+","+obj.getVault()+","+obj.getComment()+System.getProperty("line.separator"));
                writer.write(data);
                System.out.println(data);
                System.out.println(obj);

        }
        writer.close();
        } catch (IOException e) { e.printStackTrace(); }
        return true;
    }

}
