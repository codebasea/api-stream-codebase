package streamapi.code.filesapi;

import streamapi.code.constant.StreamConstant;
import streamapi.code.model.Customer;
import streamapi.code.utils.JsonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomersCastToMapTemplate {

    public static void main(String[] args) {
        JsonUtils jsonUtils = new JsonUtils();

//        String path =  "C:\\Drive_D\\codebase\\development\\stream-api-code\\src\\main\\resources\\mock\\11164KB.json";;
        PopulateResourceFromFile populateResourceFromFile = new PopulateResourceFromFile();
        List<Customer> customerList = populateResourceFromFile.sendEventsToTopicFromFiles(StreamConstant.CUSTOMER_LIST_JSON_FILE_PATH_64KB);
//        List<Customer> customerList =  populateResourceFromFile.sendEventsToTopicFromFiles(path);
//        customerList.forEach(System.out::println);

        castCustomerMapWithIdAndCustomer(customerList);
//        handleDuplicateKeysInMap(customerList);
//        convertingListOfObjectsToCountMap(customerList);

//        groupListOfCustomObjectsIntoMap(customerList);
//        groupListOfCustomObjectsIntoMapV2(customerList);
//        listToMapWithKeyAndCustomers(customerList);

    }

    private static Map<String, List<Customer>> groupListOfCustomObjectsIntoMap(List<Customer> customerList) {
        Map<String, List<Customer>> groupByIdCustomers = customerList.stream().collect(Collectors.groupingBy(Customer::getId));
        groupByIdCustomers.entrySet().forEach(System.out::println);
        System.out.println("groupListOfCustomObjectsIntoMap : \n" + JsonUtils.generateJson(groupByIdCustomers));
        return groupByIdCustomers;
    }

    private static Map<String, List<Customer>> groupListOfCustomObjectsIntoMapV2(List<Customer> customerList) {
        Map<String, List<Customer>> customersMap = new HashMap<>();
        customerList.forEach(customer -> {
            customersMap.computeIfAbsent(customer.getId(), k -> new ArrayList<>()).add(customer);
        });


        customersMap.entrySet().forEach(System.out::println);
        System.out.println("groupListOfCustomObjectsIntoMap : \n" + JsonUtils.generateJson(customersMap));
        return customersMap;
    }

    private static Map<String, Customer> handleDuplicateKeysInMap(List<Customer> customerList) {
        Map<String, Customer> listToMap = customerList.stream().collect(Collectors.toMap(Customer::getId, Function.identity(), (first, second) -> first));
//        listToMap.entrySet().forEach(System.out::println);
        System.out.println("castCustomerMapWithIdAndCustomer : \n" + JsonUtils.generateJson(listToMap));
        return listToMap;
    }
    private static Map<String, Customer> castCustomerMapWithIdAndCustomer(List<Customer> customerList) {
        Map<String, Customer> listToMap = customerList.stream().collect(Collectors.toMap(Customer::getId, customer -> customer, (first, second) -> first));
//        Map<String, Customer> listToMap = customerList.stream().collect(Collectors.toMap(Customer::getId, Function.identity()));
//        listToMap.entrySet().forEach(System.out::println);
        System.out.println("castCustomerMapWithIdAndCustomer : \n" + JsonUtils.generateJson(listToMap));
        return listToMap;
    }



    private static Map<Double, List<Customer>> listToMapWithKeyAndCustomers(List<Customer> customerList) {
        Map<Double, List<Customer>> listToMapWithKeyAndCustomers = customerList.stream().collect(Collectors.groupingBy(Customer::getVersion));
        listToMapWithKeyAndCustomers.entrySet().forEach(System.out::println);
        System.out.println("listToMapWithKeyAndCustomers : \n" + JsonUtils.generateJson(listToMapWithKeyAndCustomers));
        return listToMapWithKeyAndCustomers;
    }

    private static Map<String, Double> convertingListOfObjectsToCountMap(List<Customer> customerList) {

        Map<String, Double> listToMapKeyAndCustomerCount = customerList.stream().collect(Collectors.groupingBy(Customer::getId, Collectors.summingDouble(Customer::getVersion)));
        listToMapKeyAndCustomerCount.entrySet().forEach(System.out::println);
        return listToMapKeyAndCustomerCount;
    }

}
