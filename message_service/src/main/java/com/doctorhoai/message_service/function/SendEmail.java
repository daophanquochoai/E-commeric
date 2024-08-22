package com.doctorhoai.message_service.function;

import com.doctorhoai.message_service.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class SendEmail {
    private final ObjectMapper objectMapper;

    //    @RetryableTopic(attempts = "4")
    @KafkaListener(topics = "version4", groupId = "Dth")
    public void consumer( UserDto userDto) {
        try {
            log.info("Received : {} from {} offset {}", objectMapper.writeValueAsString(userDto));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
