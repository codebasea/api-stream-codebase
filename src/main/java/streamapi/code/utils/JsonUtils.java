package streamapi.code.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;

import static com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT;
import static streamapi.code.utils.LoggerInfoPrintln.prettyLogInfo;

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

            prettyLogInfo("Json File Details ", output);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
