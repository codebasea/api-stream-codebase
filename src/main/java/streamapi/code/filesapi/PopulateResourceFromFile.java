package streamapi.code.filesapi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import streamapi.code.model.Customer;
import streamapi.code.model.Product;
import streamapi.code.model.ProductDto;
import streamapi.code.model.Todos;
import streamapi.code.model.Users;
import streamapi.code.utils.JsonUtils;
import streamapi.code.utils.LoggerInfoPrintln;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static streamapi.code.constant.StreamConstant.ENDPOINT_PREFIX_SUBSTRING;
import static streamapi.code.constant.StreamConstant.GENERATE_PRODUCT_JSON_FILE;
import static streamapi.code.constant.StreamConstant.GENERATE_USERS_JSON_FILE;
import static streamapi.code.constant.StreamConstant.REQUEST_ENDPOINT_JSON_PRODUCT_URL;
import static streamapi.code.constant.StreamConstant.REQUEST_ENDPOINT_JSON_USERS_URL;
import static streamapi.code.constant.StreamConstant.REQUEST_ENDPOINT_JSON_TODOS_URL;
import static streamapi.code.constant.StreamConstant.GENERATE_TODOS_JSON_FILE;

public class PopulateResourceFromFile {
    public static void main(String[] args) {
        castTodosUrlToJsonFile();

    }
    public static void castProductsUrlToJsonFile(){
        PopulateResourceFromFile populateResourceFromFile = new PopulateResourceFromFile();
        ProductDto result = populateResourceFromFile.sendProductDtoToTopicFromFiles(REQUEST_ENDPOINT_JSON_PRODUCT_URL);
        JsonUtils.createJsonFile(GENERATE_PRODUCT_JSON_FILE, result);
        LoggerInfoPrintln.prettyLogInfo("Json File created ", GENERATE_PRODUCT_JSON_FILE);
    }

    public static void castUsersUrlToJsonFile(){
        PopulateResourceFromFile populateResourceFromFile = new PopulateResourceFromFile();
        List<Users> result = populateResourceFromFile.sendUsersDtoToTopicFromFiles(REQUEST_ENDPOINT_JSON_USERS_URL);
        JsonUtils.createJsonFile(GENERATE_USERS_JSON_FILE, result);
        LoggerInfoPrintln.prettyLogInfo("Json File created ", GENERATE_USERS_JSON_FILE);
    }

    public static void castTodosUrlToJsonFile(){
        PopulateResourceFromFile populateResourceFromFile = new PopulateResourceFromFile();
//        List<Todos> result = populateResourceFromFile.createTodosFileFromUrl(REQUEST_ENDPOINT_JSON_TODOS_URL);
        List<Todos> result = populateResourceFromFile.createTodosFileFromUrl(GENERATE_TODOS_JSON_FILE);
//        JsonUtils.createJsonFile(GENERATE_TODOS_JSON_FILE, result);
//        LoggerInfoPrintln.prettyLogInfo("Json File created ", GENERATE_USERS_JSON_FILE);
        ListCustomDataToMapTemplate.groupListOfTodoObjectsIntoMap(result);

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

    public List<Users> sendUsersDtoToTopicFromFiles(String urlString) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Users>  result = new ArrayList<>();
        try {

            if (urlString.contains(ENDPOINT_PREFIX_SUBSTRING)) {
                return objectMapper.readValue(new URL(urlString),  new TypeReference<List<Users>>() {
                });
            }
            return objectMapper.readValue(new File(urlString),   new TypeReference<List<Users>>() {
            });

        } catch (Exception ex) {
            System.out.println("Exception : sendProductToTopicFromFiles : " + ex.getMessage());

        }
        return result;
    }
     public List<Todos> createTodosFileFromUrl(String urlString) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Todos>  result = new ArrayList<>();
        try {

            if (urlString.contains(ENDPOINT_PREFIX_SUBSTRING)) {
                return objectMapper.readValue(new URL(urlString),  new TypeReference<List<Todos>>() {
                });
            }
            return objectMapper.readValue(new File(urlString),   new TypeReference<List<Todos>>() {
            });

        } catch (Exception ex) {
            System.out.println("Exception : sendProductToTopicFromFiles : " + ex.getMessage());

        }
        return result;
    }


}
