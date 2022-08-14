package az.abbtech.phonebook.service;

import az.abbtech.phonebook.dto.request.PhonebookReqDto;
import az.abbtech.phonebook.dto.response.PhonebookRespDto;
import az.abbtech.phonebook.entity.Phonebook;

import java.util.List;

public interface PhonebookService {
    PhonebookRespDto addToPhonebook(PhonebookReqDto phonebook);

    PhonebookRespDto edit(PhonebookReqDto request);

    PhonebookRespDto remove(PhonebookReqDto request);

    List<Phonebook> getUsers();
}
