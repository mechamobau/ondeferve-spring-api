package br.com.ondeferve.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ondeferve.api.model.Photo;
import br.com.ondeferve.api.repositories.PhotoRepository;

@Service
public class PhotoService implements ServiceInterface<Photo> {

    @Autowired
    private PhotoRepository photoRepo;

    public PhotoService() {
    }

    public List<Photo> findByEventId(Long id) {
        return photoRepo.findByEventId(id);
    }

    @Override
    public Photo create(Photo obj) {
        photoRepo.save(obj);
        return obj;
    }

    @Override
    public Photo findById(Long id) {
        Optional<Photo> _photo = photoRepo.findById(id);
        return _photo.orElse(null);
    }

    @Override
    public List<Photo> findAll() {
        return photoRepo.findAll();

    }

    @Override
    public boolean update(Photo obj) {
        if (photoRepo.existsById(obj.getId())) {
            photoRepo.save(obj);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        Optional<Photo> _photo = photoRepo.findById(id);
        if (_photo.isPresent()) {
            photoRepo.delete(_photo.get());
            return true;
        }
        return false;
    }
}