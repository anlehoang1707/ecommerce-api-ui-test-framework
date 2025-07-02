package api.response.factory;

public class ResponseFactoryCreator {
    private ResponseFactoryCreator(){}

    public static ResponseFactory getFactory() {
        return new ResponseFactory();
    }
}
