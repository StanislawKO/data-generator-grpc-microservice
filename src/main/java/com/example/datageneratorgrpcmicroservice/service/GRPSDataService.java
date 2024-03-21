package com.example.datageneratorgrpcmicroservice.service;

import com.example.datageneratorgrpcmicroservice.model.Data;

import java.util.List;

public interface GRPSDataService {

    void send(Data data);

    void send(List<Data> data);

}
