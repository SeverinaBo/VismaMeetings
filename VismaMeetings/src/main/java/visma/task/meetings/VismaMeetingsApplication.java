package visma.task.meetings;

import visma.task.meetings.meetingModel.Meeting;

import visma.task.meetings.service.MeetingServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class VismaMeetingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(VismaMeetingsApplication.class, args);
	}



	@Bean
	CommandLineRunner runner(MeetingServiceImpl meetingServiceImpl){
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Meeting>> typeReference = new TypeReference<List<Meeting>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/meetings.json");
			mapper.registerModule(new JavaTimeModule());
			try {
				List<Meeting> meeting = mapper.readValue(inputStream,typeReference);
				meetingServiceImpl.saveAll(meeting);
				System.out.println("Meeting Saved!");

			} catch (IOException e){
				System.out.println("Unable to save meeting: " + e.getMessage());
			}
	};	}}
