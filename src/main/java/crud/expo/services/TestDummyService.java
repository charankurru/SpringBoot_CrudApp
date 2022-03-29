package crud.expo.services;

import crud.expo.Repository.TestDummyRepo;
import crud.expo.models.TestDummy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestDummyService {
    @Autowired
    private TestDummyRepo testDummyRepo;

    public void addTestDummy(TestDummy testDummy) {

        /*
        * 1) pre-validate the fields which are non-nullable
        * 2) uniqueFields ==> Check the database whether any record exists
        *                     if exists return
        *                     else save record
        * */

        try {
            this.testDummyRepo.save(testDummy);
        }
        catch (Exception e)
        {
            System.out.println("ERROR YASHWANTH: ==> "+e.getMessage());
        }
    }
}
