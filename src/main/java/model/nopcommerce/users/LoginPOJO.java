package model.nopcommerce.users;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginPOJO {
    private String email;
    private String password;
}
