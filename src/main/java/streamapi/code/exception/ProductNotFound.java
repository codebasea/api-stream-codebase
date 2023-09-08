package streamapi.code.exception;

public class ProductNotFound extends Exception{
    static String notFound = "Product Key Invalid, Try some other Key.";
    public ProductNotFound(){
        super(notFound);
    }
}
