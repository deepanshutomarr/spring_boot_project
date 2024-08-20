package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class LoadService {

    @Autowired
    private LoadRepository loadRepository;

    public Load saveLoad(Load load) {
        return loadRepository.save(load);
    }

    public List<Load> getLoadsByShipperId(String shipperId) {
        return loadRepository.findByShipperId(shipperId);
    }

    public Load getLoadById(UUID loadId) {
        return loadRepository.findById(loadId).orElseThrow(() -> new RuntimeException("Load not found"));
    }

    public Load updateLoad(UUID loadId, Load loadDetails) {
        Load load = getLoadById(loadId);
        load.setLoadingPoint(loadDetails.getLoadingPoint());
        load.setUnloadingPoint(loadDetails.getUnloadingPoint());
        load.setProductType(loadDetails.getProductType());
        load.setTruckType(loadDetails.getTruckType());
        load.setNoOfTrucks(loadDetails.getNoOfTrucks());
        load.setWeight(loadDetails.getWeight());
        load.setComment(loadDetails.getComment());
        load.setDate(loadDetails.getDate());
        return loadRepository.save(load);
    }

    public void deleteLoad(UUID loadId) {
        loadRepository.deleteById(loadId);
    }
}
