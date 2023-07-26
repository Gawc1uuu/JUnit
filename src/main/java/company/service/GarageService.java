package company.service;

import company.model.Garage;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class GarageService {

    public List<Garage> findAllEmptyGarages(List<Garage> garages) {
        return Optional.ofNullable(garages).orElseGet(Collections::emptyList)
                .stream().filter(Objects::nonNull).filter(garage -> garage.getCarParked() == null)
                .toList();
    }

}
