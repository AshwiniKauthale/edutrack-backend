package com.Marvellous.MarvellousFullStack.Controller;

import com.Marvellous.MarvellousFullStack.Entity.AdminProfile;
import com.Marvellous.MarvellousFullStack.Service.AdminProfileService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
@CrossOrigin(origins = "http://localhost:5173")
public class AdminProfileController {

    @Autowired
    private AdminProfileService profileService;

    @GetMapping
    public ResponseEntity<List<AdminProfile>> getAllProfiles() {
        return ResponseEntity.ok(profileService.getAllProfiles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProfile(@PathVariable ObjectId id) {

        return profileService.getProfileById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AdminProfile> addProfile(
            @RequestBody AdminProfile profile) {

        return new ResponseEntity<>(
                profileService.saveProfile(profile),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProfile(
            @PathVariable ObjectId id,
            @RequestBody AdminProfile profile) {

        return profileService.getProfileById(id)
                .map(oldProfile -> {

                    oldProfile.setName(profile.getName());
                    oldProfile.setEmail(profile.getEmail());
                    oldProfile.setMobile(profile.getMobile());
                    oldProfile.setDesignation(profile.getDesignation());
                    oldProfile.setAddress(profile.getAddress());
                    oldProfile.setProfileImage(profile.getProfileImage());

                    profileService.saveProfile(oldProfile);

                    return ResponseEntity.ok(oldProfile);

                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProfile(
            @PathVariable ObjectId id) {

        profileService.deleteProfile(id);

        return ResponseEntity.noContent().build();
    }
}