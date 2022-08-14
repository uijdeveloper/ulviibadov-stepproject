package az.abbtech.phonebook.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhonebookReqDto {
    private String userId;
    private String name;
    private String phone;
}
