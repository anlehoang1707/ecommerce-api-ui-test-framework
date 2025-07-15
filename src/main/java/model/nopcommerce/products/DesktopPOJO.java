package model.nopcommerce.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DesktopPOJO extends ProductPOJO {
    private String processor;
    private String processorPrice;
    private String ram;
    private Float ramPrice;
    private String hdd;
    private Float hddPrice;
    private String os;
    private Float osPrice;
    private List<String> software;
    private List<Float> softwarePriceList;

    @Override
    protected void configure() {

    }

    public void configureBuildYourOwnDesktop(String processor, String ram, String hdd, String os, List<String> software) {
        this.processor = processor;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.software = software;
        this.ramPrice = extractedFloatPrice(ram);
        this.hddPrice = extractedFloatPrice(hdd);
        this.osPrice = extractedFloatPrice(os);
        List<Float> prices = new ArrayList<>();
        for (String item : software) {
            prices.add(extractedFloatPrice(item));
        }
        this.softwarePriceList = prices;

    }
}
