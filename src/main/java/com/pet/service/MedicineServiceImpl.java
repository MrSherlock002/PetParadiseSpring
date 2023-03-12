package com.pet.service;

import com.pet.entities.Medicine;
import com.pet.exception.MedicineNotFoundException;
import com.pet.repository.IMedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// business logic for medicine service
@Service
public class MedicineServiceImpl implements IMedicineService {

    @Autowired
    private IMedicineRepository medicineRepository;

    public MedicineServiceImpl(IMedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    @Override
    public Medicine addMedicine(Medicine medicine) {
        return medicineRepository.saveAndFlush(medicine);
    }

    @Override
    public Medicine viewMedicine(Medicine medicine) throws MedicineNotFoundException {
        if (medicineRepository.existsById(medicine.getMedicineId())) {
            System.out.println(medicineRepository.findById(medicine.getMedicineId()).get());
            return medicineRepository.findById(medicine.getMedicineId()).get();
        } else {
            throw new MedicineNotFoundException("Medicine Not Found");
        }
    }

    @Override
    public Medicine updateMedicine(Medicine medicine) throws MedicineNotFoundException {
        if (medicineRepository.existsById(medicine.getMedicineId())) {
            return medicineRepository.saveAndFlush(medicine);
        } else {
            throw new MedicineNotFoundException("Medicine Not Found");
        }
    }

    @Override
    public Medicine deleteMedicine(int medicineId) throws MedicineNotFoundException {
        if (medicineRepository.existsById(medicineId)) {
            medicineRepository.deleteById(medicineId);
            return null;
        } else {
            throw new MedicineNotFoundException("Medicine Not Found");
        }
    }

    @Override
    public List<Medicine> showAllMedicine() {
        return medicineRepository.findAll();
    }
}
