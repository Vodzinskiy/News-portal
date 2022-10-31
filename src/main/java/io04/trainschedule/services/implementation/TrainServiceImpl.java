package io04.trainschedule.services.implementation;

import io04.trainschedule.models.Station;
import io04.trainschedule.models.Train;
import io04.trainschedule.repositories.TrainRepository;
import io04.trainschedule.services.TrainService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TrainServiceImpl implements TrainService {

    private final TrainRepository trainRepository;

    public TrainServiceImpl(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }
    @Override
    public void save(Train train) {
        trainRepository.save(train);
    }

    @Override
    public void delete(int id) {
        Train train = trainRepository.findById(id);
        for(Station station : train.getArrivalStations().keySet()){
            station.removeTrain(train);
        }
        trainRepository.delete(id);
    }

    @Override
    public Train findByName(String name) {
        return trainRepository.findByName(name);
    }

    @Override
    public Map<Integer, Train> findAll() {
        return trainRepository.findAll();
    }


    @Override
    public Train findById(int id) {
        return trainRepository.findById(id);
    }




}
