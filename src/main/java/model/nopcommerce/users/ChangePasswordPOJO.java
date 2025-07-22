package model.nopcommerce.users;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChangePasswordPOJO {
    private String oldPassword;
    private String newPassword;
    private String confirmNewPassword;
}

