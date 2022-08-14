package az.abbtech.phonebook.frontend.client;

import az.abbtech.phonebook.frontend.model.Phonebook;
import az.abbtech.phonebook.frontend.model.PhonebookOperation;
import az.abbtech.phonebook.frontend.model.PhonebookReqDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "backend", url = "${endpoints.backend}")
public interface PhonebookBackendClient {

//    @GetMapping(value = "phonebook/status",
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    List<Phonebook> getStatus();

    @GetMapping(value = "/phonebook/user/list",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<Phonebook> getAllUsers();

    @PostMapping(value = "/phonebook/user/add",
            produces = MediaType.APPLICATION_JSON_VALUE)
    PhonebookOperation postUser(@RequestBody PhonebookReqDto phonebook);

    @PutMapping(value = "/phonebook/user/edit/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    PhonebookOperation editUser(@RequestBody PhonebookReqDto phonebook);

    @DeleteMapping(value = "/phonebook/user/delete/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    PhonebookOperation deleteUser(@RequestBody PhonebookReqDto phonebook);

}

