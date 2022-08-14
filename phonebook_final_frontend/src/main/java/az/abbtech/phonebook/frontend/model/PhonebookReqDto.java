package az.abbtech.phonebook.frontend.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PhonebookReqDto {
    private String userId;
    private String name;
    private String phone;
}
