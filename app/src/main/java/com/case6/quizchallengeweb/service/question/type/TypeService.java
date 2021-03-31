package com.case6.quizchallengeweb.service.question.type;

import com.case6.quizchallengeweb.model.question.Type;
import com.case6.quizchallengeweb.repository.question.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TypeService implements ITypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Override
    public Iterable<Type> getAll() {
        return typeRepository.findAll();
    }

    @Override
    public Type save(Type type) {
        return typeRepository.save(type);
    }

    @Override
    public Optional<Type> findById(Long id) {
        return typeRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        typeRepository.deleteById(id);
    }
}
