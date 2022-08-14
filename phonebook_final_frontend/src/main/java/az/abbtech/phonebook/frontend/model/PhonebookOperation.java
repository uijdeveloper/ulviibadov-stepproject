package az.abbtech.phonebook.frontend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhonebookOperation {

    private String userId;
    private String operationType;
    private String operationStatus;
}
