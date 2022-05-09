package com.example.readCSV;

import com.example.readCSV.Service.ReadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ReadCsvApplication {


	public static void main(String[] args) throws IOException {

		SpringApplication.run(ReadCsvApplication.class, args);
		// created object of service as there is no rest api implemented to call it
		ReadFileService readFileService = new ReadFileService();
		readFileService.readFileUsingScanner();
		readFileService.readFileUsingBufferReader();
		readFileService.readFileUsingBufferReaderIntoPOJO();
		readFileService.readFileUsingCSVReader();
		readFileService.readFileUsingApacheCommonsCSV();
		readFileService.readFileUsingApacheCommonsCSV();

	}

}
