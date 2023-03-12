package com.pet.controller;

import com.pet.entities.Medicine;
import com.pet.exception.MedicineNotFoundException;
import com.pet.service.MedicineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

// Medicine REST Mappings using medicineService aggregation
@RestController
@RequestMapping("/medicines")
@CrossOrigin(origins = "http://localhost:3000")
public class MedicineController {

    // injects the object dependency
    @Autowired
    private MedicineServiceImpl medicineService;

    // create
    @PostMapping("/add")
    public Medicine addMedicine(@Valid @RequestBody Medicine medicine) {
        return medicineService.addMedicine(medicine);
    }

    // update
    @PutMapping("/update")
    public Medicine updateMedicine(@Valid @RequestBody Medicine medicine) throws MedicineNotFoundException {
        return medicineService.updateMedicine(medicine);
    }

    // delete
    @DeleteMapping("/remove/{medicineId}")
    public Medicine removeMedicine(@PathVariable int medicineId) throws MedicineNotFoundException {
        return medicineService.deleteMedicine(medicineId);
    }

    // read
    @GetMapping("/view/{medicineId}")
    public Medicine getMedicine(@PathVariable int medicineId) throws MedicineNotFoundException {
        Medicine medicine = new Medicine();
        medicine.setMedicineId(medicineId);
        return medicineService.viewMedicine(medicine);
    }

    // read
    @GetMapping("/show")
    public List<Medicine> getAllMedicines() {
        return medicineService.showAllMedicine();
    }
}
