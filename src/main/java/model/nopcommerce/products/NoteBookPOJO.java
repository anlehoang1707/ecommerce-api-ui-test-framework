package model.nopcommerce.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteBookPOJO extends ProductPOJO {
    private String productName;
    private String subCategoryName;
    private String hdd;
    private String ram;

    @Override
    protected void configure() {

    }
}
