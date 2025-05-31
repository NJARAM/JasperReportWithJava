package com.everdigitio;

import com.everdigitio.beans.ScoreCardDetails;
import com.everdigitio.beans.StudentDetails;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App 
{
    public static void main( String[] args )
    {
String jasperFilePath = new File("src/main/resources/reports/StudentScoreCard.jasper").getAbsolutePath();

        try {
            // Step 1. Obtain Jasper Class Object
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File(jasperFilePath));

            //Step 2. Create Datasource class object
            List<StudentDetails> studentDetailsList = new ArrayList<>();
            studentDetailsList.add(new StudentDetails("Moses Muchoki","2025","Kelvin Omieno","2024-2025"));
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(studentDetailsList);
           List<ScoreCardDetails> scoreCardDetailsList = new ArrayList<>();
           scoreCardDetailsList.add(new ScoreCardDetails("Subject 1",50,49));
            scoreCardDetailsList.add(new ScoreCardDetails("Subject 2",50,48));
            scoreCardDetailsList.add(new ScoreCardDetails("Subject 3",50,47));
            scoreCardDetailsList.add(new ScoreCardDetails("Subject 4",50,46));
            scoreCardDetailsList.add(new ScoreCardDetails("Subject 5",50,45));
            JRBeanCollectionDataSource tableDataSource = new JRBeanCollectionDataSource(scoreCardDetailsList);
            // Step 3. Create a HashMap Object to store parameters
            Map<String,Object> parameters = new HashMap<>();
            parameters.put("TABLE_DATA_SOURCE",tableDataSource);

            // Step 4. Create a Jasper Print Object
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,dataSource);

            // Step 5. Export your Jasper Print report object to your desired report format e.g. pdf
            JasperExportManager.exportReportToPdfFile(jasperPrint,"C:\\Users\\MosesNM\\java23_2025\\moses\\GeneratedReports\\StudentScoreCard.pdf");
            System.out.println("Student Score Report Generated Successfully ...");
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
}
