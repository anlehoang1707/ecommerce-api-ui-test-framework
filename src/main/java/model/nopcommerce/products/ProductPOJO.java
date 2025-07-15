package model.nopcommerce.products;

public abstract class ProductPOJO {
    protected String name;
    protected String subCategory;

    protected abstract void configure();

    public Float extractedFloatPrice(String input) {
        if (input != null && input.contains("[+$")) {
            int start = input.indexOf("[+$") + 3;
            int end = input.indexOf("]", start);
            if (start > 2 && end > start) {
                String numberStr = input.substring(start, end);
                try {
                    return Float.parseFloat(numberStr);
                } catch (NumberFormatException e) {
                    System.err.println("can not parse price");
                }
            }
        }
        return 0.0f;
    }
}
