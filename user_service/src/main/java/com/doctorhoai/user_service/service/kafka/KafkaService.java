package com.doctorhoai.user_service.service.kafka;

import com.doctorhoai.user_service.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import java.util.concurrent.CompletableFuture;
import org.springframework.stereotype.Service;
import org.springframework.kafka.support.SendResult;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaService {
    private final NewTopic newTopic;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendEventToTopic( UserDto userDto){
        CompletableFuture<SendResult<String,Object>> future =  kafkaTemplate.send("version4", userDto);
        future.whenComplete( ( result, throwable) -> {
            if( throwable == null ){
                log.info("Sent message = [ {} ] with offset = [ {} ] , partitions = [ {} ]", userDto.toString(), result.getRecordMetadata().offset(), result.getRecordMetadata().partition());
            }else{
                log.error("Unable to send message = [ {} ] due to : {}", userDto.toString(), throwable.getMessage());
            }
        } );
    }
}
