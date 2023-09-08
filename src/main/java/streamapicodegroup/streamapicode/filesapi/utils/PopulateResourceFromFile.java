package streamapicodegroup.streamapicode.filesapi.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import streamapicodegroup.streamapicode.model.Customer;
import streamapicodegroup.streamapicode.model.Product;
import streamapicodegroup.streamapicode.model.ProductDto;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static streamapicodegroup.streamapicode.filesapi.utils.constant.StreamConstant.ENDPOINT_PREFIX_SUBSTRING;

public class PopulateResourceFromFile {
    public static void main(String[] args) {
        String urlString = "https://dummyjson.com/products";
        PopulateResourceFromFile populateResourceFromFile = new PopulateResourceFromFile();
        ProductDto result = populateResourceFromFile.sendProductDtoToTopicFromFiles(urlString);
//        System.out.println(JsonUtils.generateJson(result));

        String fileName = "src/main/resources/mock/Product.json";
        JsonUtils.createJsonFile(fileName, result);
    }

    public List<Customer> sendEventsToTopicFromFiles(String urlString) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Customer> customersList = new ArrayList<>();
        try {

            if (urlString.contains(ENDPOINT_PREFIX_SUBSTRING)) {
                return objectMapper.readValue(new URL(urlString), new TypeReference<List<Customer>>() {
                });
            }
            return objectMapper.readValue(new File(urlString), new TypeReference<List<Customer>>() {
            });

        } catch (Exception ex) {
            System.out.println("Exception : sendEventsToTopicFromFiles : " + ex.getMessage());

        }
        return customersList;
    }

    public ProductDto sendProductDtoToTopicFromFiles(String urlString) {
        ObjectMapper objectMapper = new ObjectMapper();
        ProductDto productDto = new ProductDto();
        try {

            if (urlString.contains(ENDPOINT_PREFIX_SUBSTRING)) {
                return objectMapper.readValue(new URL(urlString), new TypeReference<ProductDto>() {
                });
            }
            return objectMapper.readValue(new File(urlString), new TypeReference<ProductDto>() {
            });

        } catch (Exception ex) {
            System.out.println("Exception : sendProductToTopicFromFiles : " + ex.getMessage());

        }
        return productDto;
    }


    public List<Product> sendProductListToTopicFromFiles(String urlString) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Product> productList = new ArrayList<>();
        try {

            if (urlString.contains(ENDPOINT_PREFIX_SUBSTRING)) {
                return objectMapper.readValue(new URL(urlString), new TypeReference<List<Product>>() {
                });
            }
            return objectMapper.readValue(new File(urlString), new TypeReference<List<Product>>() {
            });

        } catch (Exception ex) {
            System.out.println("Exception : sendProductToTopicFromFiles : " + ex.getMessage());

        }
        return productList;
    }
}
