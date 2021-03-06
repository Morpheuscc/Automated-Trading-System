/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Validation;
import au.com.bytecode.opencsv.*;
import au.com.bytecode.opencsv.bean.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author Christopher
 */
public class QuoteData {
    double closePrice, openPrice, high, low;
    double volume, SP500, forIndex, range, change;
    String date;

    public void setSP500(double SP500){
        this.SP500 = SP500;
    }
    
    public double getSP500(){
        return this.SP500;
    }
    
    public void setforIndex(double forIndex){
        this.forIndex = forIndex;
    }
    
    public double getforIndex(){
        return this.forIndex;
    }
    
    public void setRange(double Range){
        this.range = Range;
    }
    
    public double getRange(){
        return this.range;
    }
    
    public void setChange(double Change){
        this.change = Change;
    }
    
    public double getChange(){
        return this.change;
    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(double closePrice) {
        this.closePrice = closePrice;
    }

    public double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(double openPrice) {
        this.openPrice = openPrice;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
    

    public static List<QuoteData> loadData(String nameFile)throws IOException{
        HeaderColumnNameTranslateMappingStrategy<QuoteData> strategy = new HeaderColumnNameTranslateMappingStrategy<QuoteData>();
        strategy.setType(QuoteData.class);

        Hashtable<String,String> mapping = new Hashtable<String,String>();
        mapping.put("Date", "date");
        mapping.put("Close", "closePrice");
        mapping.put("High", "high");
        mapping.put("Low", "low");
        mapping.put("Open", "openPrice");
        mapping.put("Volume", "volume");
        mapping.put("SP500", "SP500");
        mapping.put("Range", "range");
        mapping.put("Change", "change");
        mapping.put("ForIndex", "ForIndex");

        strategy.setColumnMapping(mapping);

        CSVReader csvReader = new CSVReader(new FileReader(nameFile));

        CsvToBean csv = new CsvToBean();

        List<QuoteData> list = csv.parse(strategy, csvReader);
//        for(int i = 0;i< list.size(); i++){
//                QuoteData quoteData = list.get(i);
//                //display CSV values
//                System.out.println("Date: " + quoteData.getDate());
//                System.out.println("Close Price: " + quoteData.getClosePrice());
//                System.out.println("Low: " + quoteData.getLow());
//                System.out.println("Open Price: " + quoteData.getOpenPrice());
//                System.out.println("Volume:" + quoteData.getVolume());
//                System.out.println("---");
//            }

        return list;
    }
}
