package repository;

import entity.WeatherHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface WeatherHistoryRepository extends JpaRepository<WeatherHistory, Date> {
}
