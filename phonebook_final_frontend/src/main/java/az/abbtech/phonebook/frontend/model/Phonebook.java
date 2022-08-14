package az.abbtech.phonebook.frontend.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Phonebook {
    private String id;
    private String userName;
    private String phoneNumber;
}
