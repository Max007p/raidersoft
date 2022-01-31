package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "weather_history")
public class WeatherHistory {
    @Id
    @Temporal(TemporalType.DATE)
    @Column(name = "weather_date")
    private Date weatherDate;

    @Column(name = "weather_value")
    private String weatherValue;

    public WeatherHistory(Date weatherDate, String weatherValue) {
        this.weatherDate = weatherDate;
        this.weatherValue = weatherValue;
    }

    public WeatherHistory() {
    }

    public Date getWeatherDate() {
        return weatherDate;
    }

    public void setWeatherDate(Date weatherDate) {
        this.weatherDate = weatherDate;
    }

    public String getWeatherValue() {
        return weatherValue;
    }

    public void setWeatherValue(String weatherValue) {
        this.weatherValue = weatherValue;
    }
}
