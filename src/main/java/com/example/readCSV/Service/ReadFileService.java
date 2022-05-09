package com.example.readCSV.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.example.readCSV.Service.model.Professor;
import com.google.gson.GsonBuilder;
import com.opencsv.CSVReader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class ReadFileService {

    String filePath = "C:\\Users\\jyoth\\Documents\\Input2.csv";
    public void readFileUsingScanner(){
        try{
            Scanner scanner = new Scanner(new File(filePath));
            System.out.println("Fetching Data using Scanner: ");
            while(scanner.hasNext()){
                 System.out.println(scanner.next().toString());
            }
            scanner.close();
            System.out.println("=============================================");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void readFileUsingBufferReader() throws IOException{
        String line = "";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        //line = reader.readLine();
        System.out.println("Fetching Data using Buffered Reader: ");
        while((line = reader.readLine()) != null){
            System.out.println(line);
        }
        System.out.println("=============================================");
    }

    public void readFileUsingBufferReaderIntoPOJO() throws IOException{
        String line = "";
        String delimiter = ",";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        //line = reader.readLine();
        System.out.println("Fetching Data using Buffered Reader and displaying in form of Model Professor ");
        while((line = reader.readLine()) != null){
            String[] data = line.split(delimiter);
            Professor professor = new Professor(data[0], data[1], Integer.valueOf(data[2]), data[3]);
            System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(professor));
        }
        System.out.println("=============================================");
    }

    public void readFileUsingCSVReader() throws IOException {
        String delimiter = ",";
        Reader reader = Files.newBufferedReader(Paths.get(filePath));
        CSVReader csvReader = new CSVReader(reader);
        String[] line;
        System.out.println("Fetching Data using CSV Reader");
        while((line = csvReader.readNext()) != null){
            System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(Arrays.asList(line)));
        }
        System.out.println("=============================================");
    }

    public void readFileUsingApacheCommonsCSV() throws IOException{
        Reader reader = Files.newBufferedReader(Paths.get(filePath));
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(reader);
        //CSVParser records = CSVFormat.DEFAULT.parse(reader);
        //Professor professor = new Professor();
        System.out.println("Fetching Data using Apache Common CSV");
        //List<Professor>  list = new ArrayList<>();
        for (CSVRecord record : records) {
            Professor professor = new Professor(record.get(0), record.get(1), Integer.valueOf(record.get(2)), record.get(3));
            //list.add(professor);
            System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(professor));
        }
        System.out.println("=============================================");
    }

}
