package model.nopcommerce;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterPOJO {
    private String firstName;
    private String lastName;
    private String email;
    private String companyName;
    private String password;
    private String confirmPassword;
}
