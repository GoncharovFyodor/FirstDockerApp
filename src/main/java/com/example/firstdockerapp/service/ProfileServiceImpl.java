package com.example.firstdockerapp.service;

import com.example.firstdockerapp.entity.Answer;
import com.example.firstdockerapp.entity.Level;
import com.example.firstdockerapp.entity.Profile;
import com.example.firstdockerapp.exception.LevelNotFoundException;
import com.example.firstdockerapp.exception.ProfileNotFoundException;
import com.example.firstdockerapp.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public Profile findBy(Integer id) {
        return profileRepository.findById(id)
                .orElseThrow(()->new ProfileNotFoundException("Profile with id "+id+" not found"));
    }

    @Override
    public List<Profile> findAll() {
        List<Profile> profiles = profileRepository.findAll();
        if (profiles.isEmpty())
            throw new ProfileNotFoundException("No profiles found in database");
        return profiles;
    }

    @Override
    public void save(Profile profile) {
        profileRepository.save(profile);
    }

    @Override
    public void update(Profile profile, Integer id) {
        Profile profileById = findBy(id);
        profileById.setName(profile.getName());
        profileRepository.save(profileById);
    }

    @Override
    public void delete(Integer id) {
        profileRepository.delete(findBy(id));
    }
}
