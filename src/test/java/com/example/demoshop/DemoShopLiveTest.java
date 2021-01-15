package com.example.demoshop;

import com.example.demoshop.controller.MainController;
import com.example.demoshop.model.Product;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DemoShopLiveTest {

    @Autowired
    private MainController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

}
