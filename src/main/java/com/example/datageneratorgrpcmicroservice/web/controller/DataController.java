package com.example.datageneratorgrpcmicroservice.web.controller;

import com.example.datageneratorgrpcmicroservice.model.Data;
import com.example.datageneratorgrpcmicroservice.model.test.DataTestOptions;
import com.example.datageneratorgrpcmicroservice.service.GRPSDataService;
import com.example.datageneratorgrpcmicroservice.service.TestDataService;
import com.example.datageneratorgrpcmicroservice.web.dto.DataDto;
import com.example.datageneratorgrpcmicroservice.web.dto.DataTestOptionsDto;
import com.example.datageneratorgrpcmicroservice.web.mapper.DataMapper;
import com.example.datageneratorgrpcmicroservice.web.mapper.DataTestOptionsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/data")
@RequiredArgsConstructor
public class DataController {

    private final GRPSDataService grpsDataService;
    private final TestDataService testDataService;

    private final DataMapper dataMapper;
    private final DataTestOptionsMapper dataTestOptionsMapper;

    @RequestMapping("/send")
    public void send(@RequestBody DataDto dataDto) {
        Data data = dataMapper.toEntity(dataDto);
        grpsDataService.send(data);
    }

    @RequestMapping("/test/send")
    public void testSend(@RequestBody DataTestOptionsDto testOptionsDto) {
        DataTestOptions testOptions = dataTestOptionsMapper.toEntity(testOptionsDto);
        testDataService.sendMessages(testOptions);
    }

}
