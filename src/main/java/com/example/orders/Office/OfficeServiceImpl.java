package com.example.orders.Office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService{
    @Autowired
    private OfficeRepository officeRepository;

    @Override
    public Office RegisterNewOffice(Office office) {
        return officeRepository.save(office);
    }

    @Override
    public List<Office> GetAllAvailableBranches() {
        List<Office> offices  = new LinkedList<>();
        officeRepository.findAll().forEach(office -> offices.add(office));
        return offices;
    }

    @Override
    public Office GetOfficeByID(Integer id) {
        return  officeRepository.findById(id).get();
    }
}
