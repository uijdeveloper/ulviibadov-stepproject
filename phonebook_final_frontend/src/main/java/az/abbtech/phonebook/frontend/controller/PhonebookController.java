package az.abbtech.phonebook.frontend.controller;

import az.abbtech.phonebook.frontend.client.PhonebookBackendClient;
import az.abbtech.phonebook.frontend.model.Phonebook;
import az.abbtech.phonebook.frontend.model.PhonebookOperation;
import az.abbtech.phonebook.frontend.model.PhonebookReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PhonebookController {

    private final PhonebookBackendClient backendClient;

    @GetMapping("/")
    public String listUsers(Model model) {
        List<Phonebook> phonebooks = backendClient.getAllUsers();
        model.addAttribute("phonebooks", phonebooks);
        model.addAttribute("phonebook", new Phonebook());
        return "user.html";
    }

//    @GetMapping("/status")
//    public String getStatus(Model model) {
//        List<UserEntity> users = backendClient.getStatus();
//        model.addAttribute("users", users);
//        model.addAttribute("userEntity", new UserEntity());
//        return "user.html";
//    }
//
    @PostMapping("/user/add")
    public String addUser(@ModelAttribute Phonebook phonebook, Model model) {

        PhonebookReqDto phonebookReqDto = PhonebookReqDto.builder()
                .phone(phonebook.getPhoneNumber())
                .name(phonebook.getUserName())
                .build();
        PhonebookOperation phonebookOperation = backendClient.postUser(phonebookReqDto);
        model.addAttribute("operation", phonebookOperation);
        return "operation";
    }

    @PostMapping("/user/edit")
    public String editUser(@ModelAttribute Phonebook phonebook, Model model) {
        PhonebookReqDto phonebookReqDto = PhonebookReqDto.builder()
                .userId(phonebook.getId())
                .phone(phonebook.getPhoneNumber())
                .name(phonebook.getUserName())
                .build();
        PhonebookOperation phonebookOperation = backendClient.editUser(phonebookReqDto);
        model.addAttribute("operation", phonebookOperation);
        return "operation";
    }

    @PostMapping("/user/delete")
    public String deleteUser(@ModelAttribute Phonebook phonebook, Model model) {
        System.out.println(phonebook);
        PhonebookReqDto phonebookReqDto = PhonebookReqDto.builder()
                .userId(phonebook.getId())
                .build();
        PhonebookOperation phonebookOperation = backendClient.deleteUser(phonebookReqDto);
        model.addAttribute("operation", phonebookOperation);
        return "operation";
    }
}
