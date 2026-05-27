
package  com.maincraft.contactformbackend;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")

public class ContactController {

    private final ContactRepository repository;

    public ContactController(ContactRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/contact")

    public String handleContact(

            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String message) {

        Contact contact = new Contact();

        contact.setName(name);
        contact.setEmail(email);
        contact.setMessage(message);

        repository.save(contact);

        return "Form Submitted Successfully";
    }

    @GetMapping("/contacts")

    public List<Contact> getContacts() {

        return repository.findAll();
    }
}
