package az.abbtech.phonebook.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhonebookRespDto {

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("operationType")
    private String operationType;

    @JsonProperty("operationStatus")
    private String operationStatus;
}
