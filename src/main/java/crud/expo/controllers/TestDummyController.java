package crud.expo.controllers;

import crud.expo.models.TestDummy;
import crud.expo.services.TestDummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestDummyController {
    @Autowired
    private TestDummyService testDummyService;

    @PostMapping("/addTestDummy")
    public ResponseEntity<String> addTestDummy(@RequestBody TestDummy testDummy)
    {
        this.testDummyService.addTestDummy(testDummy);
        return new ResponseEntity<>("added successfully", HttpStatus.OK );
    }

}
