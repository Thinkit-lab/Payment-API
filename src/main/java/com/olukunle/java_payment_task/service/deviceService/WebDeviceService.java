package com.olukunle.java_payment_task.service.deviceService;

import com.olukunle.java_payment_task.constants.StringValues;
import com.olukunle.java_payment_task.service.deviceService.DeviceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WebDeviceService implements DeviceService {
    @Override
    public void validateDevice() {
        log.info("Channel ---> {}", StringValues.WEB_CHANNEL);
    }

    @Override
    public String getDeviceType() {
        return StringValues.WEB_CHANNEL;
    }
}
