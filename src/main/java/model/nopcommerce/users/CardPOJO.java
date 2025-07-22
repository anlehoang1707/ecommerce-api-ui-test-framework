package model.nopcommerce.users;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardPOJO {
    private String cardType;
    private String cardHolderName;
    private String cardNumber;
    private String expirationMonth;
    private String expirationYear;
    private String cardCode;
}
