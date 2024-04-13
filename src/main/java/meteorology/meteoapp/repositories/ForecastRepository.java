package meteorology.meteoapp.repositories;

import meteorology.meteoapp.entities.ForecastEntity;
import org.springframework.data.repository.CrudRepository;


public interface ForecastRepository extends CrudRepository<ForecastEntity, Integer>{
}
