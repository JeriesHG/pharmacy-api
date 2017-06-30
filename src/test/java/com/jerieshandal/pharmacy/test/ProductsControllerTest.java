/*
 * Copyright (c) Jeries Handal - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Jeries Handal <Jeries Handal>,  2016.
 */
package com.jerieshandal.pharmacy.test;

import com.jerieshandal.pharmacy.Application;
import com.jerieshandal.pharmacy.entity.BeautyProduct;
import com.jerieshandal.pharmacy.entity.MarketResearch;
import com.jerieshandal.pharmacy.entity.Medicine;
import com.jerieshandal.pharmacy.entity.StockElement;
import com.jerieshandal.pharmacy.repository.BeautyProductRepository;
import com.jerieshandal.pharmacy.repository.MarketResearchRepository;
import com.jerieshandal.pharmacy.repository.MedicineRepository;
import com.jerieshandal.pharmacy.repository.StockElementRepository;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import org.springframework.mock.http.MockHttpOutputMessage;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

/**
 * ProductsControllerTest
 *
 * @author JeriesHG
 * @version 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class ProductsControllerTest {

    private final MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));
    private MockMvc mockMvc;
    private HttpMessageConverter mappingJackson2HttpMessageConverter;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private MedicineRepository medicineRepository;
    @Autowired
    private StockElementRepository stockElementRepository;
    @Autowired
    private BeautyProductRepository beautyProductRepository;
    @Autowired
    private MarketResearchRepository marketResearchRepository;

    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
                .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
                .findAny()
                .orElse(null);

        assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();

        this.marketResearchRepository.deleteAllInBatch();
        this.medicineRepository.deleteAllInBatch();
        this.beautyProductRepository.deleteAllInBatch();
        this.stockElementRepository.deleteAllInBatch();

        StockElement medicineElement = stockElementRepository.save(new StockElement(15.00, 10.00, "Hospital X"));
        StockElement beautyProductElement = stockElementRepository.save(new StockElement(23.00, 15.00, "Mendels"));

        medicineRepository.save(new Medicine(new Date(), medicineElement, "Panadol", 0.05));
        BeautyProduct beautyProduct = beautyProductRepository.save(new BeautyProduct(new Date(), beautyProductElement, "Pantene Shampoo", new ArrayList<>()));

        List<MarketResearch> researchs = new ArrayList<>();
        researchs.add(new MarketResearch(0.7, beautyProduct));
        researchs.add(new MarketResearch(0.9, beautyProduct));
        researchs.add(new MarketResearch(0.8, beautyProduct));
        researchs = marketResearchRepository.save(researchs);
        beautyProduct.setMarketResearchs(researchs);
        beautyProductRepository.save(beautyProduct);
    }

    @Test
    public void readSinglePack() throws Exception {
        mockMvc.perform(get("/product-packs/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.data.productPacks[0].beautyProduct", is("Pantene Shampoo")));
    }

    @Test
    public void createMedicine() throws Exception {
        StockElement medicineElement = stockElementRepository.save(new StockElement(11.00, 10.00, "Hospital Z"));

        String medicineJson = json(new Medicine(
                new Date(), medicineElement, "Peptobismol", 0.15));

        this.mockMvc.perform(post("/medicines/")
                .contentType(contentType)
                .content(medicineJson))
                .andExpect(status().isCreated());
    }

    protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }
}
