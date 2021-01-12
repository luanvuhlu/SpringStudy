package com.case6.quizchallengeweb.service.user.appuser;

import com.case6.quizchallengeweb.model.question.Question;
import com.case6.quizchallengeweb.model.user.AppUser;
import com.case6.quizchallengeweb.repository.user.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserService implements IAppUserService {
    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public Iterable<AppUser> getAll() {
        return appUserRepository.findAll();
    }

    @Override
    public AppUser save(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Override
    public Optional<AppUser> findById(Long id) {
        return appUserRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        appUserRepository.deleteById(id);
    }



}
