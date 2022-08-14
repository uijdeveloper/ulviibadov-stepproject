package az.abbtech.phonebook.service.impl;

import az.abbtech.phonebook.constatns.Constatns;
import az.abbtech.phonebook.dto.request.PhonebookReqDto;
import az.abbtech.phonebook.dto.response.PhonebookRespDto;
import az.abbtech.phonebook.entity.Phonebook;
import az.abbtech.phonebook.repository.PhonebookRepository;
import az.abbtech.phonebook.service.PhonebookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PhonebookServiceImpl implements PhonebookService {

    private final PhonebookRepository phonebookRepository;

    @Override
    public PhonebookRespDto addToPhonebook(PhonebookReqDto phonebook) {

        try {
            Phonebook savedPhonebook = phonebookRepository.save(
                    Phonebook
                            .builder()
                            .phoneNumber(phonebook.getPhone())
                            .userName(phonebook.getName())
                            .build()
            );

            return PhonebookRespDto.builder().operationType("add")
                    .userId(savedPhonebook.getId())
                    .operationStatus(Constatns.SUCCESS)
                    .build();
        } catch (Exception e) {
            return PhonebookRespDto.builder().operationType("add")
                    .userId(phonebook.getUserId())
                    .operationStatus(Constatns.FAIL)
                    .build();
        }
    }

    @Override
    public PhonebookRespDto edit(PhonebookReqDto request) {
        try {
            Phonebook editedPhoneBook = phonebookRepository.findPhoneBookEntityById(request.getUserId());
            editedPhoneBook.setPhoneNumber(request.getPhone());
            editedPhoneBook.setUserName(request.getName());

            phonebookRepository.save(editedPhoneBook);
            return PhonebookRespDto.builder().operationType("edit")
                    .userId(request.getUserId())
                    .operationStatus(Constatns.SUCCESS)
                    .build();
        } catch (Exception e) {
            return PhonebookRespDto.builder().operationType("edit")
                    .userId(request.getUserId())
                    .operationStatus(Constatns.FAIL)
                    .build();
        }
    }

    @Override
    public PhonebookRespDto remove(PhonebookReqDto request) {
        try {
            Phonebook removedPhoneBook = phonebookRepository.findPhoneBookEntityById(request.getUserId());
            phonebookRepository.delete(removedPhoneBook);
            return PhonebookRespDto.builder().operationType("delete")
                    .userId(removedPhoneBook.getId())
                    .operationStatus(Constatns.SUCCESS)
                    .build();
        } catch (Exception e) {
            return PhonebookRespDto.builder().operationType("delete")
                    .userId(request.getUserId())
                    .operationStatus(Constatns.FAIL)
                    .build();
        }
    }

    @Override
    public List<Phonebook> getUsers() {
        return phonebookRepository.findAll();
    }
}
