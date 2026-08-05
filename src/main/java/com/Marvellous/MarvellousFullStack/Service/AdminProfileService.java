package com.Marvellous.MarvellousFullStack.Service;

import com.Marvellous.MarvellousFullStack.Entity.AdminProfile;
import com.Marvellous.MarvellousFullStack.Repository.AdminProfileRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminProfileService {

    @Autowired
    private AdminProfileRepository repository;

    public List<AdminProfile> getAllProfiles() {
        return repository.findAll();
    }

    public Optional<AdminProfile> getProfileById(ObjectId id) {
        return repository.findById(id);
    }

    public AdminProfile saveProfile(AdminProfile profile) {
        return repository.save(profile);
    }

    public void deleteProfile(ObjectId id) {
        repository.deleteById(id);
    }
}