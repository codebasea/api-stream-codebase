package streamapi.code.constant;

import java.util.Objects;
import java.util.function.Predicate;

public class StreamConstant {
    public static final String REQUEST_ENDPOINT_JSON_DUMMY_DATA_64_KB  = "https://microsoftedge.github.io/Demos/json-dummy-data/64KB.json";
    public static final String  ENDPOINT_PREFIX_SUBSTRING = "https://";
    public static final String  CUSTOMER_LIST_JSON_FILE_PATH_64KB = "src/main/resources/mock/64KB.json";
    public static final String PATTERN = "yyyy-MM-dd HH:mm:ss.S";
    public static final String  GENERATE_PRODUCT_JSON_FILE = "src/main/resources/mock/Product.json";
    public static final String  REQUEST_ENDPOINT_JSON_PRODUCT_URL ="https://dummyjson.com/products";
    public static final String  GENERATE_USERS_JSON_FILE = "src/main/resources/mock/Users.json";
    public static final String  REQUEST_ENDPOINT_JSON_USERS_URL = "https://jsonplaceholder.typicode.com/users";

    public static final String  GENERATE_TODOS_JSON_FILE = "src/main/resources/mock/Todos.json";
    public static final String  REQUEST_ENDPOINT_JSON_TODOS_URL = "https://jsonplaceholder.typicode.com/todos";

    /** Predicate
     *
     */
    public static final Predicate<String> isNull= Objects::isNull;
    public static final Predicate<String> nonNull= Objects::nonNull;
    public static final Predicate<String> isEmpty= String::isEmpty;
    public static final Predicate<String> nonEmpty= string -> !string.isEmpty();
    public static final Predicate<String> isNullOrEmpty= isNull.or(isEmpty);
    public static final Predicate<String> isNullAndEmpty= isNull.and(isEmpty);
}
