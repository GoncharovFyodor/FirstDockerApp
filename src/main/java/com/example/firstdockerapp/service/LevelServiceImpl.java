package com.example.firstdockerapp.service;

import com.example.firstdockerapp.entity.Level;
import com.example.firstdockerapp.exception.LevelNotFoundException;
import com.example.firstdockerapp.repository.LevelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LevelServiceImpl implements LevelService {
    @Autowired
    private LevelRepository levelRepository;

    @Override
    public Level findBy(Integer id) {
        return levelRepository.findById(id)
                .orElseThrow(()->new LevelNotFoundException("Level with id "+id+" not found"));
    }

    @Override
    public List<Level> findAll() {
        List<Level> levels = levelRepository.findAll();
        if (levels.isEmpty())
            throw new LevelNotFoundException("No levels found in database");
        return levels;
    }

    @Override
    public void save(Level level) {
        levelRepository.save(level);
    }

    @Override
    public void update(Level level, Integer id) {
        Level levelById = findBy(id);
        levelById.setName(level.getName());
        levelRepository.save(levelById);
    }

    @Override
    public void delete(Integer id) {
        levelRepository.delete(findBy(id));
    }
}
