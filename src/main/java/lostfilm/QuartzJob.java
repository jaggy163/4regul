package lostfilm;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class QuartzJob implements Job
{
    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String line, all="", str, report="";

        try {
            url = new URL("http://www.lostfilm.tv/series/Game_of_Thrones");
            is = url.openStream();
            //br = new BufferedReader(new FileReader("D:\\lostfilm.html")); // test
            br = new BufferedReader(new InputStreamReader(is));
            while ((line=br.readLine()) != null) {
                all+=line;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        all = all.substring(all.indexOf("<table"));
        Scanner scanner = new Scanner(all);
        scanner.useDelimiter("<tr");
        scanner.next();

        while(scanner.hasNext()) {
            str=scanner.next();
            if (str.contains("not-available")) {
                str = str.substring((str.indexOf("<td class=\"beta\" onClick=\"goTo")));
                str = str.substring(str.indexOf("\">") + 2);
                str = str.substring(0, (str.indexOf("</td>")));
                report += str + " - НЕ ВЫШЛА\n";
            } else {
                str = str.substring((str.indexOf("<td class=\"beta\" onClick=\"goTo")));
                str = str.substring(str.indexOf("\">") + 2);
                str = str.substring(0, (str.indexOf("</td>")));
                report += str + " - ВЫШЛА\n";
            }
        }
        System.out.println(report);
        if (report.contains("8 сезон 1 серия - ВЫШЛА")) {
            System.out.println("Вышла, качаем!");
            report = "ИГРА ПРЕСТОЛОВ ВЫШЛА!!!\n" + report;
        } else {
            System.out.println("Ждем...");
            report = "Еще нет. . .\n" + report;
        }
        System.out.println("вызываем");
        (new Report(report)).run();
        System.out.println("выходим");

    }
}