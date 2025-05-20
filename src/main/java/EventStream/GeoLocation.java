package EventStream;

import org.jetbrains.annotations.NotNull;

public class GeoLocation {
    private final double latitude;
    private final double longitude;

    GeoLocation(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "GeoLocation{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    public static double distance(@NotNull GeoLocation a, @NotNull GeoLocation b) {
        return Math.abs(a.getLatitude() - b.getLatitude()) + Math.abs(a.getLongitude() - b.getLongitude());
    }
}
