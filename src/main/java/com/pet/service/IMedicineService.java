package com.pet.service;


import com.pet.entities.Medicine;
import com.pet.exception.MedicineNotFoundException;

import java.util.List;

// custom service declarations
public interface IMedicineService {

    public Medicine addMedicine(Medicine medicine);

    public Medicine viewMedicine(Medicine medicine) throws MedicineNotFoundException;

    public Medicine updateMedicine(Medicine medicine) throws MedicineNotFoundException;

    public Medicine deleteMedicine(int id) throws MedicineNotFoundException;

    public List<Medicine> showAllMedicine();

}
