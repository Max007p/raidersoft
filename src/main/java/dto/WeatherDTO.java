package dto;

public class WeatherDTO {
    private String temparature;

    public WeatherDTO(String temparature) {
        this.temparature = temparature;
    }

    public WeatherDTO() {
    }

    public String getTemparature() {
        return temparature;
    }

    public void setTemparature(String temparature) {
        this.temparature = temparature;
    }
}
