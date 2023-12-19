package com.olukunle.java_payment_task.service;

import com.olukunle.java_payment_task.constants.StringValues;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MobileDeviceService implements DeviceService{
    @Override
    public void validateDevice() {
        log.info("Channel ---> {}", StringValues.MOBILE_CHANNEL);
    }

    @Override
    public String getDeviceType() {
        return StringValues.MOBILE_CHANNEL;
    }
}
