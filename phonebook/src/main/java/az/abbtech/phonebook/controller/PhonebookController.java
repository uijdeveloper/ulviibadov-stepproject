package az.abbtech.phonebook.controller;

import az.abbtech.phonebook.dto.request.PhonebookReqDto;
import az.abbtech.phonebook.dto.response.PhonebookRespDto;
import az.abbtech.phonebook.entity.Phonebook;
import az.abbtech.phonebook.service.PhonebookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.*;

@AllArgsConstructor
@Validated
@RequestMapping("/user")
@RestController
@Api(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE, tags = "Operations for Phonebook")
@Slf4j
public class PhonebookController {

    private final PhonebookService phonebookService;

    @ApiOperation(value = "Insert user into phonebook")
    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PhonebookRespDto> addUserToPhonebook(@RequestBody PhonebookReqDto request) {
        return new ResponseEntity<>(phonebookService.addToPhonebook(request), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update user in phonebook")
    @PutMapping("/edit/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PhonebookRespDto> editUser( @RequestBody PhonebookReqDto request) {
        return new ResponseEntity<>(phonebookService.edit( request), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete user from phonebook")
    @DeleteMapping("/delete/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PhonebookRespDto> removeUser(@RequestBody PhonebookReqDto request) {
        return new ResponseEntity<>(phonebookService.remove(request), HttpStatus.OK);
    }

    @ApiOperation(value = "Get all users from phonebook")
    @GetMapping(value = "/list")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Phonebook>> getAllUsers() {
        System.out.println(phonebookService.getUsers());
        return new ResponseEntity<>(phonebookService.getUsers(), HttpStatus.OK);
    }

}
