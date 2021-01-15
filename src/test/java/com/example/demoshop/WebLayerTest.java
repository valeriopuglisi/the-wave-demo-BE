package com.example.demoshop;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demoshop.controller.MainController;
import com.example.demoshop.model.Compare;
import com.example.demoshop.model.Product;
import com.example.demoshop.repository.CompareRepository;
import com.example.demoshop.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
@WebMvcTest(MainController.class)
public class WebLayerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private CompareRepository compareRepository;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void productsRequestMatching() throws Exception {
        this.mockMvc.
                perform(get("/api/all/")).
                andDo(print()).
                andExpect(status().isOk());
    }

   @Test
   public void compareRequestMatching() throws Exception {

       Product p1 = new Product();
       p1.setName("p1");
       p1.setDiscount((float) 10);
       p1.setPrice((float) 599);
       productRepository.save(p1);

       Product p2 = new Product();
       p2.setName("p3");
       p2.setDiscount((float) 10);
       p2.setPrice((float) 599);
       productRepository.save(p2);

       Product p3 = new Product();
       p3.setName("p3");
       p3.setDiscount((float) 10);
       p3.setPrice((float) 599);
       productRepository.save(p3);

       Compare c = new Compare();
       c.setProdOne(p1);
       c.setProdTwo(p2);
       c.setProdThree(p3);

       this.mockMvc.
               perform(post("/api/compare/").
                       contentType("application/json").
                       content(objectMapper.writeValueAsString(c))).
                        andDo(print()).
                        andExpect(status().isOk());
   }
}
