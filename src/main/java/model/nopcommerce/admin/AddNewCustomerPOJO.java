package model.nopcommerce.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddNewCustomerPOJO {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String gender;
    private String companyName;
    private String customerRoles;
    private boolean active;
    private String adminComment;
}
