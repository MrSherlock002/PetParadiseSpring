package com.pet.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "medicine")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicine_id")
    private int medicineId;

    @NotBlank(message = "Invalid Medicine Name")
    @Column(name = "medicine_name", nullable = false)
    private String medicineName;

    @Column(name = "medicine_cost", nullable = false)
    private float medicineCost;

    @Column(name = "mfd", nullable = false)
    private LocalDate mfd;

    @Column(name = "expiry_date", nullable = false)
    private LocalDate expiryDate;

    @NotBlank(message = "Invalid Company Name")
    @Column(name = "company_name", nullable = false)
    private String companyName;

    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Category category;

    public Medicine() {
    }

    public Medicine(String medicineName, float medicineCost, LocalDate mfd, LocalDate expiryDate, String companyName, Category category) {
        this.medicineName = medicineName;
        this.medicineCost = medicineCost;
        this.mfd = mfd;
        this.expiryDate = expiryDate;
        this.companyName = companyName;
        this.category = category;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName.trim();
    }

    public float getMedicineCost() {
        return medicineCost;
    }

    public void setMedicineCost(float medicineCost) {
        this.medicineCost = medicineCost;
    }

    public LocalDate getMfd() {
        return mfd;
    }

    public void setMfd(LocalDate mfd) {
        this.mfd = mfd;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName.trim();
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "medicineId=" + medicineId +
                ", medicineName='" + medicineName + '\'' +
                ", medicineCost=" + medicineCost +
                ", mfd=" + mfd +
                ", expiryDate=" + expiryDate +
                ", companyName='" + companyName + '\'' +
                ", category=" + category +
                '}';
    }
}