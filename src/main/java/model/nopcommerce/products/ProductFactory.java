package model.nopcommerce.products;

public class ProductFactory {
    public static ProductPOJO createProductPOJO(String subCategoryName) {
        ProductSubCategory subCategory = ProductSubCategory.valueOf(subCategoryName.toUpperCase());
        switch (subCategory){
            case NOTEBOOKS:
                return new NoteBookPOJO();
            case DESKTOPS:
                return new DesktopPOJO();
            case CELLPHONES:
                return new CellPhonePOJO();
            default:
                throw new RuntimeException("Sub Category Name is not valid");
        }
    }


}
