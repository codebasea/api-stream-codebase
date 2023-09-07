package streamapicodegroup.streamapicode.filesapi.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import streamapicodegroup.streamapicode.model.Customer;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static streamapicodegroup.streamapicode.filesapi.utils.constant.StreamConstant.ENDPOINT_PREFIX_SUBSTRING;

public class PopulateResourceFromFile {
    public List<Customer> sendEventsToTopicFromFiles(String urlString) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Customer> customersList = new ArrayList<>();
        try {

            if(urlString.contains(ENDPOINT_PREFIX_SUBSTRING)){
               return objectMapper.readValue(new URL(urlString), new TypeReference<List<Customer>>() {
                });
            }
            return objectMapper.readValue(new File(urlString), new TypeReference<List<Customer>>() {
            });

        } catch (Exception ex) {
            System.out.println("Exception : sendEventsToTopicFromFiles : "+ ex.getMessage());

        }
        return customersList;
    }
}
