package com.example.orders.Office;

import java.util.List;

public interface OfficeService {
    public Office RegisterNewOffice(Office office);
    public List<Office> GetAllAvailableBranches();
    public Office GetOfficeByID(Integer id);
}
