package model.nopcommerce;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NewUserPOJO {
    private String firstName;
    private String lastName;
    private String email;
    private String companyName;
    private String password;
    private String confirmPassword;
}
