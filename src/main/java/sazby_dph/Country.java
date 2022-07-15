package sazby_dph;

import java.util.Objects;

public class Country {

    private String _comment;
    private String iso_duplicate;
    private String iso_duplicate_of;
    private String country;
    private String standard_rate;
    private String reduced_rate;
    private String reduced_rate_alt;
    private String super_reduced_rate;
    private String parking_rate;

    public String get_comment() {
        return _comment;
    }

    public void set_comment(String _comment) {
        this._comment = _comment;
    }

    public String getIso_duplicate() {
        return iso_duplicate;
    }

    public void setIso_duplicate(String iso_duplicate) {
        this.iso_duplicate = iso_duplicate;
    }

    public String getIso_duplicate_of() {
        return iso_duplicate_of;
    }

    public void setIso_duplicate_of(String iso_duplicate_of) {
        this.iso_duplicate_of = iso_duplicate_of;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStandard_rate() {
        return standard_rate;
    }

    public void setStandard_rate(String standard_rate) {
        this.standard_rate = standard_rate;
    }

    public String getReduced_rate() {
        return reduced_rate;
    }

    public void setReduced_rate(String reduced_rate) {
        this.reduced_rate = reduced_rate;
    }

    public String getReduced_rate_alt() {
        return reduced_rate_alt;
    }

    public void setReduced_rate_alt(String reduced_rate_alt) {
        this.reduced_rate_alt = reduced_rate_alt;
    }

    public String isSuper_reduced_rate() {
        return super_reduced_rate;
    }

    public void setSuper_reduced_rate(String super_reduced_rate) {
        this.super_reduced_rate = super_reduced_rate;
    }

    public String getParking_rate() {
        return parking_rate;
    }

    public void setParking_rate(String parking_rate) {
        this.parking_rate = parking_rate;
    }

    @Override
    public String toString() {
        return  "Country: " + country + '\n' +
                "Comment: " + _comment + '\n' +
                "ISO duplicate: " + iso_duplicate + '\n' +
                "ISO duplicate of: " + iso_duplicate_of + '\n' +
                "Standard Rate: " + standard_rate + '\n' +
                "Reduced Rate: " + reduced_rate + '\n' +
                "Reduced Rate alt: " + reduced_rate_alt + '\n' +
                "Super reduced Rate: " + super_reduced_rate + '\n' +
                "Parking Rate='" + parking_rate + '\n';
    }
    public String csvValues() {
        return  _comment + ";" +
                iso_duplicate + ";" +
                iso_duplicate_of + ";" +
                country + ";" +
                standard_rate + ";" +
                reduced_rate + ";" +
                reduced_rate_alt + ";" +
                super_reduced_rate + ";" +
                parking_rate + "\n";
    }
}
