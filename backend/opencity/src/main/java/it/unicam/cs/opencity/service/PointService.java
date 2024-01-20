package it.unicam.cs.opencity.service;

import it.unicam.cs.opencity.entity.Point;
import it.unicam.cs.opencity.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PointService {

    private final PointRepository pointRepository;

    @Autowired
    public PointService(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    public boolean addPoint(Point point) {
        pointRepository.save(point);
        return true;
    }

    public Optional<Point> getPointDetails(Integer pointId) {
        return pointRepository.findById(pointId);
    }

    public boolean deletePoint(Integer pointId) {
        if(pointRepository.existsById(pointId)) {
            pointRepository.deleteById(pointId);
            return true;
        }
        return false;
    }

}
