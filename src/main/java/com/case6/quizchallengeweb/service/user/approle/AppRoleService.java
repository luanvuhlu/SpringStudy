package com.case6.quizchallengeweb.service.user.approle;

import com.case6.quizchallengeweb.model.user.AppRole;
import com.case6.quizchallengeweb.repository.user.AppRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppRoleService implements IAppRoleService {

    @Autowired
    private AppRoleRepository appRoleRepository;

    @Override
    public Iterable<AppRole> getAll() {
        return appRoleRepository.findAll();
    }

    @Override
    public AppRole save(AppRole appRole) {
        return appRoleRepository.save(appRole);
    }

    @Override
    public Optional<AppRole> findById(Long id) {
        return appRoleRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        appRoleRepository.deleteById(id);
    }

    @Override
    public AppRole findByName(String name) {
        return appRoleRepository.findByName(name);
    }
}
