package streamapicodegroup.streamapicode.filesapi.utils;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import streamapicodegroup.streamapicode.model.Customer;
import streamapicodegroup.streamapicode.model.User;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.List;

import static com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT;
import static streamapicodegroup.streamapicode.filesapi.utils.constant.StreamConstant.CUSTOMER_LIST_JSON_FILE_PATH_64KB;

public class JsonUtils {

    public static String generateJsonWithWriter(Object object) {
        try {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            return ow.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String generateJson(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createJsonFile(String fileName, Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        Object json = null;
        try {
            objectMapper.configure(INDENT_OUTPUT, true);
            objectMapper.writeValue(new File(fileName), object);
            json = objectMapper.readValue(objectMapper.writeValueAsString(object), Object.class);
            String output = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
            System.out.println("============\n"+output);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
