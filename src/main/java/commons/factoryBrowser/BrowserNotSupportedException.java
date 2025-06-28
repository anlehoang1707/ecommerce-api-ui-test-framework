package commons.factoryBrowser;

public class BrowserNotSupportedException extends IllegalArgumentException {
    public BrowserNotSupportedException(String browser) {
        super(String.format("Browser name % not supported",browser));
    }
}
